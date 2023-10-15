package pl.edu.uj.javaframe;

public class MyImaginaryDouble extends MyDouble{
    private double realNumber;
    private double imaginaryNumber;

    public MyImaginaryDouble(double realNumber, double imaginaryNumber) {
        this.realNumber = realNumber;
        this.imaginaryNumber = imaginaryNumber;
    }

    @Override
    public Value create(String val) {
        val.split("i");

        MyDouble v = new MyDouble();
        v.value = Double.parseDouble(val);
        return v;
    }

    @Override
    public Value add(Value v) {
        MyDouble result  = new MyDouble();
        result.value = (Double)this.value + Double.valueOf(v.value.toString());

        return result;

    }


}
