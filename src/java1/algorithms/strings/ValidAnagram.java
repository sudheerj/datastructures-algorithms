package java1.algorithms.strings;

import java.util.HashMap;

public class ValidAnagram {
    
    //HashMap:- TC:O(n) SC:O(n)
    private static boolean validAnagram1(String str1, String str2) {
        if(str1.length() != str2.length()) {
            return false;
        }

        HashMap<Character, Integer> hashMap = new HashMap<>();

        for(int i = 0; i< str1.length(); i++) {
            char ch = str1.charAt(i);
            hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);
        }

        for(int j=0; j< str2.length(); j++) {
            char ch = str2.charAt(j);
            if(hashMap.containsKey(ch)) {
                if(hashMap.get(ch) == 1) {
                    hashMap.remove(ch);
                } else if(hashMap.get(ch) > 1) {
                    hashMap.put(ch, hashMap.get(ch)-1);
                }
            } else {
                return false;
            }
        }

        if(hashMap.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    //Using Array: TC:O(n) SC:O(1)

    private static boolean validAnagram2(String str1, String str2) {
        if(str1.length() != str2.length()) return false;

        int[] chars = new int[26];

        for(int i=0; i< str1.length(); i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);
            chars[ch1 - 'a']++;
            chars[ch2 - 'a']--;
        }

        for(int ch: chars) {
            if(ch !=0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "anagram", s2="nagaram";
        System.out.println(validAnagram1(s1, s2));
        String t1 = "cat", t2="rat";
        System.out.println(validAnagram1(t1, t2));

        String a1 = "anagram", a2="nagaram";
        System.out.println(validAnagram2(a1, a2));
        String b1 = "cat", b2="rat";
        System.out.println(validAnagram1(b1, b2));
    }
}
