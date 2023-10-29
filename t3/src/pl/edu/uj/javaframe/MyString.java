package pl.edu.uj.javaframe;

public class MyString extends Value {
    @Override
    public Value create(String val) {
        MyString v = new MyString();
        v.value = val;
        return v;
    }

    @Override
    public Value add(Value v) {
        return null;
    }


    @Override
        public Value sub(Value v) {
                    throw new UnsupportedOperationException("invalid");
                }

                @Override
                public Value mul(Value v) {
                    throw new UnsupportedOperationException("invalid");
                }

                @Override
                public Value div(Value v) {
                    throw new UnsupportedOperationException("invalid");

                }

                @Override
                public Value pow(Value v){
                    throw new UnsupportedOperationException("invalid");

                }

                @Override
                public boolean eq(Value v){
                    return this.value.equals(v.value);
                }

                @Override
                public boolean lte(Value v){
                    throw new UnsupportedOperationException("invalid");

                }

                @Override
                public boolean gte(Value v){
                    throw new UnsupportedOperationException("invalid");

                }

                @Override
                public boolean neq(Value v){
                    return !this.value.equals(v.value);
                }

                @Override
                public boolean equals(Object other){
                    if(other instanceof MyString){
                        return this.value.equals(((MyString)other).value);
                    }
                    throw new RuntimeException("invalid type");
                }

                @Override
                public int hashCode() {
                    return this.value.hashCode();
                }
            }