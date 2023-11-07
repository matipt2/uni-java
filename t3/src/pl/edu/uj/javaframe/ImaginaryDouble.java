package pl.edu.uj.javaframe;
import static java.lang.Math.*;

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
        return realPart +  "i"+ imaginaryPart ;
    }

    public Value create(String val) {
        int index = val.indexOf("i");
        if (index != -1) {
            String real = val.substring(0, index);
            String imaginary = val.substring(index + 1);
            double realPart = Double.parseDouble(real);
            double imaginaryPart = Double.parseDouble(imaginary);
            return new ImaginaryDouble(realPart, imaginaryPart);
        } else {
            double realPart = Double.parseDouble(val);
            return new ImaginaryDouble(realPart);
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

    public Value sub(Value v){
        if (v instanceof ImaginaryInt) {
            ImaginaryInt im1 = (ImaginaryInt) v;
            return new ImaginaryDouble(realPart - im1.getRealPart(), imaginaryPart - im1.getImaginaryPart());
        }
        else if (v instanceof Int) {
            Int int1 = (Int) v;
            Integer i = (Integer) int1.value;
            return new ImaginaryDouble(realPart - i, imaginaryPart);

        } else if (v instanceof ImaginaryDouble) {
            ImaginaryDouble im2 = (ImaginaryDouble) v;
            return new ImaginaryDouble(realPart - im2.realPart, imaginaryPart - im2.imaginaryPart);
        }else if (v instanceof MyDouble) {
            MyDouble double1 = (MyDouble) v;
            Double x = (Double) double1.value;
            return new ImaginaryDouble(realPart - x, imaginaryPart);
        }  else {
            return this;
        }
    }
        public Value mul(Value v){
            if (v instanceof ImaginaryInt) {
                ImaginaryInt im1 = (ImaginaryInt) v;
                return new ImaginaryDouble(realPart * im1.getRealPart(), imaginaryPart * im1.getImaginaryPart());
            }
            else if (v instanceof Int) {
                Int int1 = (Int) v;
                Integer i = (Integer) int1.value;
                return new ImaginaryDouble(realPart * i, imaginaryPart);

            } else if (v instanceof ImaginaryDouble) {
                ImaginaryDouble im2 = (ImaginaryDouble) v;
                return new ImaginaryDouble(realPart * im2.realPart, imaginaryPart * im2.imaginaryPart);
            }else if (v instanceof MyDouble) {
                MyDouble double1 = (MyDouble) v;
                Double x = (Double) double1.value;
                return new ImaginaryDouble(realPart * x, imaginaryPart);
            }  else {
                return this;
            }
    }
        public Value div(Value v){

            if (v instanceof ImaginaryInt) {
                ImaginaryInt im1 = (ImaginaryInt) v;
                return new ImaginaryDouble(realPart / im1.getRealPart(), imaginaryPart / im1.getImaginaryPart());
            }
            else if (v instanceof Int) {
                Int int1 = (Int) v;
                Integer i = (Integer) int1.value;
                return new ImaginaryDouble(realPart / i, imaginaryPart);

            } else if (v instanceof ImaginaryDouble) {
                ImaginaryDouble im2 = (ImaginaryDouble) v;
                return new ImaginaryDouble(realPart / im2.realPart, imaginaryPart / im2.imaginaryPart);
            }else if (v instanceof MyDouble) {
                MyDouble double1 = (MyDouble) v;
                Double x = (Double) double1.value;
                return new ImaginaryDouble(realPart / x, imaginaryPart);
            }  else {
                return this;
            }
        }
        public Value pow(Value v){
            MyDouble exp = (MyDouble) v;
            double modulus = Math.sqrt(realPart * realPart + imaginaryPart * imaginaryPart);
            double theta = Math.atan2(imaginaryPart, realPart);
            double resultModulus = Math.pow(modulus, (Double) exp.value);
            double resultTheta = (Double)theta * (Double)exp.value;
            double newReal = resultModulus * Math.cos(resultTheta);
            double newImaginary = resultModulus * Math.sin(resultTheta);
            return new ImaginaryDouble(newReal,newImaginary);
        }
//    public boolean eq(Value){
//
//    }
    public boolean lte(Value v){
        throw new ArithmeticException("Inequalities of imaginary numbers are not well defined ");
    }
    public boolean gte(Value v){
        throw new ArithmeticException("Inequalities of imaginary numbers are not well defined ");
    }
//
    public boolean neq(Value v){
        if(v instanceof ImaginaryDouble){
            ImaginaryDouble v1 = new ImaginaryDouble();
            if(this.realPart!=v1.realPart || this.imaginaryPart!= v1.imaginaryPart){
                return true;
            }
            return false;
        }
        throw new ArithmeticException("Inequalities of imaginary numbers are not well defined ");
    }
    public boolean equals(Object other){
        if(other instanceof ImaginaryDouble){

        }
    }
//    public int hashCode(){
//
//    }
}