import java.io.*;

public class CopyFileText {

    public static void main(String[] args) {
        // Đường dẫn tệp nguồn và tệp đích
        String sourceFilePath = "source.txt";
        String targetFilePath = "target.txt";

        copyFile(sourceFilePath, targetFilePath);
    }

    public static void copyFile(String sourceFilePath, String targetFilePath) {
        File sourceFile = new File(sourceFilePath);
        File targetFile = new File(targetFilePath);

        // Kiểm tra nếu tệp nguồn không tồn tại
        if (!sourceFile.exists()) {
            System.out.println("Tệp nguồn không tồn tại!");
            return;
        }

        // Kiểm tra nếu tệp đích đã tồn tại
        if (targetFile.exists()) {
            System.out.println("Tệp đích đã tồn tại. Vui lòng chọn tệp đích khác.");
            return;
        }

        // Sao chép nội dung từ tệp nguồn sang tệp đích
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile))) {

            String line;
            int charCount = 0;

            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // Xuống dòng sau mỗi dòng đã sao chép
                charCount += line.length();
            }

            System.out.println("Sao chép thành công! Số ký tự trong tệp: " + charCount);

        } catch (IOException e) {
            System.err.println("Đã xảy ra lỗi khi sao chép tệp: " + e.getMessage());
        }
    }
}
