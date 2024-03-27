package java1.algorithms.tree;

import java.util.HashMap;

class Node {
    HashMap<Character, Node> children = new HashMap<>();
    boolean isEnd = false;
}
public class WordDictionary {

    Node root;

    WordDictionary() {
        this.root = new Node();
    }

    //TC: O(n) OC: O(n)
    public void addWord(String word) {
        Node curr = this.root;

        for(char ch: word.toCharArray()){
            if(!(curr.children.containsKey(ch))) {
                curr.children.put(ch, new Node());
            }
            curr = curr.children.get(ch);
        }
        curr.isEnd = true;
    }

    //TC: O(n^2) OC: O(n)
    public boolean searchWord(String word) {
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int index, Node node){
        if(index == word.length()) return node.isEnd;
        if(word.charAt(index) == '.') {
            for(char ch: node.children.keySet()) {
                if(dfs(word, index+1, node.children.get(ch))) return true;
            }
            return false;
        } else {
            if(node.children.get(word.charAt(index)) == null) return false;
            return dfs(word, index+1, node.children.get(word.charAt(index)));
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.searchWord("pad"));
        System.out.println(wordDictionary.searchWord("bad"));
        System.out.println(wordDictionary.searchWord(".ad")); 
        System.out.println(wordDictionary.searchWord("b.."));     
    }
}
