package calculator;
public interface Arithmetics {
    public Object add(String... x) throws Exception;
    public Object subtract(String... x) throws Exception;
    public Object multiply(String... x) throws Exception;
    public Object divide(String... x) throws Exception;
    public Object squareRoot(String x) throws Exception;
    public Object power(String... x) throws Exception;
    public Object percentage(String... x) throws Exception;
    public Object factorial(String x) throws Exception;
    public float parseString(String input) throws Exception;
    public Object[] maxMin(String[] maxMinInput) throws Exception;
    public Object average(String[] avgInput) throws Exception;

}
