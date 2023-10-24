package pl.edu.uj.javaframe;

public class ImaginaryInt extends Int {
    private int realPart;
    private int imaginaryPart;

    public ImaginaryInt(int realPart, int imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
        this.value = realPart;
    }

    public ImaginaryInt() {
    }
    public ImaginaryInt(int realPart){
        this.realPart = realPart;
        this.value = realPart;
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
        double realPart = Integer.parseInt(real);
        double imaginaryPart = Integer.parseInt(imaginary);
        return new ImaginaryInt((int) realPart, (int) imaginaryPart);
    }

    public int getRealPart() {
        return realPart;
    }

    public void setRealPart(int realPart) {
        this.realPart = realPart;
    }

    public int getImaginaryPart() {
        return imaginaryPart;
    }

    public void setImaginaryPart(int imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }

    @Override
    public Value add(Value v) {
        if (v instanceof ImaginaryInt) {
            ImaginaryInt im1 = (ImaginaryInt) v;
            return new ImaginaryInt((int)(realPart + im1.realPart), (int)(imaginaryPart + im1.imaginaryPart));
        }
        else if (v instanceof Int) {
            Int int1 = (Int) v;
            Integer i = (Integer) int1.value;
            return new ImaginaryInt(realPart + i, imaginaryPart);

        } else if (v instanceof ImaginaryDouble) {
            ImaginaryDouble im2 = (ImaginaryDouble) v;
            return new ImaginaryInt((int) (realPart + im2.getRealPart()), (int) (imaginaryPart + im2.getImaginaryPart()));
        } else if (v instanceof MyDouble) {
            MyDouble double1 = (MyDouble) v;
            Double x = (Double) double1.value;
            return new ImaginaryInt((int) (realPart + x), imaginaryPart);
        }  else {
            return this;
        }
    }


}
