package java1.algorithms.hashmap.groupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    private static List<List<String>> groupAnagrams1(String[] arr){
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String str : arr) {
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String sortedString = new String(strArr);
            anagramGroups.putIfAbsent(sortedString, new ArrayList<>());
            anagramGroups.get(sortedString).add(str);
        }

        return new ArrayList<>(anagramGroups.values());
    }

    //Without sorting: TC(K * N) SC(K * N)
    private static List<List<String>> groupAnagrams2(String[] arr){
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String str : arr) {
            char[] strArr = str.toLowerCase().toCharArray();
            int[] charCount = new int[26];
            for(char ch: strArr){
                charCount[ch-'a']++;
            }
            String charCountkey = Arrays.toString(charCount); 
            anagramGroups.putIfAbsent(charCountkey, new ArrayList<>());
            anagramGroups.get(charCountkey).add(str);
        }

        return new ArrayList<>(anagramGroups.values());
    }

    public static void main(String[] args) {
        // Multiple Anagrams
        System.out.println("Input: ['eat', 'tea', 'tan', 'ate', 'nat', 'bat']");
        System.out.println("Output1: "+ groupAnagrams1(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println("Output2: "+ groupAnagrams2(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println("---------------");

        // Mixed Case Anagrams
        System.out.println("Input: ['Eat', 'Tea', 'Tan', 'Ate', 'Nat', 'Bat']");
        System.out.println("Output1: "+ groupAnagrams1(new String[]{"Eat", "Tea", "Tan", "Ate", "Nat", "Bat"}));
        System.out.println("Output2: "+ groupAnagrams2(new String[]{"Eat", "Tea", "Tan", "Ate", "Nat", "Bat"}));
        System.out.println("---------------");

        // No Anagrams
        System.out.println("Input: ['apple', 'orange', 'banana']");
        System.out.println("Output1: "+ groupAnagrams1(new String[]{"apple", "orange", "banana"}));
        System.out.println("Output2: "+ groupAnagrams2(new String[]{"apple", "orange", "banana"}));
        System.out.println("---------------");

    }
}
