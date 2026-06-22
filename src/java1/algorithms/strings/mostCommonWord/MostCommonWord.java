package java1.algorithms.strings.mostCommonWord;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {
    //HashMap + split approach
    private static String mostCommonWord1(String paragraph, String[] banned) {
        Set<String> bannedWordSet = new HashSet<>();
        for(String word: banned) {
            bannedWordSet.add(word);
        }

        String[] words = paragraph.toLowerCase().split("\\W+");

        Map<String, Integer> freqMap = new HashMap<>();

        String commonWord = "";
        int max = 0;

        for(String word: words) {
            if(word.length() == 0 || bannedWordSet.contains(word)) continue;

            int count = freqMap.getOrDefault(word, 0) + 1;
            freqMap.put(word, count);

            if(count > max) {
                max = count;
                commonWord = word;
            }
        }

        return commonWord;
    }
    //Manual parsing + append space trick
    private static String mostCommonWord2(String paragraph, String[] banned) {
        Set<String> bannedWordSet = new HashSet<>();
        for(String word: banned) {
            bannedWordSet.add(word);
        }

        Map<String, Integer> freqMap = new HashMap<>();

        StringBuilder word = new StringBuilder();

        int max = 0;
        String commonWord = "";

        for(char ch: (paragraph + " ").toLowerCase().toCharArray()) {
            if(Character.isLetter(ch)) {
                word.append(ch);
            } else if(word.length() > 0) {
                String currWord = word.toString();

                if(!bannedWordSet.contains(currWord)) {
                    int count = freqMap.getOrDefault(currWord, 0) + 1;
                    freqMap.put(currWord, count);

                    if(count > max) {
                        max = count;
                        commonWord = currWord;
                    }
                }
                word.setLength(0);
            }
        }

        return commonWord;
    }

    public static void main(String[] args) {

        String paragraph;
        String[] banned;

        // Test 1
        paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        banned = new String[]{"hit"};
        System.out.println("Test 1");
        System.out.println("Approach 1: " + mostCommonWord1(paragraph, banned));
        System.out.println("Approach 2: " + mostCommonWord2(paragraph, banned));
        System.out.println();

        // Test 2
        paragraph = "a, a, a, a, b,b,b,c,c";
        banned = new String[]{"a"};
        System.out.println("Test 2");
        System.out.println("Approach 1: " + mostCommonWord1(paragraph, banned));
        System.out.println("Approach 2: " + mostCommonWord2(paragraph, banned));
        System.out.println();

        // Test 3
        paragraph = "Hello hello HELLO world world";
        banned = new String[]{};
        System.out.println("Test 3");
        System.out.println("Approach 1: " + mostCommonWord1(paragraph, banned));
        System.out.println("Approach 2: " + mostCommonWord2(paragraph, banned));
        System.out.println();

        // Test 4
        paragraph = "One fish two fish red fish blue fish";
        banned = new String[]{"fish"};
        System.out.println("Test 4");
        System.out.println("Approach 1: " + mostCommonWord1(paragraph, banned));
        System.out.println("Approach 2: " + mostCommonWord2(paragraph, banned));
        System.out.println();

        // Test 5
        paragraph = "Java! Java? JAVA. Python Python";
        banned = new String[]{"python"};
        System.out.println("Test 5");
        System.out.println("Approach 1: " + mostCommonWord1(paragraph, banned));
        System.out.println("Approach 2: " + mostCommonWord2(paragraph, banned));
        System.out.println();

        // Test 6
        paragraph = "apple banana apple banana apple orange";
        banned = new String[]{"orange"};
        System.out.println("Test 6");
        System.out.println("Approach 1: " + mostCommonWord1(paragraph, banned));
        System.out.println("Approach 2: " + mostCommonWord2(paragraph, banned));
        System.out.println();

        // LeetCode example
        paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        banned = new String[]{"hit"};
        System.out.println("Approach 1: " + mostCommonWord1(paragraph, banned));
        System.out.println("Approach 2: " + mostCommonWord2(paragraph, banned));
    }


}
