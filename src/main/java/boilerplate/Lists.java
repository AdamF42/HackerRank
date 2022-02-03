package boilerplate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Lists {

    public static <T> List<T> reverse(List<T> arr) {
        arr = new ArrayList<>(arr);
        return reverse(arr, new ArrayList<>());
    }

    private static <T> List<T> reverse(List<T> arr, List<T> acc) {
        if (arr.size() == 0) {
            return acc;
        }
        T elem = arr.remove(arr.size() - 1);
        acc.add(elem);
        return reverse(arr, acc);
    }

    public static <T> List<List<T>> createMatrixFromList(List<T> arr, BiFunction<T, T, T> fun) {
        List<List<T>> matrix = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            List<T> row = new ArrayList<>();
            for (T elem2 : arr) {
                T elem1 = arr.get(i);
                T matrixElem = fun.apply(elem1, elem2);
                row.add(matrixElem);
            }
            matrix.add(row);
        }

        return matrix;
    }

    public static <T> List<List<T>> createMatrixFromList(List<T> arr, int nCol) {
        List<List<T>> matrix = new ArrayList<>();
        for (int i = 0; i < arr.size(); i = i + nCol) {
            List<T> row = new ArrayList<>();
            for (int j = i; j < i + nCol && j < arr.size(); j++) {
                row.add(arr.get(j));
            }
            matrix.add(row);
        }
        return matrix;
    }

    public static <T> void printMatrix(List<List<T>> matrix) {
        for (List<T> row : matrix) {
            System.out.println(row.stream().map(Object::toString).collect(Collectors.joining(" ")));
        }
    }

    public static <T> List<List<T>> generatePermutations(List<T> arr) {
        List<List<T>> globalAcc = new ArrayList<>();
        return generatePermutations(arr, new ArrayList<>(), globalAcc);

    }

    private static <T> List<List<T>> generatePermutations(List<T> arr, List<T> acc, List<List<T>> globalAcc) {

        if (arr.size() == 0) {
            globalAcc.add(new ArrayList<>(acc));
        } else {
            for (T e : arr) {
                List<T> subArr = new ArrayList<>(arr);
                subArr.remove(e);
                acc.add(e);
                generatePermutations(subArr, new ArrayList<>(acc), globalAcc);
                acc.remove(e);
            }
        }
        return globalAcc;
    }

}
