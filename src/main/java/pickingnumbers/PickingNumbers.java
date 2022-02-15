package pickingnumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PickingNumbers {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
        // Write your code here
        return 0;
    }

    // n^2
    public static int pickingNumbersBruteForce(List<Integer> a) {
        a.sort(Comparator.naturalOrder());
        int subSize = 0;
        for (int i = 0; i < a.size(); i++) {
            int sub = 0;
            for (int j = 0; j < a.size() - 1 && i != j; j++) {
                int abs = Math.abs(a.get(i) - a.get(j));
                if (abs <= 1) {
                    sub++;
                }
            }
            if (sub > subSize) {
                subSize = sub;
            }
        }
        return subSize;
    }

    public static int pickingNumbersLessDummy(List<Integer> a) {

        int[] freq = new int[100];

        for (int i = 0; i < a.size(); i++) {
            freq[a.get(i)] = freq[a.get(i)] + 1;
        }

        int sub = 0;
        for (int i = 1; i < freq.length -1; i++) {
            if( freq[i] + freq [i+1] > sub) {
                sub = freq[i] + freq [i+1];
            }
        }

        return sub;
    }

    public static void main(String[] args) {

        List<Integer> arr = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 4, 4, 5, 5, 5));
        List<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 1, 2));
        List<Integer> arr2 = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 1, 99));

        System.out.println(pickingNumbersLessDummy(arr));

    }


}
