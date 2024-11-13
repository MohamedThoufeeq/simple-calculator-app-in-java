package calculator;

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

    // Maximum & Minimum
    @Override
    public Object[] maxMin(String[] maxMinInput) {
        Object[] maxMinResult = new Object[2];
        float max = Float.MIN_VALUE;
        float min = Float.MAX_VALUE;
        for (String num : maxMinInput) {
            float floatNum = Float.parseFloat(num);
            if (floatNum > max) {
                max = floatNum;
            }
            if (floatNum < min) {
                min = floatNum;
            }
        }
        maxMinResult[0] = max;
        maxMinResult[1] = min;
        return maxMinResult;
    }
    
    //Average
    @Override
    public Object average(String[] avgInput) throws Exception {
        float sum = 0f;
        for (String num : avgInput) {
            sum += parseString(num);
        }
        return sum / avgInput.length;
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
