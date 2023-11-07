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
        if(v instanceof MyDouble){
            MyDouble result  = new MyDouble();
            result.value = (Double)this.value - (Double)(v).value;
            return result;
        }
        throw new RuntimeException("invalid typee");
    }

    @Override
    public Value mul(Value v) {
        if(v instanceof MyDouble){
            MyDouble result  = new MyDouble();
            result.value = (Double)this.value * (Double)((MyDouble)v).value;
            return result;
        }
        throw new RuntimeException("invalid typee");
    }

    @Override
    public Value div(Value v) {
        if(v instanceof MyDouble){
            MyDouble result  = new MyDouble();
            result.value = ((Double)this.value) / (Double)((MyDouble)v).value;
            return result;
        }
        throw new RuntimeException("invalid typee");
    }

    @Override
    public Value pow(Value v){
        if(v instanceof MyDouble){
            MyDouble result = new MyDouble();
            result.value = Math.pow((Double)this.value, (Double)((MyDouble)v).value);
            return result;
        }
        throw new RuntimeException("invalid typee");
    }

    @Override
    public boolean eq(Value v){
        if(v instanceof MyDouble){
            return this.value.equals(((MyDouble)v).value);
        }
        throw new RuntimeException("invalid typee");
    }

    @Override
    public boolean lte(Value v){
        if(v instanceof MyDouble){
            return (Double)this.value <= (Double)((MyDouble)v).value;
        }
        throw new RuntimeException("invalid typee");
    }

    @Override
    public boolean gte(Value v){
        if(v instanceof MyDouble){
            return (Double)this.value >= (Double)((MyDouble)v).value;
        }
        throw new RuntimeException("invalid typee");
    }

    @Override
    public boolean neq(Value v){
        if(v instanceof MyDouble){
            return !this.value.equals(((MyDouble)v).value);
        }
        throw new RuntimeException("invalid typee");
    }

    @Override
    public boolean equals(Object other){
        if(other instanceof MyDouble){
            return this.value.equals(((MyDouble)other).value);
        }
        throw new RuntimeException("invalid typee");
    }


    @Override
    public int hashCode() {
        return this.value.hashCode();
    }
}

