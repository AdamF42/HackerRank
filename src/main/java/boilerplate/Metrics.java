package boilerplate;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Supplier;

public class Metrics {


    public static <T> Duration getDuration(Supplier<T> s) {
        Instant start = Instant.now();
        s.get();
        Instant end = Instant.now();
        return Duration.between(start, end);
    }

    public static <T> Duration getDurationPrint(Supplier<T> s) {
        Instant start = Instant.now();
        System.out.println(s.get());
        Instant end = Instant.now();
        return Duration.between(start, end);
    }


}
