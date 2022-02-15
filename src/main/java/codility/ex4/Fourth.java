package codility.ex4;

import java.util.Arrays;
import java.util.Comparator;


// User defined Pair class
class Pair {
    int x;
    int y;

    // Constructor
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

public class Fourth {

    public static int solution(int N, int[] A, int[] B) {

        int[] arr = new int[N];

        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] - 1;
            B[i] = B[i] - 1;
        }

        // conto il numero di archi per nodo -- O(m)
        for (int i = 0; i < A.length; i++) {
            arr[A[i]] = arr[A[i]] + 1;
            arr[B[i]] = arr[B[i]] + 1;
        }

//        System.out.println(Arrays.toString(arr));

        // Array of Pair <index, edge_num>
        Pair[] parr = new Pair[arr.length];
        for (int i = 0; i < arr.length; i++) {
            parr[i] = new Pair(i, arr[i]);
        }

        Arrays.sort(parr, Comparator.comparingInt(p -> p.y)); // O(n logn)

//        System.out.println(Arrays.toString(parr));

        int[] vertexValues = new int[N];
        // vertex values
        for (int i = 0; i < parr.length; i++) { // O(n)
            vertexValues[parr[i].x] = i + 1;
        }


        // sommo valore dei nodi -- O(m)
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = sum + vertexValues[A[i]] + vertexValues[B[i]];
        }

        System.out.println("vertexValues: " + Arrays.toString(vertexValues));

        return sum;
    }


    public static void main(String[] args) {

        int N = 5;
        int[] A = {2, 2, 1, 2};
        int[] B = {1, 3, 4, 4};
//        int N = 5;
//        int[] A = {};
//        int[] B = {};

        // forse 31...non mi ricordo
        // devo controllare la somma degli archi e massimizzarla dando i valori in N
        // ovviamente devo tenere in considerazione
        // che succede se il grafo non è connesso

        System.out.println(solution(N, A, B));

    }
}
