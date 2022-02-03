package kaprekarnumbers;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class KaprekarNumbers {

    public static boolean iskaprekarNumber(int num) {
        System.out.println(num);
        String value = String.valueOf(BigInteger.valueOf(num).multiply(BigInteger.valueOf(num)));
        int digits = String.valueOf(num).length();
        String lSubstring = value.substring(0, value.length() - digits);
        String rSubstring;
        if (value.length() % 2 == 0) {
            rSubstring = value.substring(digits);
        } else {
            rSubstring = value.substring(digits - 1);
        }

        int l = Integer.parseInt("".equals(lSubstring) ? "0" : lSubstring);
        int r = Integer.parseInt(rSubstring);

        return l  == num - r;
    }

    public static void kaprekarNumbers(int p, int q) {
        String result = getKaprekarNumbers(p, q+1).stream().map(Object::toString).collect(Collectors.joining(" "));
        if(!result.isEmpty()){
            System.out.println(result);
        } else {
            System.out.println("INVALID RANGE");
        }
    }

    public static List<Integer> getKaprekarNumbers(int p, int q) {
        return IntStream.range(p, q).filter(KaprekarNumbers::iskaprekarNumber).boxed().collect(Collectors.toList());
    }


    public static void main(String[] args) throws Exception {

        kaprekarNumbers(1, 99999);

    }


}
