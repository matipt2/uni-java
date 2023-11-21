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
        throw new RuntimeException("nie dziala sub");
    }

    @Override
    public Value mul(Value v) {
        Int result = new Int();
        result.value = (Integer)this.value*Integer.valueOf(v.value.toString());
        return result;
    }

    @Override
    public Value div(Value v) {
        if(v instanceof Int){
            Int result  = new Int();
            result.value = ((Integer)this.value) / (Integer)((Int)v).value;
            return result;
        }
        throw new RuntimeException("invalid type");
    }

    @Override
    public Value pow(Value v){
        if(v instanceof Int){
            Int result = new Int();
            result.value = Math.pow((Integer)this.value, (Integer)((Int)v).value);
            return result;
        }
        else if(v instanceof MyDouble){
            Int result = new Int();
            result.value = Math.pow((Integer)this.value,(Double)v.value);
            return result;
        }
        return null;
    }

    @Override
    public boolean eq(Value v){
        if(v instanceof Int){
            return this.value.equals(((Int)v).value);
        }
        return false;
    }

    @Override
    public boolean lte(Value v) {
        if (v instanceof MyDouble) {
            return (Double)v.value >= (double)this.value;
        } else if (v instanceof Int) {
            return (int) this.value <= (int)(v.value);
        }
        return false;
    }

    @Override
    public boolean gte(Value v) {
        if (v instanceof MyDouble) {
            return (int)v.value <= (double)this.value;
        } else if (v instanceof Int) {
            return (int)this.value >= (int)v.value;
        }
        return false;
    }

    @Override
    public boolean neq(Value v){
        if(v instanceof Int){
            return !this.value.equals(((Int)v).value);
        }
        return false;
    }

    @Override
    public boolean equals(Object other){
        Int v = new Int();
        v.value = Integer.parseInt(other.toString());
        if(other instanceof Int){
            return this.value != null && this.value.equals(((Int)other).value);
        }
        return false;
    }


    @Override
    public int hashCode() {
        return this.value.hashCode();
    }


}

