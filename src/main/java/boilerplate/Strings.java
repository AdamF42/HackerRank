package boilerplate;

public class Strings {

    public static String positions(String str)
    {
        String r = "";
        for (int i = 0; i < str.length(); i++) {
            // Performing AND operation
            // with number 31
            r = r+(str.charAt(i) & 31) + " ";
        }
        return r;
    }
}
