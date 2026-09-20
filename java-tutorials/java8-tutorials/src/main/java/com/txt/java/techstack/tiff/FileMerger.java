package com.txt.java.techstack.tiff;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileMerger {
    public static void main(String[] args) {
        // Cấu hình đường dẫn thư mục gốc và thư mục đầu ra
        Path sourceDir = Paths.get("D:\\tmp\\test\\original");
        Path targetDir = Paths.get("D:\\tmp\\test\\output-tiff");
        File outputFile = targetDir.resolve("merged_result.tiff").toFile();
        File outputFilePdf = targetDir.resolve("merged_result_pdf.pdf").toFile();

        try {
            // 1. Tự động tạo thư mục đầu ra nếu chưa tồn tại
            if (!Files.exists(targetDir)) {
                Files.createDirectories(targetDir);
                System.out.println("Đã tạo thư mục đầu ra: " + targetDir.toAbsolutePath());
            }

            // Kiểm tra thư mục đầu vào
            if (!Files.exists(sourceDir) || !Files.isDirectory(sourceDir)) {
                System.err.println("Lỗi: Thư mục '" + sourceDir.toAbsolutePath() + "' không tồn tại!");
                return;
            }

            System.out.println("Đang quét các file trong thư mục: " + sourceDir.toAbsolutePath());

            // 2. Lọc và lấy danh sách các file ảnh & PDF hợp lệ
            List<File> validFiles;
            try (Stream<Path> paths = Files.walk(sourceDir)) {
                validFiles = paths
                        .filter(Files::isRegularFile) // Chỉ lấy file, bỏ qua thư mục con
                        .filter(path -> {
                            String name = path.getFileName().toString().toLowerCase();
                            return name.endsWith(".pdf") || name.endsWith(".jpg")
                                    || name.endsWith(".jpeg") || name.endsWith(".png")
                                    || name.endsWith(".bmp");
                        })
                        .map(Path::toFile)
                        .sorted((f1, f2) -> f1.getName().compareToIgnoreCase(f2.getName())) // Sắp xếp theo tên file (A-Z)
                        .collect(Collectors.toList());
            }

            if (validFiles.isEmpty()) {
                System.out.println("Không tìm thấy file PDF hoặc ảnh nào trong thư mục 'original'.");
                return;
            }

            System.out.println("Tìm thấy " + validFiles.size() + " file hợp lệ để tiến hành gộp:");
            validFiles.forEach(f -> System.out.println(" - " + f.getName()));


            mergeFileTiff(validFiles, outputFile);
            mergeFilePdf(validFiles, outputFilePdf);

        } catch (IOException e) {
            System.err.println("Có lỗi xảy ra trong quá trình xử lý file:");
            e.printStackTrace();
        }
    }

    private static void mergeFileTiff(List<File> validFiles, File outputFile) throws IOException {
        // 3. Gọi phương thức gộp file
        System.out.println("\nĐang tiến hành gộp và nén LZW...");
        long startTime = System.currentTimeMillis();

        TiffUtils.mergeToMultiPageTiff_2_quality_good(validFiles, outputFile);

        long endTime = System.currentTimeMillis();

        // 4. In kết quả kiểm tra kích thước
        long totalInputSize = validFiles.stream().mapToLong(File::length).sum();
        long outputSize = outputFile.length();

        System.out.println("\n Gộp file hoàn tất thành công!");
        System.out.println(" Xuất file tại: " + outputFile.getAbsolutePath());
        System.out.printf(" Tổng dung lượng file gốc: %,d bytes\n", totalInputSize);
        System.out.printf(" Dung lượng file TIFF đầu ra: %,d bytes\n", outputSize);
        System.out.printf(" Thời gian xử lý: %d ms\n", (endTime - startTime));

        if (outputSize <= totalInputSize) {
            System.out.println(" Đạt yêu cầu: Kích thước file TIFF không vượt quá tổng các file gốc.");
        } else {
            System.out.println("Lưu ý: Kích thước TIFF lớn hơn file gốc (Thường do render PDF ở DPI cao).");
        }
    }

    private static void mergeFilePdf(List<File> validFiles, File outputFilePdf) throws IOException {
        PdfMerger.mergeImagesAndPdfsToSinglePdf(validFiles, outputFilePdf);
        System.out.println("\n Gộp file PDF hoàn tất thành công!");
        System.out.println(" Export file PDF tại: " + outputFilePdf.getAbsolutePath());
        System.out.printf(" Dung lượng file PDF đầu ra: %,d bytes\n", outputFilePdf.length());
    }
}
