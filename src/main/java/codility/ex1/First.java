package codility.ex1;

import java.util.HashMap;
import java.util.Map;

public class First {


    public static String solution(String S) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < S.length(); i++) {
            if (map.containsKey(S.charAt(i))) {
                Integer test = map.get(S.charAt(i));
                test = test + 1;
                map.put(S.charAt(i), test);
            } else {
                map.put(S.charAt(i), 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 2) {
                return String.valueOf(entry.getKey());
            }
        }

        return "";
    }

    public static void main(String[] args) {

        String a = "aba";
        String b = "zz";
        String c = "codility";

        System.out.println(solution(a));
        System.out.println(solution(b));
        System.out.println(solution(c));


    }
}
