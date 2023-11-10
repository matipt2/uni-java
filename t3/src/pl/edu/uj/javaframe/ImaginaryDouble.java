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

    public ImaginaryDouble(double realPart) {
        this.realPart = realPart;
    }

    public ImaginaryDouble() {
    }

    @Override
    public String toString() {
        return realPart + "i" + imaginaryPart;
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
        } else if (v instanceof Int) {
            Int int1 = (Int) v;
            Integer i = (Integer) int1.value;
            return new ImaginaryDouble(realPart + i, imaginaryPart);

        } else if (v instanceof ImaginaryDouble) {
            ImaginaryDouble im2 = (ImaginaryDouble) v;
            return new ImaginaryDouble(realPart + im2.realPart, imaginaryPart + im2.imaginaryPart);
        } else if (v instanceof MyDouble) {
            MyDouble double1 = (MyDouble) v;
            Double x = (Double) double1.value;
            return new ImaginaryDouble(realPart + x, imaginaryPart);
        } else {
            return this;
        }
    }
    @Override
    public Value sub(Value v) {
        if (v instanceof ImaginaryInt) {
            ImaginaryInt im1 = (ImaginaryInt) v;
            return new ImaginaryDouble(realPart - im1.getRealPart(), imaginaryPart - im1.getImaginaryPart());
        } else if (v instanceof Int) {
            Int int1 = (Int) v;
            Integer i = (Integer) int1.value;
            return new ImaginaryDouble(realPart - i, imaginaryPart);

        } else if (v instanceof ImaginaryDouble) {
            ImaginaryDouble im2 = (ImaginaryDouble) v;
            return new ImaginaryDouble(realPart - im2.realPart, imaginaryPart - im2.imaginaryPart);
        } else if (v instanceof MyDouble) {
            MyDouble double1 = (MyDouble) v;
            Double x = (Double) double1.value;
            return new ImaginaryDouble(realPart - x, imaginaryPart);
        } else {
            return this;
        }
    }
    @Override
    public Value mul(Value v) {
        if (v instanceof ImaginaryDouble) {
            ImaginaryDouble im = (ImaginaryDouble) v;
            double res1 = realPart * im.getRealPart() - imaginaryPart * im.getImaginaryPart();
            double res2 = realPart * im.getImaginaryPart() + imaginaryPart * im.getRealPart();
            return new ImaginaryDouble(res1, res2);
        } else if (v instanceof ImaginaryInt) {
            ImaginaryInt im = (ImaginaryInt) v;
            double res1 = realPart * im.getRealPart() - imaginaryPart * im.getImaginaryPart();
            double res2 = realPart * im.getImaginaryPart() + imaginaryPart * im.getRealPart();
            return new ImaginaryDouble(res1, res2);
        } else if (v instanceof Int) {
            Int int1 = (Int) v;
            int i = (Integer)int1.value;
            double res5 = realPart * i;
            double res6 = imaginaryPart*i;
            return new ImaginaryDouble(res5, res6);
        } else if (v instanceof MyDouble) {
            MyDouble double1 = (MyDouble) v;
            double x = (Double)double1.value;
            double res7 = realPart * x;
            double res8 = imaginaryPart*x;
            return new ImaginaryDouble(res7, res8);
        } else {
            return this;
        }
    }



    @Override
    public Value div(Value v) {
        if (v instanceof ImaginaryInt) {
            ImaginaryInt im1 = (ImaginaryInt) v;
            double denominator = Math.pow(im1.getRealPart(), 2) + Math.pow(im1.getImaginaryPart(), 2);
            return new ImaginaryDouble((realPart * im1.getRealPart() + imaginaryPart * im1.getImaginaryPart()) / denominator,
                    (imaginaryPart * im1.getRealPart() - realPart * im1.getImaginaryPart()) / denominator);
        } else if (v instanceof Int) {
            Int int1 = (Int) v;
            Integer i = (Integer) int1.value;
            return new ImaginaryDouble(realPart / i, imaginaryPart / i);
        } else if (v instanceof ImaginaryDouble) {
            ImaginaryDouble im2 = (ImaginaryDouble) v;
            double denominator = Math.pow(im2.realPart, 2) + Math.pow(im2.imaginaryPart, 2);
            return new ImaginaryDouble((realPart * im2.realPart + imaginaryPart * im2.imaginaryPart) / denominator,
                    (imaginaryPart * im2.realPart - realPart * im2.imaginaryPart) / denominator);
        } else if (v instanceof MyDouble) {
            MyDouble double1 = (MyDouble) v;
            Double x = (Double) double1.value;
            return new ImaginaryDouble(realPart / x, imaginaryPart / x);
        } else {
            return this;
        }
    }
    @Override
    public Value pow(Value v) {
        double exp;
        if (v instanceof MyDouble) {
            exp = (double) ((MyDouble) v).value;
        } else if (v instanceof Int) {
            exp = (Integer)v.value;
        } else {
            throw new RuntimeException("Invalid type for exponent in pow method");
        }
        double modulus = Math.sqrt(realPart * realPart + imaginaryPart * imaginaryPart);
        double theta = Math.atan2(imaginaryPart, realPart);
        double resultModulus = Math.pow(modulus, exp);
        double resultTheta = theta * exp;
        double newReal = resultModulus * Math.cos(resultTheta);
        double newImaginary = resultModulus * Math.sin(resultTheta);
        return new ImaginaryDouble(newReal, newImaginary);
    }


    @Override
    public boolean neq(Value v) {
        if (v instanceof ImaginaryDouble) {
            ImaginaryDouble v1 = (ImaginaryDouble) v;
            if (this.realPart != v1.realPart || this.imaginaryPart != v1.imaginaryPart) {
                return true;
            }
        } else if (v instanceof MyDouble) {
            MyDouble v2 = (MyDouble) v;
            Double x = (Double) v2.value;
            if (x != null && x!=this.realPart) {
                return true;
            }
        } else if (v instanceof Int) {
            Int v2 = (Int) v;
            Integer x = (Integer) v2.value;
            if (x != null && x!=this.realPart) {
                return true;
            }
        } else if (v instanceof ImaginaryInt) {
            ImaginaryInt v3 = (ImaginaryInt) v;
            if (this.realPart != v3.getRealPart() || this.imaginaryPart != v3.getImaginaryPart()) {
                return true;
            }
        } else {
            throw new ArithmeticException("Inequalities of imaginary numbers are not well defined");
        }

        return false;
    }

    @Override
    public boolean eq(Value v) {
        if (v instanceof ImaginaryDouble) {
            ImaginaryDouble v1 = (ImaginaryDouble) v;
            return this.realPart == v1.realPart || this.imaginaryPart == v1.imaginaryPart;
        } else if (v instanceof MyDouble) {
            MyDouble v2 = (MyDouble) v;
            if (v2.value != null) {
                Double x = (Double) v2.value;
                return this.realPart == x;
            } else {
                return false;
            }
        } else if (v instanceof Int) {
            Int v2 = (Int) v;
            if (v2.value != null) {
                Integer x = (Integer) v2.value;
                return this.realPart == x;
            } else {
                return false;
            }
        } else if (v instanceof ImaginaryInt) {
            ImaginaryInt v3 = (ImaginaryInt) v;
            return this.realPart == v3.getRealPart() || this.imaginaryPart == v3.getImaginaryPart();
        } else {
            throw new ArithmeticException("Inequalities of imaginary numbers are not well defined");
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof ImaginaryDouble) {

        }
        throw new ArithmeticException("xd");
    }
    @Override
    public int hashCode(){
        double hashRealPart = Double.hashCode(realPart);
        double hashImaginaryPart = Double.hashCode(imaginaryPart);
        double result = 17;
        result = (Double)(31*17+hashRealPart);
        result = (Double)(31*17+hashImaginaryPart);
        return (int)result;
    }
    @Override
    public boolean lte(Value v) {

        throw new ArithmeticException("Inequalities of imaginary numbers are not well defined ");
    }
    public boolean lt(Value v) {

        throw new ArithmeticException("Inequalities of imaginary numbers are not well defined ");
    }
    public boolean ge(Value v) {

        throw new ArithmeticException("Inequalities of imaginary numbers are not well defined ");
    }
    @Override
    public boolean gte(Value v) {
        throw new ArithmeticException("Inequalities of imaginary numbers are not well defined ");
    }
}