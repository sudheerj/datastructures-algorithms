//TC: O(n) SC: O(n)
package java1.algorithms.strings;

import java.util.*;

public class EncodeDecodeStrings {
    private static String encodeString(String[] strs) {
        String encodedStr = "";
        for(String str: strs) {
            encodedStr += str.length()+"#"+str;
        }
        return encodedStr;
    }

    private static List<String> decodeString(String str) {
        List<String> decodedStrings = new ArrayList<>();

        int i=0;
        while(i < str.length()) {
            int j = i;
            while(str.charAt(j) != '#') j++;
            int wordLength = Integer.parseInt(str, i, j, 10);
            String subStr = str.substring(j+1, j+1+wordLength);
            decodedStrings.add(subStr);
            i = j+1+subStr.length();
        }
        return decodedStrings;
    }

    public static void main(String[] args) {
        String[] strs = {"lint","code","love","you"};
        String encodedStr = encodeString(strs);
        System.out.println(encodedStr);
        System.out.println(decodeString(encodedStr));

    }
}
