package formingmagicsquare;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static boilerplate.Lists.*;

public class FormingMagicSquare {

    /*
     * Complete the 'formingMagicSquare' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY s as parameter.
     */

    public static int formingMagicSquare(List<List<Integer>> s) {

        Set<Integer> allN = new HashSet<>();

        int nSquare = s.size() * s.size();

        for (int i = 1; i < nSquare + 1; i++) {
            allN.add(i);
        }

        Set<Integer> presentN = new HashSet<>();

        for (int i = 0; i < s.size(); i++) {
            for (int j = 0; j < s.size(); j++) {
                presentN.add(s.get(j).get(i));
            }
        }
        System.out.println(allN);
        System.out.println(presentN);
        allN.removeAll(presentN);
        System.out.println(allN);

        int magicCostant = (nSquare * (nSquare + 1)) / (2 * s.size());

        System.out.println(magicCostant);

        return 0;
    }

    public static int formingMagicSquareBruteForce(List<List<Integer>> s) {
        return generatePermutations(IntStream.range(1, s.size() * s.size() + 1).boxed().collect(Collectors.toList()))
                .stream()
                .map(e -> createMatrixFromList(e, 3))
                .filter(FormingMagicSquare::isMagic)
                .map(e -> getCost(s, e))
                .min(Integer::compare).orElse(0);
    }

    // n^2
    private static boolean isMagic(List<List<Integer>> matrix) {
        int magicCostant = ((matrix.size() * matrix.size()) * ((matrix.size() * matrix.size()) + 1)) / (2 * matrix.size());
        boolean areRowsMagic = true;
        boolean areColsMagic = true;
        boolean areDiagonalMagic = true;
        for (int i = 0; i < matrix.size(); i++) {
            int row_sum = 0;
            for (int j = 0; j < matrix.size(); j++) {
                row_sum = row_sum + matrix.get(i).get(j);
            }
            areRowsMagic = areRowsMagic && row_sum == magicCostant;
        }

        for (int i = 0; i < matrix.size(); i++) {
            int col_sum = 0;
            for (int j = 0; j < matrix.size(); j++) {
                col_sum = col_sum + matrix.get(j).get(i);
            }
            areColsMagic = areColsMagic && col_sum == magicCostant;
        }
        int d1 = 0;
        int d2 = 0;
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.size(); j++) {
                if (i == j) {
                    d1 = d1 + matrix.get(i).get(j);
                }
                if (i + j == matrix.size() - 1) {
                    d2 = d2 + matrix.get(i).get(j);
                }
            }
        }
        areDiagonalMagic = d1 == magicCostant && d2 == magicCostant;

        return areRowsMagic && areColsMagic && areDiagonalMagic;
    }

    // n^2
    private static int getCost(List<List<Integer>> given, List<List<Integer>> calculated) {
        int cost = 0;
        for (int i = 0; i < given.size(); i++) {
            for (int j = 0; j < given.size(); j++) {
                cost = cost + Math.abs(calculated.get(j).get(i) - given.get(j).get(i));
            }
        }

        if (cost == 8) {
            printMatrix(calculated);
        }

        return cost;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(5, 3, 4, 1, 5, 8, 6, 4, 2));
        List<Integer> arr2 = new ArrayList<>(Arrays.asList(8, 3, 4, 1, 5, 9, 6, 7, 2));

        List<List<Integer>> matrix = createMatrixFromList(arr, 3);
        List<List<Integer>> matrix2 = createMatrixFromList(arr2, 3);
        List<List<Integer>> matrix3 = createMatrixFromList(new ArrayList<>(Arrays.asList(2, 5, 4, 4, 6, 9, 4, 5, 2)), 3);
        List<List<Integer>> matrix4 = createMatrixFromList(new ArrayList<>(Arrays.asList(5, 6, 4, 1, 8, 9, 3, 7, 2)), 3);
        List<List<Integer>> matrix5 = createMatrixFromList(new ArrayList<>(Arrays.asList(4, 9, 2, 3, 5, 7, 8, 1, 5)), 3);
        List<List<Integer>> matrix6 = createMatrixFromList(new ArrayList<>(Arrays.asList(4, 5, 8, 2, 4, 1, 1, 9, 7)), 3);

        System.out.println(formingMagicSquareBruteForce(matrix6));


    }


}
