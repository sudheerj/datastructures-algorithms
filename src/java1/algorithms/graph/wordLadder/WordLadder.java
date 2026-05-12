package java1.algorithms.graph.wordLadder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    //Using BFS TC: O(N * L * 26) SC: O(N). Where N = Number of words in dictionary and L = Length of the word
    private static int wordLadder(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);

        //End word must exist
        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int steps = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            // process one BFS level
            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                //Reached target
                if (word.equalsIgnoreCase(endWord)) {
                    return steps;
                }

                char[] arr = word.toCharArray();

                //try changing every character
                for (int j = 0; j < arr.length; j++) {
                    char original = arr[j];

                    //replace with a-z
                    for (char k = 'a'; k <= 'z'; k++) {
                        arr[j] = k;

                        String next = new String(arr);

                        //valid next word
                        if (set.contains(next)) {
                            queue.offer(next);

                            //mark as visited
                            set.remove(next);
                        }
                    }
                    //restore original character
                    arr[j] = original;
                }
            }
            steps++;
        }

        return 0;
    }

    public static void main(String[] args) {
        // hit -> cog -> 5 steps
        System.out.println(wordLadder("hit", "cog",
                List.of("hot", "dot", "dog", "lot", "log", "cog")) + " (expected 5)");

        // hit -> cog, no path -> 0
        System.out.println(wordLadder("hit", "cog",
                List.of("hot", "dot", "dog", "lot", "log")) + " (expected 0)");

        // same begin and end -> 1
        System.out.println(wordLadder("hot", "hot",
                List.of("hot")) + " (expected 1)");

        // one step away
        System.out.println(wordLadder("ab", "cb",
                List.of("cb")) + " (expected 2)");

        // endWord not in list -> 0
        System.out.println(wordLadder("hit", "xyz",
                List.of("hot", "dot", "dog")) + " (expected 0)");
    }
}
