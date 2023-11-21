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
        return realPart +  "i"+ imaginaryPart ;
    }


    public Value create(String val) {
        String targetChar = "i";
        int index = val.indexOf(targetChar);
        if(index != -1){
            String real = val.substring(0, index);
            String imaginary = val.substring(index + 1);
            int realPart = Integer.parseInt(real);
            int imaginaryPart = Integer.parseInt(imaginary);
            return new ImaginaryInt((int) realPart, (int) imaginaryPart);
        }
        else{
            int realPart = Integer.parseInt(val);
            return new ImaginaryInt(realPart);
        }

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
    @Override
    public Value div(Value v) {
        if (v instanceof ImaginaryInt) {
            ImaginaryInt im1 = (ImaginaryInt) v;
            double denominator = Math.pow(im1.getRealPart(), 2) + Math.pow(im1.getImaginaryPart(), 2);
            return new ImaginaryInt((int)((realPart * im1.getRealPart() + imaginaryPart * im1.getImaginaryPart()) / denominator),
                    (int)((imaginaryPart * im1.getRealPart() - realPart * im1.getImaginaryPart()) / denominator));
        } else if (v instanceof Int) {
            Int int1 = (Int) v;
            Integer i = (Integer) int1.value;
            return new ImaginaryInt(realPart / i, imaginaryPart / i);
        } else if (v instanceof ImaginaryDouble) {
            ImaginaryDouble im2 = (ImaginaryDouble) v;
            double denominator = Math.pow(im2.getRealPart(), 2) + Math.pow(im2.getImaginaryPart(), 2);
            return new ImaginaryInt((int)((realPart * im2.getRealPart() + imaginaryPart * im2.getImaginaryPart()) / denominator),
                    (int)((imaginaryPart * im2.getRealPart() - realPart * im2.getImaginaryPart()) / denominator));
        } else if (v instanceof MyDouble) {
            MyDouble double1 = (MyDouble) v;
            Double x = (Double) double1.value;
            return new ImaginaryInt((int)(realPart / x), (int)(imaginaryPart / x));
        } else {
            return this;
        }
    }

    @Override
    public Value sub(Value v) {
        if (v instanceof ImaginaryInt) {
            ImaginaryInt im1 = (ImaginaryInt) v;
            return new ImaginaryInt((int)(realPart - im1.realPart), (int)(imaginaryPart - im1.imaginaryPart));
        }
        else if (v instanceof Int) {
            Int int1 = (Int) v;
            Integer i = (Integer) int1.value;
            return new ImaginaryInt(realPart - i, imaginaryPart);

        } else if (v instanceof ImaginaryDouble) {
            ImaginaryDouble im2 = (ImaginaryDouble) v;
            return new ImaginaryInt((int) (realPart - im2.getRealPart()), (int) (imaginaryPart - im2.getImaginaryPart()));
        } else if (v instanceof MyDouble) {
            MyDouble double1 = (MyDouble) v;
            Double x = (Double) double1.value;
            return new ImaginaryInt((int) (realPart - x), imaginaryPart);
        }  else {
            return this;
        }
    }
    @Override
    public Value mul(Value v) {
        if (v instanceof ImaginaryDouble) {
            ImaginaryDouble im = (ImaginaryDouble) v;
            double res1 = realPart * im.getRealPart() - imaginaryPart * im.getImaginaryPart();
            double res2 = realPart * im.getImaginaryPart() + imaginaryPart * im.getRealPart();
            return new ImaginaryInt((int)res1, (int)res2);
        } else if (v instanceof ImaginaryInt) {
            ImaginaryInt im = (ImaginaryInt) v;
            int res1 = (realPart * im.getRealPart() - imaginaryPart * im.getImaginaryPart());
            int res2 = (realPart * im.getImaginaryPart() + imaginaryPart * im.getRealPart());
            return new ImaginaryInt(res1, res2);
        } else if (v instanceof Int) {
            Int int1 = (Int) v;
            int x1 = (int)int1.value;
            int res1 = realPart * x1;
            int res2 = imaginaryPart*x1;
            return new ImaginaryInt(res1, res2);
        } else if (v instanceof MyDouble) {
            MyDouble double1 = (MyDouble) v;
            double x = (double)double1.value;
            int res1 = (int) (realPart * x);
            int res2 = (int) (imaginaryPart*x);
            return new ImaginaryInt(res1, res2);
        } else {
            return this;
        }
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
    @Override
    public boolean neq(Value v) {
        if (v instanceof ImaginaryDouble) {
            ImaginaryDouble v1 = (ImaginaryDouble) v;
            if (this.realPart != v1.getRealPart() || this.imaginaryPart != v1.getImaginaryPart()) {
                return true;
            }
            return false;
        } else if (v instanceof MyDouble) {
            MyDouble v2 = (MyDouble) v;
            Double x = (Double) v2.value;
            if (this.realPart != x) {
                return true;
            }
        } else if (v instanceof Int) {
            Int v2 = (Int) v;
            Integer x = (Integer) v2.value;
            if (this.realPart != x) {
                return true;
            }
        } else if (v instanceof ImaginaryInt) {
            ImaginaryInt v3 = (ImaginaryInt) v;
            if (this.realPart != v3.getRealPart() || this.imaginaryPart != v3.getImaginaryPart()) {
                return true;
            }
        }
        throw new ArithmeticException("Inequalities of imaginary numbers are not well defined");
    }
    @Override
    public boolean eq(Value v) {
        if (v instanceof ImaginaryDouble) {
            ImaginaryDouble v1 = (ImaginaryDouble) v;
            return this.realPart == v1.getRealPart() || this.imaginaryPart == v1.getImaginaryPart();
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
            if (v3.realPart != (Integer)null && v3.imaginaryPart != (Integer)null) {
                return this.realPart == v3.realPart || this.imaginaryPart == v3.imaginaryPart;
            } else {
                return false;
            }
        } else {
            throw new ArithmeticException("Inequalities of imaginary numbers are not well defined");
        }
    }
    @Override
    public int hashCode(){
        int hashRealPart = Integer.hashCode(realPart);
        int hashImaginaryPart = Integer.hashCode(imaginaryPart);
        int result = 17;
        result = (int)(31*17+hashRealPart);
        result = (int)(31*17+hashImaginaryPart);
        return result;
    }




}