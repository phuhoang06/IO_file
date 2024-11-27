import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {

    // Method to write the maximum value to a file
    public void writeFile(String filePath, int max) {
        try {
            FileWriter writer = new FileWriter(filePath, true); // Append mode
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("Giá trị lớn nhất là: " + max);
            bufferedWriter.newLine(); // Add a new line for better formatting
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to read integers from a file
    public List<Integer> readFile(String filePath) {
        List<Integer> numbers = new ArrayList<>();
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException("File không tồn tại.");
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    numbers.add(Integer.parseInt(line.trim())); // Handle potential spaces
                } catch (NumberFormatException e) {
                    System.err.println("Không thể chuyển đổi dòng này thành số: " + line);
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("File không tồn tại: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
        }
        return numbers;
    }
}

