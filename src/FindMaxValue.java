import java.util.List;

public class FindMaxValue {

    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();

        // Read numbers from the file
        List<Integer> numbers = readAndWriteFile.readFile("numbers.txt");

        if (numbers.isEmpty()) {
            System.out.println("File is empty or contains no valid numbers.");
            return;
        }

        // Find the maximum value
        int maxValue = findMax(numbers);

        // Write the maximum value to the result file
        readAndWriteFile.writeFile("result.txt", maxValue);
    }

    // Method to find the maximum value in a list
    public static int findMax(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("The list of numbers cannot be null or empty.");
        }

        int max = numbers.get(0);
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }
}
