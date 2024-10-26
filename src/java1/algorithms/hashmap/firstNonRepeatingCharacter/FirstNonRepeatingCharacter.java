package java1.algorithms.hashmap.firstNonRepeatingCharacter;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    private static Character firstNonRepeatingChar(String str){
        if(str.length() == 0) return null;

        Map<Character, Integer> charCountsMap = new HashMap<>();
        for(char ch: str.toCharArray()){
            charCountsMap.put(ch, charCountsMap.getOrDefault(ch, 0) +1 );
        }

        for(Map.Entry<Character, Integer> entry: charCountsMap.entrySet()){
            if(entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return null;
    }
    public static void main(String[] args) {
        /**---------------
        All Unique
        --------------- */
        System.out.println("Input: 'abcdefgh'");
        System.out.println("Output: "+ firstNonRepeatingChar("abcdefgh"));
        System.out.println("---------------");

        /**---------------
         Some Duplicates
        --------------- */
        System.out.println("Input: 'abccddefgggh'");
        System.out.println("Output: "+ firstNonRepeatingChar("abccddefgggh"));
        System.out.println("---------------");

        /** ---------------
            All Duplicates
            --------------- */
        System.out.println("Input: 'aabbccdddeeeff'");
        System.out.println("Output: "+ firstNonRepeatingChar("aabbccdddeeeff"));
        System.out.println("---------------");

        /** ---------------
            Empty String
            --------------- */
        System.out.println("Input: ''");
        System.out.println("Output: "+ firstNonRepeatingChar(""));
        System.out.println("---------------");
    }
}
