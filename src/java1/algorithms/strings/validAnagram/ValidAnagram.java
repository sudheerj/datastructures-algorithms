package java1.algorithms.strings.validAnagram;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {
    
    //Using Array: TC:O(n) SC:O(1)

    private static boolean validAnagram1(String str1, String str2) {
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

    //HashMap:- TC:O(n) SC:O(n)
    private static boolean validAnagram2(String str1, String str2) {
        if(str1.length() != str2.length()) {
            return false;
        }

        HashMap<Character, Integer> hashMap = new HashMap<>();

        for(char ch: str1.toCharArray()) {
            hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);
        }

        for(char ch: str2.toCharArray()) {
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

        return hashMap.size() == 0;
    }

    //Sorting and compare built-in methods:- TC:O(n logn) SC:O(n)
    private static boolean validAnagram3(String str1, String str2) {
        if(str1.length() != str2.length()) {
            return false;
        }

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        
        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }

    //Using Sort, split and join methods:- TC:O(n logn) SC:O(n)
    private static boolean validAnagram4(String str1, String str2) {
        if(str1.length() != str2.length()) {
            return false;
        }

        String[] splitStr1 = str1.split("");
        String[] splitStr2 = str2.split("");

        Arrays.sort(splitStr1);
        Arrays.sort(splitStr2);

        return String.join("", splitStr1).equals(String.join("", splitStr2));
    }
    public static void main(String[] args) {
        String s1 = "anagram", s2="nagaram";
        System.out.println(validAnagram1(s1, s2));
        String t1 = "cat", t2="rat";
        System.out.println(validAnagram1(t1, t2));

        String a1 = "anagram", a2="nagaram";
        System.out.println(validAnagram2(a1, a2));
        String b1 = "cat", b2="rat";
        System.out.println(validAnagram2(b1, b2));

        String x1 = "anagram", x2="nagaram";
        System.out.println(validAnagram3(x1, x2));
        String y1 = "cat", y2="rat";
        System.out.println(validAnagram3(y1, y2));

        String c1 = "anagram", c2="nagaram";
        System.out.println(validAnagram4(c1, c2));
        String d1 = "cat", d2="rat";
        System.out.println(validAnagram4(d1, d2));
    }
}
