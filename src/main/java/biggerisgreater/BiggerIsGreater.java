package biggerisgreater;

import java.util.Arrays;
import java.util.List;

import static boilerplate.Files.readFile;

public class BiggerIsGreater {

    private static int getFirstSmallCharIndex(String w) {
        for (int i = w.length() - 1; i > 0; i--) {
            if (w.charAt(i) > w.charAt(i - 1)) {
                return i - 1;
            }
        }
        return -1;
    }

    private static int getMinIndexGreaterThen(String w, int start, int i) {
        int min = start;
        for (int j = start; j < w.length(); j++) {
            if (w.charAt(j) < w.charAt(min) && w.charAt(j) > w.charAt(i)) {
                min = j;
            }
        }
        return min;
    }

    private static String swap(String in, int first, int second) {
        char[] c = in.toCharArray();

        char tmp = in.charAt(first);
        c[first] = c[second];
        c[second] = tmp;

        return new String(c);
    }

    /*
     * Complete the 'biggerIsGreater' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING w as parameter.
     */
    public static String biggerIsGreater(String w) {
        int firstSmallCharIndex = getFirstSmallCharIndex(w);
        if (firstSmallCharIndex == -1) {
            return "no answer";
        }
        int min = getMinIndexGreaterThen(w, firstSmallCharIndex + 1, firstSmallCharIndex);

        String r = swap(w, firstSmallCharIndex, min);
        char[] toSort = r.toCharArray();
        Arrays.sort(toSort, firstSmallCharIndex + 1, toSort.length);
        return new String(toSort);
    }


    public static void main(String[] args) throws Exception {

        List<String> inputs = readFile("src/main/java/biggerisgreater/in/input01.txt");
        List<String> outputs = readFile("src/main/java/biggerisgreater/out/output01.txt");

        for (int i = 0; i < inputs.size(); i++) {
            String in = inputs.get(i);
            System.out.println(in);
            String myOut = biggerIsGreater(in);
            String out = outputs.get(i);
            if (!myOut.equals(out)) {
                throw new Exception(myOut + " != " + out);
            }
        }
    }
}

