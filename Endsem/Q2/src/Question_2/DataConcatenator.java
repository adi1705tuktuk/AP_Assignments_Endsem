package Question_2;
public class DataConcatenator {
    private Object data1;
    private Object data2;

    public DataConcatenator(Object data1, Object data2) {
        if (!(data1 instanceof String || data1 instanceof Integer) ||
                !(data2 instanceof String || data2 instanceof Integer)) {
            throw new IllegalArgumentException("Both data members must be either strings or integers.");
        }
        this.data1 = data1;
        this.data2 = data2;
    }

    public String concatenateData() {
        try {
            String result = String.valueOf(data1) + String.valueOf(data2);
            return result;
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        // Case 1: Strings
        try {
            DataConcatenator stringConcatenator = new DataConcatenator("Hello", "World");
            String resultString = stringConcatenator.concatenateData();
            System.out.println("Concatenated String: " + resultString);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Case 2: Integers
        try {
            DataConcatenator intConcatenator = new DataConcatenator(123, 456);
            String resultInt = intConcatenator.concatenateData();
            System.out.println("Concatenated Integer: " + resultInt);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Case 3: Incorrect usage (mixing types)
        try {
            DataConcatenator mixedConcatenator = new DataConcatenator("Hello", 123);
            String resultMixed = mixedConcatenator.concatenateData();
            System.out.println("Concatenated Mixed: " + resultMixed);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}