package pl.edu.uj.javaframe;

public class MyImaginaryDouble extends MyDouble{
    private double realPart;
    private double imaginaryPart;

    public MyImaginaryDouble(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public MyImaginaryDouble() {
    }

    @Override
    public String toString() {
        return realPart + " + " + imaginaryPart + "i";
    }

    public Value create(String val) {
        String targetChar = "i";
        int index = val.indexOf(targetChar);
        String real = val.substring(0, index);
        String imaginary = val.substring(index + 1);
        double realPart = Double.parseDouble(real);
        double imaginaryPart = Double.parseDouble(imaginary);
        return new MyImaginaryDouble(realPart, imaginaryPart);
    }
    @Override
    public Value add(Value v) {
        MyImaginaryDouble result = new MyImaginaryDouble();
        result.value = (Double)this.value + Double.valueOf(v.value.toString());

        return result;

    }


}
