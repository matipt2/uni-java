package pl.edu.uj.javaframe;

public class MyDouble extends Value {
    @Override
    public Value create(String val) {
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

    @Override
    public Value sub(Value v) {
        MyDouble result  = new MyDouble();
        result.value = (Double)this.value - Double.valueOf(v.value.toString());
        return result;
    }

    @Override
    public Value mul(Value v) {
        MyDouble result = new MyDouble();
        result.value = (Double)this.value*Double.valueOf(v.value.toString());
        return result;
    }

    @Override
    public Value div(Value v) {
        MyDouble result = new MyDouble();
        result.value = (Double)this.value/Double.valueOf(v.value.toString());
        return result;
    }

    @Override
    public Value pow(Value v){
        if(v instanceof Int){
            MyDouble result = new MyDouble();
            result.value = Math.pow((Double)this.value, (Integer)v.value);
            return result;
        }
        else if(v instanceof MyDouble){
            MyDouble result = new MyDouble();
            result.value = Math.pow((Double)this.value,(Double)v.value);
            return result;
        }
        return null;
    }

    @Override
    public boolean eq(Value v){
        if(v instanceof MyDouble){
            MyDouble result = new MyDouble();
            return result.value == v.value;
        }
        else if(v instanceof Int){
            Int result = new Int();
            return result.value == v.value;
        }
        return false;
    }

    @Override
    public boolean lte(Value v) {
        if (v instanceof MyDouble) {
            return (double) this.value <= (double) v.value;
        } else if (v instanceof Int) {
            return (double)this.value <= (int) v.value;
        }
        return false;
    }

    @Override
    public boolean gte(Value v) {
        if (v instanceof MyDouble) {
            return (double) this.value >= (double) v.value;
        } else if (v instanceof Int) {
            return (double) this.value >= (int) (v.value);
        }
        return false;
    }

    @Override
    public boolean neq(Value v){
        if(v instanceof MyDouble){
            MyDouble result = new MyDouble();
            return this.value != result.value;
        }
        else if(v instanceof Int){
            Int result = new Int();

            return this.value != result.value;
        }
        return false;
    }

    @Override
    public boolean equals(Object other){
        if(other instanceof MyDouble){
            return this.value.equals(((MyDouble)other).value);
        }
        return false;
    }


    @Override
    public int hashCode() {
        return this.value.hashCode();
    }

}

