package java1.algorithms.graph.wordLadder2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder2 {
    // BFS for building shortest path graph + DFS -> Backtracking to build paths TC: O(N * M^2 + P * L) SC: O(N * M + P * L); P = Number of shortest paths, L = Length of each path 
    private List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);

        //early exit
        if(!wordSet.contains(endWord)) {
            return result;
        }

        //child -> parent mapping
        Map<String, List<String>> parents = new HashMap<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visited.add(beginWord);

        //stop when endword found
        boolean found = false;
        while(!queue.isEmpty() && !found) {
            int size = queue.size();

            //only contains current level visited words
            Set<String> levelVisited = new HashSet<>();

            for(int i=0; i<size; i++) {
                String word = queue.poll();

                char[] arr = word.toCharArray();
                for(int j=0; j<arr.length; j++) {
                    char original = arr[j];

                    for(char ch='a'; ch< 'z'; ch++) {
                        arr[j] = ch;

                        String nextWord = new String(arr);

                        //skip if the word doesn't exist in dictionary
                        if(!wordSet.contains(nextWord)) continue;

                        //visit first time in BFS graph
                        if(!visited.contains(nextWord)) {
                            queue.add(nextWord);
                            levelVisited.add(nextWord);
                        }

                        // always record parent (important for all shortest paths)
                        parents.computeIfAbsent(nextWord, k -> new ArrayList<>()).add(word);

                        //found endWord
                        if(nextWord.equals(endWord)) {
                            found = true;
                        }
                    }
                    //update with original character
                    arr[j] = original;
                }
            }
            visited.addAll(levelVisited);
        }

        //DFS backtracking for paths
        List<String> path = new ArrayList<>();
        path.add(endWord);
        dfs(endWord, beginWord, path, parents, result);

        return result;
    }

    private void dfs(String word, String beginWord, List<String> path, Map<String, List<String>> parents, List<List<String>> result) {
        if(word.equals(beginWord)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            result.add(temp);
            return;
        }

        //no valid path with word(i.e, child)
        if(!parents.containsKey(word)) return;

        for(String parent: parents.get(word)) {
            path.add(parent);
            dfs(parent, beginWord, path, parents, result);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        WordLadder2 sol = new WordLadder2();

        // Test 1: Classic example — two shortest paths
        System.out.println(sol.findLadders("hit", "cog",
            List.of("hot","dot","dog","lot","log","cog")));
        // Expected: [[hit,hot,dot,dog,cog],[hit,hot,lot,log,cog]]

        // Test 2: Single path
        System.out.println(sol.findLadders("hit", "hot",
            List.of("hot")));
        // Expected: [[hit,hot]]

        // Test 3: endWord not in wordList
        System.out.println(sol.findLadders("hit", "cog",
            List.of("hot","dot","dog","lot","log")));
        // Expected: []

        // Test 4: No transformation possible
        System.out.println(sol.findLadders("abc", "xyz",
            List.of("def","ghi","xyz")));
        // Expected: []

        // Test 5: beginWord equals one transformation away from endWord
        System.out.println(sol.findLadders("a", "c",
            List.of("a","b","c")));
        // Expected: [[a,c]]
    }
}
