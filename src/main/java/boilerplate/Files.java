package boilerplate;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Files {

    public static List<String> readFile(String fileName) throws IOException {
        List<String> result = new ArrayList<>();
        try (Stream<String> stream = java.nio.file.Files.lines(Paths.get(fileName))) {
            stream.forEach(result::add);
        }
        return result;
    }

}
