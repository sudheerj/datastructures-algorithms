package java1.algorithms.hashmap.letterCombinations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LetterCombinations {
        private static final Map<Character, String> phoneMap = new HashMap<>();

        static {
            phoneMap.put('2', "abc");
            phoneMap.put('3', "def");
            phoneMap.put('4', "ghi");
            phoneMap.put('5', "jkl");
            phoneMap.put('6', "mno");
            phoneMap.put('7', "pqrs");
            phoneMap.put('8', "tuv");
            phoneMap.put('9', "wxyz");
        }


    //TC: O(n 4^n) SC: O(n 4^n)
    private static List<String> letterCombinations(String digits){
        List<String> combinations = new ArrayList<>();
        if(digits == null || digits.isEmpty()) {
            return combinations;
        }

        backtrack(0, new StringBuilder(), digits, combinations);
        return combinations;
    }

    private static void backtrack(int index, StringBuilder currStr, String digits, List<String> combinations) {
        if(digits.length() == currStr.length()) {
            combinations.add(currStr.toString());
            return;
        }

        for (char ch : phoneMap.get(digits.charAt(index)).toCharArray()) {
            //choose
            currStr.append(ch);
            //explore
            backtrack(index+1, currStr, digits, combinations);
            //unchoose
            currStr.deleteCharAt(currStr.length()-1);
        }
    }
    public static void main(String[] args) {
        String digits1 = "24";
        String digits2 = "";
        System.out.println(letterCombinations(digits1));
        System.out.println(letterCombinations(digits2));

    }
}