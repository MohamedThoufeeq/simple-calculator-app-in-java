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
        // InputStream inputStream = System.in;
        // Scanner scanner = new Scanner(inputStream);
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

class ArithmeticOperations implements Arithmetics{

    // Addition
    @Override
    public Object add(String... x) throws Exception {
        Object sum = null;

        float floatSum = 0f;
        for (String num : x) {

            floatSum += parseString(num);
            sum = floatSum;

        }
        return sum;
    }

    // Subtraction
    @Override
    public Object subtract(String... x) throws Exception {
        Object difference = null;
        float floatDifference = parseString(x[0]);
        for (int i = 1; i < x.length; i++) {
            floatDifference -= parseString(x[i]);
        }
        difference = floatDifference;
        return difference;
    }

    // Multiplication
    @Override
    public Object multiply(String... x) throws Exception {
        Object product = null;

        float floatProduct = 1f;
        for (String num : x) {
            floatProduct *= parseString(num);
            product = floatProduct;
        }
        return product;
    }

    // Division
    @Override
    public String divide(String... x) throws Exception {
        if (x.length != 2) {
            throw new IllegalArgumentException("Division requires exactly two numbers, A dividend and a divisor");
        }

        float dividend = parseString(x[0]);
        float divisor = parseString(x[1]);

        if (divisor == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }

        float quotient = dividend / divisor;
        float remainder = dividend % divisor;

        return "Quotient: " + quotient + " , Remainder: " + remainder;
    }

    // Square Root
    @Override
    public Object squareRoot(String x) throws Exception {
        Object result = null;

        float floatValue = parseString(x);
        if (floatValue < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of a negative number");
        }
        float floatResult = (float) Math.sqrt(floatValue);
        result = floatResult;

        return result;
    }

    // Power
    @Override
    public Object power(String... x) throws Exception {

        Object result = null;
        float base = parseString(x[0]);
        float exponent = parseString(x[1]);

        result = Math.pow(base, exponent);
        return result;
    }

    // Percentage
    @Override
    public Object percentage(String... x) throws Exception {
        if (x.length != 2) {
            throw new IllegalArgumentException("Percentage calculation requires exactly two numbers");
        }
        float value = parseString(x[0]);
        float totalValue = parseString(x[1]);

        float floatResult = (value / totalValue) * 100;
        return floatResult;
    }
    // factorial
    @Override
    public Object factorial(String x) throws Exception{
        int num = (int) parseString(x);
        int fact = 1;
        for(int i = 1; i <= num; i++){
            fact *= i;
        }
        return fact;
    }
    
    /**
     * @Description : Parse the input String into float
     * @param input [Type: String]
     * @return Object
     * @throws Exception
     */
    @Override
    public float parseString(String input) throws Exception {
        try {
            return Float.parseFloat(input);
        } catch (NumberFormatException e3) {
            // If parsing as float fails, the input is not a valid number
            throw new NumberFormatException(
                    "Invalid Number Format. " + "The entered input \"" + input + "\" is wrong ...");
        }
    }

}

