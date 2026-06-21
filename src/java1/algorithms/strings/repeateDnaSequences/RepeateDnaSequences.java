package java1.algorithms.strings.repeateDnaSequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeateDnaSequences {
    //Sliding window + HashSets TC: O(n) SC: O(n)
    private static List<String> findRepeatedDnaSequences(String s) {
        if(s.length() < 10) {
            return new ArrayList<>();
        }

        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        for(int i=0; i<s.length()-10; i++) {
            String sequence = s.substring(i, i+10);
            if(!seen.add(sequence)) {
                repeated.add(sequence);
            }
        }
        return new ArrayList<>(repeated);
    }
    public static void main(String[] args) {
        String[] tests = {
            "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
            "AAAAAAAAAAA",
            "AAAAAAAAAAAA",
            "ACGTACGTAC",
            "ACGTACGTACGTACGTACGT",
            "",
            "AAAAA",
            "CCCCCCCCCCCCCCCCCCCC"
        };

        for (String s : tests) {
            System.out.println("Input : " + s);
            System.out.println("Output: " + findRepeatedDnaSequences(s));
            System.out.println("-------------------------");
        }
    }
}
