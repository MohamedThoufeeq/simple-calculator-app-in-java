package calculator;

import java.util.Scanner;

public class Calculator {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------");
        System.out.println("Enter the mathematical operation you want to perform: ");

        // Decalare the math operations
        String[] mathOperationArray = { "Addition", "Subraction", "Multiplication", "Division",
                "Square Root", "Power", "Percentage", "Factorial" };

        // Display the math operations
        for (int i = 0; i < mathOperationArray.length; i++) {
            System.out.println((i + 1) + ". " + mathOperationArray[i]);
        }

        // Read the input from the user
        System.out.print("Enter : ");
        int mathOperation = sc.nextInt();
        System.out.println("Selected Math Operation : " + mathOperationArray[mathOperation - 1]);

        // the corresponding method to perform the operation
        int selectedMathOpeation = mathOperation - 1;
        Arithmetics arithmeticOperations = new ArithmeticOperations();
        switch (selectedMathOpeation) {
            case 0:
                // Addition
                String[] input = getInput(mathOperationArray[selectedMathOpeation]);
                Object sum = arithmeticOperations.add(input);
                System.out.println("The sum is : " + sum);
                break;
            case 1:
                // Subtraction
                String[] subInput = getInput(mathOperationArray[selectedMathOpeation]);
                Object difference = arithmeticOperations.subtract(subInput);
                System.out.println("The difference is : " + difference);
                break;

            case 2:
                // Multiplication
                String[] mulInput = getInput(mathOperationArray[selectedMathOpeation]);
                Object product = arithmeticOperations.multiply(mulInput);
                System.out.println("The product is : " + product);
                break;

            case 3:
                // Division
                String[] divInput = getInputForDivision();
                Object quotient = arithmeticOperations.divide(divInput);
                System.out.println("The result = " + quotient);
                break;

            case 4:
                // Square Root
                String sqrtInput = getInputForSqrRt();
                Object sqrt = arithmeticOperations.squareRoot(sqrtInput);
                System.out.println("The square root is : " + sqrt);
                break;

            case 5:
                // Power
                String[] powInput = getInputForPower();
                Object power = arithmeticOperations.power(powInput);
                System.out.println("The result is : " + power);
                break;

            case 6:
                // Percentage
                String[] percentInput = getInputForPercentage();
                Object percentage = arithmeticOperations.percentage(percentInput);
                System.out.println("The percentage is : " + percentage + " %");
                break;
            case 7:
                //Factorial
                String inputForFactorial = getInputForFactorial();
                Object factorial = arithmeticOperations.factorial(inputForFactorial);
                System.out.println("The factorial is : "+factorial);
                break;
            default:
                System.out.println("Enter valid inputs :-/");
        }
        System.in.close();
    }

    public static String[] getInput(String function) {

        System.out.println("Enter the numbers you want to do " + function + " seperated by comma \",\" : ");
        String input = sc.next();
        String[] inputArray = input.split(",");
        return inputArray;
    }

    public static String[] getInputForDivision() {
        System.out.print("Enter the Dividend :");
        String dividend = sc.next();
        System.out.print("Enter the Divisor :");
        String divisor = sc.next();

        String[] divInput = { dividend, divisor };
        return divInput;
    }

    public static String getInputForSqrRt() {
        System.out.print("Enter the Number you want to find the square root : ");
        String input = sc.next();
        return input;
    }

    public static String[] getInputForPower () {
        System.out.print("Enter the Base : ");
        int base = sc.nextInt();
        System.out.print("Enter the power : ");
        int power = sc.nextInt();
        String[] arr = {String.valueOf(base), String.valueOf(power)};
        return arr;
    }

    public static String[] getInputForPercentage() {
        System.out.print("Enter the Value : ");
        String value = sc.next();
        System.out.print("Enter the Total Value : ");
        String totalValue = sc.next();
        String[] input = { value, totalValue };
        return input;
    }

    public static String  getInputForFactorial() {
        System.out.print("Enter the number : ");
        int num = sc.nextInt();
        return String.valueOf(num);
    }

}