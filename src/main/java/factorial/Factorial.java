package factorial;

import boilerplate.Metrics;

import java.util.function.BiFunction;

public class Factorial {

    public static Long factIterative(Long n) {
        long acc = 1L;
        for (long i = n; i > 0; i--) {
            acc = acc * i;
        }
        return acc;
    }

    public static Long fact(Long n) {
        return n == 0 ? 1L : n * fact(n - 1);
    }

    public static Long factTailRec(Long n, Long acc) {
        return n == 0 ? acc : factTailRec(n - 1, acc * n);
    }

    public static Long factTailRec(Long n) {
        BiFunction<Long, Long, Long> factHelper = new BiFunction<Long, Long, Long>() {
            @Override
            public Long apply(Long n, Long acc) {
                return n == 0 ? acc : this.apply(n - 1, acc * n);
            }
        };
        return factHelper.apply(n, 1L);
    }

    public static void main(String[] args) {
        System.out.println(Metrics.getDurationPrint((() -> fact(31))));
        System.out.println(Metrics.getDurationPrint((() -> factTailRec(31))));


        System.out.println(factTailRec(31));
        System.out.println(fact(31));
    }

}
