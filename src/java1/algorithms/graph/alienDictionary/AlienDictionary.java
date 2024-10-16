package java1.algorithms.graph.alienDictionary;

import java.util.*;

public class AlienDictionary {

    //BFS(Topological sorting through Kahn's algorithm):- TC: O(V+E) SC:O(V+E)
    private static String alienOrder1(String[] words) {
        if(words == null || words.length == 0) return null;

        Map<Character, List<Character>> adjList = new HashMap<>();
        int[] inDegree = new int[26];

        for(int i=0; i< words.length-1; i++) {
            String currWord = words[i], nextWord = words[i+1];
            if(currWord.length() > nextWord.length() && currWord.substring(0, nextWord.length()).equals(nextWord)) {
                return "";
            }
            for(int j=0; j< Math.min(currWord.length(), nextWord.length()); j++) {
                char ch1 = currWord.charAt(j);
                char ch2 = nextWord.charAt(j);
                if(ch1 != ch2) {
                    if(!adjList.containsKey(ch1)) {
                        adjList.put(ch1, new ArrayList<>());
                    }
                    adjList.get(ch1).add(ch2);
                    inDegree[ch2- 'a']++;
                    break;
                }
            }
        }

        Set<Character> uniqueLetters = new HashSet<>();
        for(String word: words) {
            for(char ch: word.toCharArray()) {
                uniqueLetters.add(ch);
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for(char ch: uniqueLetters) {
            if(inDegree[ch-'a'] == 0) {
                queue.add(ch);
            }
        }

        String topSort = "";
        while(!queue.isEmpty()) {
            char ch = queue.poll();
            topSort += ch;
            if(adjList.get(ch) == null) continue;
            for(char neighbour: adjList.get(ch)) {
                if(--inDegree[neighbour-'a'] == 0) {
                    queue.add(neighbour);
                }
            }
        }
        return topSort.length() == uniqueLetters.size() ? topSort : "";
    }

    //DFS-> TC: O(V+E) SC:O(V+E)
    private static String alienOrder2(String[] words) {
        if(words == null || words.length == 0) return null;

        Map<Character, Set<Character>> adjList = new HashMap<>();
        Map<Character, Boolean> visitState = new HashMap<>();
        List<Character> result = new ArrayList<>();

        for (String word : words) {
            for (Character ch : word.toCharArray()) {
                adjList.putIfAbsent(ch, new HashSet<>());
            }
        }

        for (int i = 0; i < words.length-1; i++) {
            String firstWord = words[i];
            String secondWord = words[i+1];

            if(firstWord.length() > secondWord.length() && firstWord.substring(0, secondWord.length()).equals(secondWord)) {
                return "";
            }

            for (int j = 0; j < Math.min(firstWord.length(), secondWord.length()); j++) {
                if(firstWord.charAt(j) != secondWord.charAt(j)) {
                    adjList.get(firstWord.charAt(j)).add(secondWord.charAt(j));
                    break;
                }
            }
        }

        for (Character ch: adjList.keySet()) {
            if(dfs(ch, adjList, visitState, result)) return "";
        }

        Collections.reverse(result);
        StringBuilder sb = new StringBuilder();
        for (Character ch : result) {
            sb.append(ch);
        }

        return sb.toString();
    }

    private static boolean dfs(Character ch, Map<Character, Set<Character>> adjList, Map<Character, Boolean> visitState, List<Character> result){
        if(visitState.containsKey(ch)) {
            return visitState.get(ch);
        }

        visitState.put(ch, true);
        for (Character neighbour : adjList.get(ch)) {
            if(dfs(neighbour, adjList, visitState, result)) return true;
        }
        visitState.put(ch, false);
        result.add(ch);
        return false;
    }

    public static void main(String[] args) {
        String[] words1 =  {"grs", "grk", "dr", "dss", "rkss"};
        System.out.println(alienOrder1(words1));
        System.out.println(alienOrder2(words1));

        String[] words2 =  {"t", "r"};
        System.out.println(alienOrder1(words2));
        System.out.println(alienOrder2(words2));
    }
    
}
