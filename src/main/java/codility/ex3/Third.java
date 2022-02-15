package codility.ex3;

import java.math.BigInteger;
import java.util.Random;

public class Third {


    public static int solution(String S) {


        int nBlocks = 1;
        int max = 1;
        int localBlockLen = 1;

        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i-1)==S.charAt(i)){
                localBlockLen++;
                if(localBlockLen > max){
                    max = localBlockLen;
                }
            } else {
                nBlocks++;
                localBlockLen = 1;
            }
        }

        BigInteger test = BigInteger.valueOf(nBlocks).multiply(BigInteger.valueOf(max));
        BigInteger test2 = test.subtract(BigInteger.valueOf(S.length()));
        BigInteger test3 = BigInteger.valueOf(S.length());


//        return BigInteger.valueOf(nBlocks).multiply(BigInteger.valueOf(max)).subtract(BigInteger.valueOf(S.length()));
        return  nBlocks*max - S.length();
    }


    public static void main(String[] args) {

        String s = "babaa";
        String s2 = "bbbab";
        String s3 = "bbbaaabbb";
        String s4 = "a";
        String s5 = "b";

//        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

        int leftLimit = 97; // numeral '0'
        int rightLimit = 98; // letter 'z'
        int targetStringLength = 45000; // 20000 -> 399980000   1599960000
        Random random = new Random(); //                        2147483647

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        generatedString = "";
        for (int i = 0; i < targetStringLength; i++){
            if (i%2==0){
                generatedString = generatedString + "a";
            } else {
                generatedString = generatedString + "b";
            }
        }
        String complementedString = new String(new char[90000-generatedString.length()]).replace("\0", "b");
        System.out.println(generatedString);
        System.out.println(complementedString);
//
//        System.out.println(solution(s));
//        System.out.println(solution(s2));
//        System.out.println(solution(s3));
//        System.out.println(solution(s4));
//        System.out.println(solution(s5));
        System.out.println(solution(generatedString+complementedString));


    }
}
