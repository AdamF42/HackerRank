package codility.ex2;

public class Second {


    public static int solution(int N) {

        Integer inputSum = getIntegerSum(N);

        for (int i = N; i < 90000; i++) { // 90000 (499 -> 4 + 9 + 9 = 22 e 8+9+9+9+9 = 44)
            Integer elemSum = getIntegerSum(i);
            if (inputSum * 2 == elemSum) {
                return i;
            }
        }

        return 0;
    }

    private static Integer getIntegerSum(int N) {
        String num = String.valueOf(N);

        int inputSum = 0;
        for (int i = 0; i < num.length(); i++) {
            inputSum = inputSum + Integer.parseInt(String.valueOf(num.charAt(i)));
        }
        return inputSum;
    }


    public static void main(String[] args) {


        System.out.println(solution(14));
        System.out.println(solution(99));
        System.out.println(solution(1));
        System.out.println(solution(500));
        System.out.println(solution(499));
        System.out.println(solution(10));


    }

}
