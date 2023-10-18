package pl.edu.uj.javaframe;

public class MyImaginaryDouble extends MyDouble {
    private double realPart;
    private double imaginaryPart;

    public MyImaginaryDouble(double realPart, double imaginaryPart) {
        this.value = realPart;
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }
    public MyImaginaryDouble(double realPart){
        this.realPart=realPart;
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

    public double getRealPart() {
        return realPart;
    }

    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    public void setImaginaryPart(double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }

    @Override
    public Value add(Value v) {
        if (v instanceof MyImaginaryInt) {
            MyImaginaryInt im1 = (MyImaginaryInt) v;
            return new MyImaginaryDouble(realPart + im1.getRealPart(), imaginaryPart + im1.getImaginaryPart());
        }
        else if (v instanceof Int) {
            Int int1 = (Int) v;
            Integer i = (Integer) int1.value;
            return new MyImaginaryDouble(realPart + i, imaginaryPart);

        } else if (v instanceof MyImaginaryDouble) {
            MyImaginaryDouble im2 = (MyImaginaryDouble) v;
            return new MyImaginaryDouble(realPart + im2.realPart, imaginaryPart + im2.imaginaryPart);
        }else if (v instanceof MyDouble) {
            MyDouble double1 = (MyDouble) v;
            Double x = (Double) double1.value;
            return new MyImaginaryDouble(realPart + x, imaginaryPart);
        }  else {
            return this;
        }
    }
}