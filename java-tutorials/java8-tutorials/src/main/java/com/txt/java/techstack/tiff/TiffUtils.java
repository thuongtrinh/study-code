package com.txt.java.techstack.tiff;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.*;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TiffUtils {

    public static void mergeToMultiPageTiff_0_size_good(List<File> inputFiles, File outputFile) throws IOException {
        List<BufferedImage> images = new ArrayList<>();

        // 1. Đọc tất cả các file đầu vào (Giữ nguyên màu sắc gốc)
        for (File file : inputFiles) {
            String fileName = file.getName().toLowerCase();
            if (fileName.endsWith(".pdf")) {
                try (PDDocument document = Loader.loadPDF(file)) {
                    PDFRenderer pdfRenderer = new PDFRenderer(document);
                    for (int page = 0; page < document.getNumberOfPages(); ++page) {
                        // Để tối ưu dung lượng từ PDF, dùng 120-150 DPI là vừa đủ nét
                        BufferedImage bim = pdfRenderer.renderImageWithDPI(page, 120);
                        images.add(bim);
                    }
                }
            } else {
                BufferedImage img = ImageIO.read(file);
                if (img != null) {
                    images.add(img);
                }
            }
        }

        if (images.isEmpty()) {
            throw new IllegalArgumentException("Không tìm thấy dữ liệu ảnh hợp lệ để gộp.");
        }

        // 2. Tìm kiếm TIFF Writer
        Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("TIFF");
        if (!writers.hasNext()) {
            throw new IllegalStateException("Không tìm thấy TIFF ImageWriter. Hãy đảm bảo đã thêm thư viện TwelveMonkeys.");
        }
        ImageWriter writer = writers.next();

        // 3. Cấu hình nén LZW (Lossless - Giữ nguyên màu sắc, tối ưu dung lượng)
        ImageWriteParam writeParam = writer.getDefaultWriteParam();
        if (writeParam.canWriteCompressed()) {
            writeParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            writeParam.setCompressionType("LZW");
        }

        // 4. Sử dụng Sequence chuẩn của ImageIO để ghi một mạch (Tránh trùng lặp Metadata từng trang)
        try (ImageOutputStream ios = ImageIO.createImageOutputStream(outputFile)) {
            writer.setOutput(ios);

            // Bắt đầu chuỗi ghi tuần tự
            writer.prepareWriteSequence(null);

            for (BufferedImage img : images) {
                IIOImage iioImage = new IIOImage(img, null, null);
                // Ghi trực tiếp trang vào chuỗi sequence với param nén LZW
                writer.writeToSequence(iioImage, writeParam);
            }

            // Kết thúc chuỗi ghi và giải phóng vùng đệm
            writer.endWriteSequence();
        } finally {
            writer.dispose();
        }
    }

    public static void mergeToMultiPageTiff_1_medium(List<File> inputFiles, File outputFile) throws IOException {
        List<BufferedImage> images = new ArrayList<>();

        // 1. Đọc tất cả các file đầu vào
        for (File file : inputFiles) {
            String fileName = file.getName().toLowerCase();
            if (fileName.endsWith(".pdf")) {
                try (PDDocument document = Loader.loadPDF(file)) {
                    PDFRenderer pdfRenderer = new PDFRenderer(document);
                    for (int page = 0; page < document.getNumberOfPages(); ++page) {
                        // Render PDF ở độ phân giải 120 DPI để cân bằng chất lượng & kích thước
                        BufferedImage bim = pdfRenderer.renderImageWithDPI(page, 120);
                        images.add(bim);
                    }
                }
            } else {
                BufferedImage img = ImageIO.read(file);
                if (img != null) {
                    // Mẹo: Nếu ảnh gốc là ảnh có nền trong suốt (PNG), TIFF nén màu sẽ bị phình.
                    // Nếu cần, có thể giữ nguyên cấu trúc màu gốc của BufferedImage.
                    images.add(img);
                }
            }
        }

        if (images.isEmpty()) {
            throw new IllegalArgumentException("Không tìm thấy dữ liệu ảnh hợp lệ để gộp.");
        }

        // 2. Tìm kiếm TIFF Writer (Yêu cầu TwelveMonkeys)
        Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("TIFF");
        if (!writers.hasNext()) {
            throw new IllegalStateException("Không tìm thấy TIFF ImageWriter. Hãy đảm bảo đã thêm thư viện TwelveMonkeys.");
        }
        ImageWriter writer = writers.next();

        // 3. Cấu hình nén DEFLATE (Zip-in-TIFF) - Giải pháp tối ưu dung lượng tốt nhất thay thế cho LZW
        ImageWriteParam writeParam = writer.getDefaultWriteParam();
        if (writeParam.canWriteCompressed()) {
            writeParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);

            // Sử dụng "Deflate" hoặc "ZLib" thay vì LZW để nén chặt hơn nhiều lần
            writeParam.setCompressionType("Deflate");

            // Thiết lập mức độ nén tối đa (0.0 = Tốc độ cao nhất, 1.0 = Nén nhỏ nhất có thể)
            writeParam.setCompressionQuality(1.0f);
        }

        // 4. Ghi chuỗi sequence tuần tự một lần để loại bỏ metadata trùng lặp
        try (ImageOutputStream ios = ImageIO.createImageOutputStream(outputFile)) {
            writer.setOutput(ios);

            // Bắt đầu luồng ghi tuần tự
            writer.prepareWriteSequence(null);

            for (BufferedImage img : images) {
                IIOImage iioImage = new IIOImage(img, null, null);
                writer.writeToSequence(iioImage, writeParam);
            }

            // Kết thúc luồng
            writer.endWriteSequence();
        } finally {
            writer.dispose();
        }
    }

    public static void mergeToMultiPageTiff_2_quality_good(List<File> inputFiles, File outputFile) throws IOException {
        if (inputFiles == null || inputFiles.isEmpty()) {
            throw new IllegalArgumentException("Input file list cannot be empty.");
        }

        ImageWriter writer = ImageIO.getImageWritersByFormatName("TIFF").next();

        try (ImageOutputStream ios = ImageIO.createImageOutputStream(outputFile)) {
            writer.setOutput(ios);

            // Configure Lossless Compression Parameters for identical color quality
            ImageWriteParam param = writer.getDefaultWriteParam();
            param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            param.setCompressionType("Deflate");

            writer.prepareWriteSequence(null);

            for (File file : inputFiles) {
                if (file.getName().toLowerCase().endsWith(".pdf")) {
                    // Process PDF Document
                    try (PDDocument document = Loader.loadPDF(file)) {
                        PDFRenderer pdfRenderer = new PDFRenderer(document);

                        for (int page = 0; page < document.getNumberOfPages(); ++page) {
                            // Render page keeping the exact original RGB colorspace
                            // 300 DPI balances razor-sharp text clarity with a lightweight file size
                            BufferedImage bim = pdfRenderer.renderImageWithDPI(page, 300, ImageType.RGB);

                            IIOImage iioImage = new IIOImage(bim, null, null);
                            writer.writeToSequence(iioImage, param);
                            bim.flush();
                        }
                    }
                } else {
                    // Process standard images (PNG, JPG, TIFF, BMP)
                    BufferedImage bufferedImage = ImageIO.read(file);
                    if (bufferedImage != null) {
                        IIOImage iioImage = new IIOImage(bufferedImage, null, null);
                        writer.writeToSequence(iioImage, param);
                        bufferedImage.flush();
                    }
                }
            }

            writer.endWriteSequence();
        } finally {
            writer.dispose();
        }
    }

    public static void mergeOnlyImageToMultiPageTiff(List<File> inputImageFiles, File outputFile) throws IOException {
        if (inputImageFiles == null || inputImageFiles.isEmpty()) {
            throw new IllegalArgumentException("Input file list cannot be empty.");
        }

        // 1. Locate the TIFF ImageWriter
        ImageWriter writer = ImageIO.getImageWritersByFormatName("TIFF").next();

        try (ImageOutputStream ios = ImageIO.createImageOutputStream(outputFile)) {
            writer.setOutput(ios);

            // 2. Configure Lossless Compression Parameters
            ImageWriteParam param = writer.getDefaultWriteParam();
            param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);

            // "Deflate" or "LZW" ensures 100% identical color quality with great compression
            param.setCompressionType("Deflate");

            // 3. Begin the multi-page sequential write sequence
            writer.prepareWriteSequence(null);

            for (File imageFile : inputImageFiles) {
                // Read the original image frame
                BufferedImage bufferedImage = ImageIO.read(imageFile);

                if (bufferedImage != null) {
                    // Wrap the frame into an IIOImage wrapper
                    IIOImage iioImage = new IIOImage(bufferedImage, null, null);

                    // Append the page with compressed parameters applied
                    writer.writeToSequence(iioImage, param);

                    // Clear memory profile for the processed frame
                    bufferedImage.flush();
                }
            }

            // 4. Finalize the file structure
            writer.endWriteSequence();
        } finally {
            writer.dispose();
        }
    }
}