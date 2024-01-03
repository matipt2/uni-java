package pl.edu.uj.javaframe;

import java.util.ArrayList;

    public class Factorize implements Applayable {
        @Override
        public void apply(Series v) {
            Series result = new Series(v.type, v.name);

            for (Value val : v.values) {
                try {
                    Int intVal = (Int) val;
                    int num = (int) intVal.value;

                    ArrayList<Integer> factors = factorize(num);
                    int sum = 0;
                    for (Integer factor : factors) {
                        int intValue = factor.intValue();
                        sum += intValue;
                    }
                    result.addValue(Integer.toString(sum));
                } catch (FactorizationException e) {
                    System.err.println("Factorization error: " + e.getMessage());
                }
            }
            v.values = result.values;
        }

        private ArrayList<Integer> factorize(int num) throws FactorizationException {
            if (num <= 0) {
                throw new FactorizationException("invalid number for factorization " + num);
            }
            ArrayList<Integer> factors = new ArrayList<>();
            for (int i = 2; i <= num; i++) {
                while (num % i == 0) {
                    factors.add(i);
                    num /= i;
                }
            }
            return factors;
        }
    }