package java1.algorithms.hashmap.letterCombinations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LetterCombinations {

    private static List<String> letterCombinations(String digits){
        List<String> combinations = new ArrayList<>();
        if(digits.isEmpty()) {
            return combinations;
        }

        Map<Character, String> digitToChar = new HashMap<>();
        digitToChar.put('2', "abc");
        digitToChar.put('3', "def");
        digitToChar.put('4', "ghi");
        digitToChar.put('5', "jkl");
        digitToChar.put('6', "mno");
        digitToChar.put('7', "pqrs");
        digitToChar.put('8', "tuv");
        digitToChar.put('9', "wxyz");

        backtrack(0, "", digits, digitToChar, combinations);
        return combinations;
    }

    private static void backtrack(int i, String currStr, String digits, Map<Character, String> digitToChar, List<String> combinations) {
        if(digits.length() == currStr.length()) {
            combinations.add(currStr);
            return;
        }

        for (char ch : digitToChar.get(digits.charAt(i)).toCharArray()) {
            backtrack(i+1, currStr+ch, digits, digitToChar, combinations);
        }
    }
    public static void main(String[] args) {
        String digits1 = "24";
        String digits2 = "";
        System.out.println(letterCombinations(digits1));
        System.out.println(letterCombinations(digits2));

    }
}