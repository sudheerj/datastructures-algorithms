package java1.algorithms.hashmap.firstUniqueCharacter;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {
    private static int firstUniqChar(String str){
        Map<Character, Integer> charCount = new HashMap<>();

        for(char ch: str.toCharArray()){
            charCount.put(ch, charCount.getOrDefault(ch, 0)+1);
        }

        for (int i = 0; i < str.length(); i++) {
            if(charCount.get(str.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String str1 = "zeep";
        String str2 = "mama";

        System.out.println(firstUniqChar(str1));
        System.out.println(firstUniqChar(str2));
    }
}
