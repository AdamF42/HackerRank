package factorial;

import boilerplate.Metrics;

import java.util.function.BiFunction;

public class Factorial {


    public static Integer fact(Integer n) {
        if (n == 0) {
            return 1;
        }
        return n * fact(n - 1);
    }


    // Really a bad idea...Java does not support recursive lambdas function variables without using an anonymous inner class
    public static Integer factTailRec(Integer n) {
        BiFunction<Integer, Integer, Integer> factHelper = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer n, Integer acc) {
                return n == 0 ? acc : this.apply(n - 1, acc * n);
            }
        };
        return factHelper.apply(n, 1);
    }

    public static void main(String[] args) {
        System.out.println(Metrics.getDurationPrint((() -> fact(31))));
        System.out.println(Metrics.getDurationPrint((() -> factTailRec(31))));


        System.out.println(factTailRec(31));
        System.out.println(fact(31));
    }

}
