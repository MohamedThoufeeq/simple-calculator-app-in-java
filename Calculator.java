package calculator;

import java.io.InputStream;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws Exception {
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------");
        System.out.println("Enter the mathematical operation you want to perform: ");

        // Decalare the math operations
        String[] mathOperationArray = { "Addition", "Subraction", "Multiplication", "Division",
                "Square Root", "Power", "Percentage" };

        // Display the math operations
        for (int i = 0; i < mathOperationArray.length; i++) {
            System.out.println((i + 1) + ". " + mathOperationArray[i]);
        }

        // Read the input from the user
        System.out.print("Enter : ");
        InputStream inputStream = System.in;
        Scanner scanner = new Scanner(inputStream);
        int mathOperation = scanner.nextInt();
        System.out.println("Selected Math Operation : " + mathOperationArray[mathOperation - 1]);

        // call the corresponding method to perform the operation
        int selectedMathOpeation = mathOperation - 1;
        switch (selectedMathOpeation) {
            case 0:
                // call Addition
                String[] input = Addition.getInput();
                int sum = Addition.add(input);
                System.out.println("The sum is : " + sum);
                break;

            default:
                System.out.println("Eneter proper inputs :-/");
        }
        scanner.close();
    }

}

class Addition {
    public static String[] getInput() {

        System.out.println("Enter the numbers you want to add seperated by comma \",\" : ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        String[] inputArray = input.split(",");

        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = inputArray[i].trim();
        }
        return inputArray;
    }

    public static int add(String... x) throws Exception {
        int sum = 0;
        for (String num : x) {
            if (validateInput(num)) {
                int input = Integer.parseInt(num);
                sum += input;
            } else {
                throw new Exception("The entered input \""+num+"\" is wrong ...");
            }
        }
        return sum;
    }

    public static boolean validateInput(String element) throws Exception {

        // Parse the String into corresponding NumberFormat
        Object obj = ParseString.parseString(element);
        
        // validate the NumberFormat
        if (obj instanceof Integer) {
            return true;
        } else if (obj instanceof Long) {
            return true;
        } else if (obj instanceof Double) {
            return true;
        } else if (obj instanceof Float) {
            return true;
        } else {
            return false;
        }

    }
}

class ParseString {
    /**
     * @Description : Parse the input String into corresponding NumberFormat
     * @param input [Type: String]
     * @return Object
     * @throws Exception
     */
    public static Object parseString(String input) throws Exception {
        try {
            // Attempt to parse as an integer
            int integerValue = Integer.parseInt(input);
            return integerValue;
        } catch (NumberFormatException e) {
            // If parsing as integer fails, try parsing as a long
            try {
                long longValue = Long.parseLong(input);
                return longValue;
            } catch (NumberFormatException e1) {
                // If parsing as long fails, try parsing as a double
                try {
                    double doubleValue = Double.parseDouble(input);
                    return doubleValue;
                } catch (NumberFormatException e2) {
                    // If parsing as double fails, try parsing as a float
                    try {
                        float floatValue = Float.parseFloat(input);
                        return floatValue;
                    } catch (NumberFormatException e3) {
                        // If parsing as float fails, the input is not a valid number
                        throw new NumberFormatException("Invalid Number Format. "+"The entered input \""+input+"\" is wrong ...");
                    }
                }
            }
        }
    }
}
