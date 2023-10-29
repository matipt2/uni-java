package pl.edu.uj.javaframe;

public class Int extends Value{
    @Override
    public Value create(String val) {
        Int v = new Int();
        v.value = Integer.parseInt(val);
        return v;
    }

    @Override
    public Value add(Value v) {

        Int result  = new Int();
        if(v.value instanceof Integer){
            result.value = (Integer)this.value + (Integer)v.value;
        }else{
            result.value = (Integer)this.value + Double.valueOf(v.value.toString()).intValue();
        }


        return result;
    }
    @Override
    public Value sub(Value v) {
        if(v instanceof Int){
            Int result  = new Int();
            result.value = (Integer)this.value - (Integer)((Int)v).value;
            return result;
        }
        throw new RuntimeException("invalid typee");
    }

    @Override
    public Value mul(Value v) {
        if(v instanceof Int){
            Int result  = new Int();
            result.value = (Integer)this.value * (Integer)((Int)v).value;
            return result;
        }
        throw new RuntimeException("invalid typee");
    }

    @Override
    public Value div(Value v) {
        if(v instanceof Int){
            Int result  = new Int();
            result.value = ((Integer)this.value) / (Integer)((Int)v).value;
            return result;
        }
        throw new RuntimeException("invalid typee");
    }

    @Override
    public Value pow(Value v){
        if(v instanceof Int){
            Int result = new Int();
            result.value = Math.pow((Integer)this.value, (Integer)((Int)v).value);
            return result;
        }
        throw new RuntimeException("invalid typee");
    }

    @Override
    public boolean eq(Value v){
        if(v instanceof Int){
            return this.value.equals(((Int)v).value);
        }
        throw new RuntimeException("invalid typee");
    }

    @Override
    public boolean lte(Value v){
        if(v instanceof MyDouble){
            return (Integer)this.value <= (Integer)((Int)v).value;
        }
        throw new RuntimeException("invalid typee");
    }

    @Override
    public boolean gte(Value v){
        if(v instanceof MyDouble){
            return (Integer)this.value >= (Integer)((Int)v).value;
        }
        throw new RuntimeException("invalid typee");
    }

    @Override
    public boolean neq(Value v){
        if(v instanceof Int){
            return !this.value.equals(((Int)v).value);
        }
        throw new RuntimeException("invalid typee");
    }

    @Override
    public boolean equals(Object other){
        if(other instanceof Int){
            return this.value.equals(((Int)other).value);
        }
        throw new RuntimeException("invalid typee");
    }


    @Override
    public int hashCode() {
        return this.value.hashCode();
    }
}

