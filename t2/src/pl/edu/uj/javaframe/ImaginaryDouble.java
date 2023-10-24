package pl.edu.uj.javaframe;

public class ImaginaryDouble extends MyDouble {
    private double realPart;
    private double imaginaryPart;

    public ImaginaryDouble(double realPart, double imaginaryPart) {
        this.value = realPart;
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }
    public ImaginaryDouble(double realPart){
        this.realPart=realPart;
    }

    public ImaginaryDouble() {
    }

    @Override
    public String toString() {
        return realPart + " + " + imaginaryPart + "i";
    }

    public Value create(String val) {
        if(val.contains("i")){
            String targetChar = "i";
            int index = val.indexOf(targetChar);
            String real = val.substring(0, index);
            String imaginary = val.substring(index + 1);
            double realPart = Double.parseDouble(real);
            double imaginaryPart = Double.parseDouble(imaginary);
            return new ImaginaryDouble(realPart, imaginaryPart);
        }
        else{
            String real = val.substring(0, val.length());
            double realPart = Double.parseDouble(real);
            return new ImaginaryDouble(realPart, imaginaryPart);
        }

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
        if (v instanceof ImaginaryInt) {
            ImaginaryInt im1 = (ImaginaryInt) v;
            return new ImaginaryDouble(realPart + im1.getRealPart(), imaginaryPart + im1.getImaginaryPart());
        }
        else if (v instanceof Int) {
            Int int1 = (Int) v;
            Integer i = (Integer) int1.value;
            return new ImaginaryDouble(realPart + i, imaginaryPart);

        } else if (v instanceof ImaginaryDouble) {
            ImaginaryDouble im2 = (ImaginaryDouble) v;
            return new ImaginaryDouble(realPart + im2.realPart, imaginaryPart + im2.imaginaryPart);
        }else if (v instanceof MyDouble) {
            MyDouble double1 = (MyDouble) v;
            Double x = (Double) double1.value;
            return new ImaginaryDouble(realPart + x, imaginaryPart);
        }  else {
            return this;
        }
    }
}