package boilerplate;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Metrics {


    public static <T> Duration getDuration(Supplier<T> s){
        Instant start = Instant.now();
        System.out.println(s.get());
        Instant end = Instant.now();
        return Duration.between(start, end);
    }


}
