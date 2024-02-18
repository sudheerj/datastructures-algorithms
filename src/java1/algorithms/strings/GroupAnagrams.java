package java1.algorithms.strings;

import java.util.*;

public class GroupAnagrams {
    //HashMap using sorted strings:- TC:O(n * mlogn) SC:O(n)
    private static List<List<String>> groupAnagram(String[] strs) {
        Map<String, List<String>> hashMap = new HashMap<>();

        for(String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            if(!hashMap.containsKey(sortedStr)) {
                hashMap.put(sortedStr, new ArrayList<>());
            }
            hashMap.get(sortedStr).add(str);
        }

        return new ArrayList<>(hashMap.values());
    }

    //HashMap and char array:- TC:O(n * m) SC:O(n)
    private static List<List<String>> groupAnagram1(String[] strs) {
        Map<String, List<String>> hashMap = new HashMap<>();

        for(String str: strs) {
            int[] charsCount = new int[26];
            
            for(char ch: str.toCharArray()) {
                charsCount[ch - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for(int i=0; i< 26; i++) {
                sb.append("*");
                sb.append(charsCount[i]);
            }

            String key = sb.toString();
            hashMap.putIfAbsent(key, new ArrayList<>());
            hashMap.get(key).add(str);
        }
        return new ArrayList<>(hashMap.values());
    }

    public static void main(String[] args) {
        String[] strs1 = {"eat","tea","tan","ate","nat","bat"};    
        System.out.println(groupAnagram(strs1));   
        System.out.println(groupAnagram1(strs1));   

        String[] strs2 = {"hello"};    
        System.out.println(groupAnagram(strs2));
        System.out.println(groupAnagram1(strs2));
    }
}
