package java1.algorithms.hashmap.isomorphicStrings;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    private static boolean isIsomorphic(String s, String t){
        if(s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            if(sMap.containsKey(charS)) {
                if(sMap.get(charS) != charT) {
                    return false;
                }
            } else {
                sMap.put(charS, charT);
            }

            if(tMap.containsKey(charT)) {
                if(tMap.get(charT) != charS) {
                    return false;
                }
            } else {
                tMap.put(charT, charS);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "dad", t1 = "mom";
        String s2 = "zoo", t2 = "cat";
        System.out.println(isIsomorphic(s1, t1));
        System.out.println(isIsomorphic(s2, t2));    
    }
}
