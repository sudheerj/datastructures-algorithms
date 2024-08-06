//TC: O(n) SC: O(n)
package java1.algorithms.strings.encodeDecodeStrings;

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
        List<String> decodedStringsList = new ArrayList<>();

        int i=0;
        while(i < str.length()) {
            int j = i;
            while(str.charAt(j) != '#') j++;
            int start = j+1;
            int wordLength = Integer.parseInt(str, i, j, 10);
            String subStr = str.substring(start, start+wordLength);
            decodedStringsList.add(subStr);
            i = start+wordLength;
        }
        return decodedStringsList;
    }

    public static void main(String[] args) {
        String[] strs1 = {"learn", "datastructure", "algorithms", "easily"};
        String encodedStr1 = encodeString(strs1);
        System.out.println(encodedStr1);
        System.out.println(decodeString(encodedStr1));

        String[] strs2 = {"one", "two", "three"};
        String encodedStr2 = encodeString(strs2);
        System.out.println(encodedStr2);
        System.out.println(decodeString(encodedStr2));
    }
}
