public class Calculator {
    private String operator;
    private int num1;
    private int num2;

    public Calculator() {
    }

    public Calculator(int num1, String operator, int num2) {
        this.num1 = num1;
        this.operator = operator;
        this.num2 = num2;
    }

    public int doCalculations(int num1, String operator, int num2) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                return 0;
        }
    }
}
