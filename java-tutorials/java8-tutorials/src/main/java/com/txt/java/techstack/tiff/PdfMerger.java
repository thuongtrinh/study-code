package com.txt.java.techstack.tiff;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.JPEGFactory;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class PdfMerger {

    public static void mergeImagesAndPdfsToSinglePdf(List<File> inputFiles, File outputFile) throws IOException {
        if (inputFiles == null || inputFiles.isEmpty()) {
            throw new IllegalArgumentException("Danh sách file đầu vào không được để trống.");
        }

        // Tạo một document chính để chứa kết quả cuối cùng
        try (PDDocument finalDocument = new PDDocument()) {
            PDFMergerUtility mergerUtility = new PDFMergerUtility();

            for (File file : inputFiles) {
                String fileNameLower = file.getName().toLowerCase();

                if (fileNameLower.endsWith(".pdf")) {
                    // Tình huống 1: File đầu vào là PDF -> Gộp trực tiếp các trang vào file chính
                    try (PDDocument sourcePdf = Loader.loadPDF(file)) {
                        mergerUtility.appendDocument(finalDocument, sourcePdf);
                    }
                } else {
                    // Tình huống 2: File đầu vào là Ảnh (JPG, PNG, TIFF, BMP...)
                    BufferedImage bufferedImage = ImageIO.read(file);
                    if (bufferedImage != null) {
                        // Tạo một trang mới với kích thước bằng đúng kích thước pixel của ảnh
                        PDRectangle pageSize = new PDRectangle(bufferedImage.getWidth(), bufferedImage.getHeight());
                        PDPage newPage = new PDPage(pageSize);
                        finalDocument.addPage(newPage);

                        PDImageXObject pdImage;
                        // Giữ chất lượng màu và tối ưu dung lượng dựa trên loại ảnh gốc
                        if (fileNameLower.endsWith(".jpg") || fileNameLower.endsWith(".jpeg")) {
                            // Ảnh JPEG dùng nén DCT (Lossy nhưng dung lượng cực nhẹ, chuẩn màu ảnh chụp)
                            pdImage = JPEGFactory.createFromImage(finalDocument, bufferedImage);
                        } else {
                            // Ảnh PNG, TIFF dùng nén Flate (Lossless 100%, bảo toàn màu sắc tuyệt đối)
                            pdImage = LosslessFactory.createFromImage(finalDocument, bufferedImage);
                        }

                        // Vẽ ảnh đè khít lên trang PDF mới tạo
                        try (PDPageContentStream contentStream = new PDPageContentStream(finalDocument, newPage)) {
                            contentStream.drawImage(pdImage, 0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
                        }

                        bufferedImage.flush();
                    }
                }
            }

            // Lưu file PDF hoàn chỉnh
            finalDocument.save(outputFile);
        }
    }
}
