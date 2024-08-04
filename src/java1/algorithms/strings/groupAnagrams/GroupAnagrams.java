package java1.algorithms.strings.groupAnagrams;

import java.util.*;

public class GroupAnagrams {

        //HashMap and char array:- TC:O(n * m) SC:O(n)
        private static List<List<String>> groupAnagram1(String[] strs) {
            Map<String, List<String>> groupAnagramMap = new HashMap<>();
    
            for(String str: strs) {
                int[] charsCount = new int[26];
                
                for(char ch: str.toCharArray()) {
                    charsCount[ch - 'a']++;
                }
    
                StringBuilder sb = new StringBuilder();
                for(int num: charsCount) {
                    sb.append("*");
                    sb.append(num);
                }
    
                String key = sb.toString();
                groupAnagramMap.putIfAbsent(key, new ArrayList<>());
                groupAnagramMap.get(key).add(str);
            }
            return new ArrayList<>(groupAnagramMap.values());
        }
        
    //HashMap using sorted strings:- TC:O(n * mlogn) SC:O(n)
    private static List<List<String>> groupAnagram2(String[] strs) {
        Map<String, List<String>> groupAnagramMap = new HashMap<>();

        for(String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            if(!groupAnagramMap.containsKey(sortedStr)) {
                groupAnagramMap.put(sortedStr, new ArrayList<>());
            }
            groupAnagramMap.get(sortedStr).add(str);
        }

        return new ArrayList<>(groupAnagramMap.values());
    }

    public static void main(String[] args) {
        String[] strs1 = {"eat","tea","tan","ate","nat","bat"};    
        System.out.println(groupAnagram1(strs1));   
        System.out.println(groupAnagram2(strs1));   

        String[] strs2 = {"hello"};    
        System.out.println(groupAnagram1(strs2));
        System.out.println(groupAnagram2(strs2));
    }
}
