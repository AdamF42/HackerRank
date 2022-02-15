package smallestpositive;

import java.util.Arrays;

public class SmallestPositive {

    public static int smallestPositive(int[] A) {

        Arrays.sort(A);

        int i ;
        if (A[0] > 1) {
            return 1;
        }
        for (i = 0; i < A.length - 1; i++) {
            if (A[i] > 0) {

                if (A[i + 1] - A[i] > 1) {
                    return A[i] + 1;
                }
                if (i + 1 == A.length-1 ) {
                    return A[i + 1] + 1;
                }
            }
        }

        if (A[i]==1 ) {
            return 2;
        }

        return 1;
    }

    public static void main(String[] args) {

        int[] arr = {1, 3, 6, -1, 4, 1, 2, 0};
        int[] arr2 = {1, 2, 3, 0};
        int[] arr3 = {-1, -3, 1};
        int[] arr5 = {-1, -3, 4};
        int[] arr4 = {-1000000, 0, 1000000};
        int[] arr6 = {2, 3, 4};
        int[] arr7 = {1};
        int[] arr8 = {2};

        System.out.println(smallestPositive(arr));  // 5
        System.out.println(smallestPositive(arr2)); // 4
        System.out.println(smallestPositive(arr3)); // 2
        System.out.println(smallestPositive(arr5)); // 1
        System.out.println(smallestPositive(arr4)); // 1
        System.out.println(smallestPositive(arr6)); // 1
        System.out.println(smallestPositive(arr7)); // 2
        System.out.println(smallestPositive(arr8)); // 1


    }

}
