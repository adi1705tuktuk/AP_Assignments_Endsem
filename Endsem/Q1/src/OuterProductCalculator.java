import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OuterProductCalculator {

    public static void main(String[] args) {

        String inputFile1 = "A1.txt";
        String inputFile2 = "A2.txt";

        String outputFile1 = "A1XA2.txt";
        String outputFile2 = "A2XA1.txt";

        List<Integer> vector1 = readVector(inputFile1);
        List<Integer> vector2 = readVector(inputFile2);

        if (vector1.size() == 0 || vector2.size() == 0) {
            System.out.println("Error: Empty vector found");
            return;
        }

        int[][] outerProduct1 = calculateOuterProduct1(vector1, vector2);
        int[][] outerProduct2 = calculateOuterProduct2(vector1, vector2);

        writeOuterProductToFile(outerProduct1, outputFile1);
        writeOuterProductToFile(outerProduct2, outputFile2);

    }

    private static List<Integer> readVector(String filePath) {
        List<Integer> vector = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                vector.add(Integer.parseInt(line.trim()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return vector;
    }

    private static int[][] calculateOuterProduct1(List<Integer> vector1, List<Integer> vector2) {
        int length1 = vector1.size();
        int length2 = vector2.size();
        int[][] result = new int[length1][length2];

        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                result[i][j] = vector1.get(i) * vector2.get(j);
            }
        }

        return result;
    }


    private static int[][] calculateOuterProduct2(List<Integer> vector2, List<Integer> vector1) {
        int length1 = vector1.size();
        int length2 = vector2.size();
        int[][] result = new int[length1][length2];

        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                result[i][j] = vector1.get(i) * vector2.get(j);
            }
        }

        return result;
    }

    private static void writeOuterProductToFile(int[][] outerProduct, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int[] row : outerProduct) {
                for (int value : row) {
                    writer.write(value + " ");
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}