package beautifultriplets;

import boilerplate.Metrics;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static boilerplate.Lists.createMatrixFromList;

public class BeautifulTriplets {

    /*
     * Complete the 'beautifulTriplets' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER d
     *  2. INTEGER_ARRAY arr
     */

    public static int beautifulTriplets(int d, List<Integer> arr) {
        int beautifulTripletsCounter = 0;
        List<Integer> js = new ArrayList<>();
        for (int i = 0; i < arr.size() - 2; i++) {
            for (int j = i + 1; j < arr.size() - 1; j++) {
                int Ai = arr.get(i);
                int Aj = arr.get(j);
                if (Aj - Ai == d) {
                    js.add(j);
                }
            }
        }
        for (Integer j : js) {
            for (int k = j + 1; k < arr.size(); k++) {
                int Aj = arr.get(j);
                int Ak = arr.get(k);
                if (Ak - Aj == d) {
                    beautifulTripletsCounter++;
                }
            }
        }
        return beautifulTripletsCounter;
    }

    public static int beautifulTripletsBruteForce(int d, List<Integer> arr) {
        int beautifulTripletsCounter = 0;
        if (arr.size() < 3) {
            return beautifulTripletsCounter;
        }
        for (int i = 0; i < arr.size() - 2; i++) {
            for (int j = i + 1; j < arr.size() - 1; j++) {
                for (int k = j + 1; k < arr.size(); k++) {
                    if (arr.get(j) - arr.get(i) == d && arr.get(k) - arr.get(j) == d) {
                        beautifulTripletsCounter++;
                    }
                }
            }
        }
        return beautifulTripletsCounter;
    }

    public static int beautifulTripletsMatrix(int d, List<Integer> arr) {
        int beautifulTripletsCounter = 0;
        List<List<Integer>> matrix = createMatrixFromList(arr, (a, b) -> a - b);
        for (int i = 0; i < matrix.size() - 2; i++) {
            for (int j = 0; j < matrix.size() - 1; j++) {
                if (matrix.get(j).get(i) == d) {
                    for (List<Integer> integers : matrix) {
                        if (integers.get(j) == d) {
                            beautifulTripletsCounter++;
                        }
                    }
                }
            }
        }
        return beautifulTripletsCounter;
    }


    public static void main(String[] args) {
//        int d = 1;

//        List<Integer> arr = Arrays.asList(1, 2, 4, 5, 7, 8, 10);
//        List<Integer> arr = Arrays.asList(2, 2, 3, 4, 5);
        List<Integer> arr = IntStream.range(0, 10000).boxed().collect(Collectors.toList());

//        System.out.println(Metrics.getDuration(() -> beautifulTripletsBruteForce(1, arr)));
        System.out.println(Metrics.getDuration(() -> beautifulTripletsMatrix(1, arr)));
        System.out.println(Metrics.getDuration(() -> beautifulTriplets(1, arr)));

    }

}
