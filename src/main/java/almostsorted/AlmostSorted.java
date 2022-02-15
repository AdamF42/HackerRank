package almostsorted;

import boilerplate.Metrics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class AlmostSorted {

    /*
     * Complete the 'almostSorted' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static void almostSorted(List<Integer> arr) {
        if (isSorted(arr)) {
            System.out.println("yes");
            return;
        }
        List<Integer> sortedArr = arr.stream().sorted().collect(toList());

        boolean isSwappable = true;
        Integer l = null;
        Integer r = null;
        for (int i = 0; i < arr.size() && isSwappable; i++) {
            if (!Objects.equals(arr.get(i), sortedArr.get(i)) && r != null && l != null) {
                isSwappable = false;
            }
            if (!Objects.equals(arr.get(i), sortedArr.get(i)) && l == null) {
                l = i + 1;
                continue;
            }
            if (!Objects.equals(arr.get(i), sortedArr.get(i)) && r == null) {
                r = i + 1;
            }
        }

        if (isSwappable) {
            System.out.println("yes");
            System.out.println("swap " + l + " " + r);
            return;
        }

        l = null;
        r = null;
        boolean isReversible = true;
        int j = arr.size() - 1;
        int i = 0;
        while (i <= j && isReversible) {
            if (!Objects.equals(arr.get(i), sortedArr.get(i)) && r != null && l != null) {
                if (!Objects.equals(arr.get(i), sortedArr.get(j))) {
                    isReversible = false;
                }
                j--;
                i++;
            }
            if (!Objects.equals(arr.get(i), sortedArr.get(i)) && l == null) {
                l = i;
            }
            if (!Objects.equals(arr.get(j), sortedArr.get(j)) && r == null) {
                r = j;
            }
            if (i == j && Objects.equals(arr.get(i), sortedArr.get(j))) {
                break;
            }
            if (l == null) {
                i++;
            }
            if (r == null) {
                j--;
            }
        }

        if (isReversible) {
            l++;
            r++;
            System.out.println("yes");
            System.out.println("reverse " + l + " " + r);
            return;
        }

        System.out.println("no");

    }


    private static boolean isSorted(List<Integer> arr) {
        for (int i = 1; i < arr.size(); i++) {
            if (!(arr.get(i - 1) < arr.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        String in = "src/main/java/almostsorted/in.txt";
        String in2 = "src/main/java/almostsorted/in2.txt"; //reverse 37346 45458

        BufferedReader bufferedReader = new BufferedReader(new FileReader(in2));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

//        System.out.println(isSorted(Arrays.asList(1, 2, 3, 4, 5)));
//        System.out.println(isSorted(Arrays.asList(1, 2, 3, 5, 4)));
//        System.out.println(isSorted(Arrays.asList(2, 3, 5, 4)));

//        almostSorted(Arrays.asList(4, 2)); // swap 1 2
//        almostSorted(Arrays.asList(4, 3, 2, 1)); // reverse 1 4
//        almostSorted(Arrays.asList(1, 5, 4, 3, 2, 6,7,78,10)); // no
//        almostSorted(Arrays.asList(1, 5, 4, 3, 2, 6,7,78)); // reverse 2 5
        Metrics.getDuration(() -> {
            almostSorted(arr);
            return "";
        }); // reverse 2 5
        almostSorted(Arrays.asList(3, 1, 2)); // no
//        almostSorted(Arrays.asList(2, 3, 5, 4));
//        almostSorted(Arrays.asList(1, 2, 3, 6, 5, 4));
//        almostSorted(Arrays.asList(1, 2, 3, 6, 5, 4, 9, 8));

    }

}
