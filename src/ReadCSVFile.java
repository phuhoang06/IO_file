import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadCSVFile {

    public static void main(String[] args) {
        String filePath = "countries.csv"; // Thay thế bằng đường dẫn tệp CSV của bạn
        List<Country> countries = readCSV(filePath);

        // Hiển thị danh sách các quốc gia
        System.out.println("Danh sách các quốc gia:");
        for (Country country : countries) {
            System.out.println(country);
        }
    }

    // Phương thức đọc file CSV
    public static List<Country> readCSV(String filePath) {
        List<Country> countries = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(","); // Chia dữ liệu theo dấu phẩy
                if (values.length == 3) {
                    int id = Integer.parseInt(values[0].trim());
                    String code = values[1].trim();
                    String name = values[2].trim();
                    countries.add(new Country(id, code, name));
                } else {
                    System.err.println("Dòng không hợp lệ: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Đã xảy ra lỗi khi đọc file: " + e.getMessage());
        }

        return countries;
    }

    // Lớp Country để lưu thông tin quốc gia
    static class Country {
        private int id;
        private String code;
        private String name;

        public Country(int id, String code, String name) {
            this.id = id;
            this.code = code;
            this.name = name;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Code: " + code + ", Name: " + name;
        }
    }
}
