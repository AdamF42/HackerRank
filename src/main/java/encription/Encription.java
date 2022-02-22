package encription;

public class Encription {

    public static String encryption(String s) {

        String trimmedText = s.trim();
        int L = trimmedText.length();
        System.out.println(L);
        double sqrtL = Math.sqrt(L);
        int ceil = (int) Math.ceil(sqrtL);

        StringBuilder result = new StringBuilder();

        char[] trimmedTextArr = trimmedText.toCharArray();

        for (int i = 0; i < ceil; i++) {

            for (int j = i; j < L; j = j + ceil) {
                result.append(trimmedTextArr[j]);
            }
            if (i < ceil - 1) {
                result.append(" ");
            }

        }
        return result.toString();
    }

    public static void main(String[] args) {
        String in = "ch";
        String in1 = "ifmanwasmeanttostayonthegroundgodwouldhavegivenusroots";
        String in2 = "feedthedog";
        String in3 = "haveaniceday";
        String in5 = "haveanice";
        String in4 = "wclwfoznbmyycxvaxagjhtexdkwjqhlojykopldsxesbbnezqmixfpujbssrbfhlgubvfhpfliimvmnny";
        String expected = "clu hlt io";
        String expected1 = "imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau";
        String expected2 = "fto ehg ee dd";
        String expected3 = "hae and via ecy";
        String expected5 = "hei aac vne";
        String expected4 = "wmgjpnull cyjqlejgi lyhhdzbui wctlsqsbm fxeoxmsvv ovxjeirfm zadysxbhn nxkkbffpn bawobphfy";


        String out = encryption(in5);

        System.out.println(expected5);
        System.out.println(out);

        System.out.println(expected5.equalsIgnoreCase(out));

    }


}
