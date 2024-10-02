package java1.algorithms.tree.wordDictionary;

import java.util.HashMap;

class Node {
    HashMap<Character, Node> children = new HashMap<>();
    boolean isEndOfWord = false;
}
public class WordDictionary {

    private Node root;

    WordDictionary() {
        this.root = new Node();
    }

    public void addWord(String word) {
        Node curr = this.root;

        for(char ch: word.toCharArray()){
            if(!(curr.children.containsKey(ch))) {
                curr.children.put(ch, new Node());
            }
            curr = curr.children.get(ch);
        }
        curr.isEndOfWord = true;
    }

    public boolean searchWord(String word) {
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int index, Node node){
        if(node == null) return false;
        if(index == word.length()) return node.isEndOfWord;
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
        wordDictionary.addWord("bat");
        wordDictionary.addWord("cat");
        wordDictionary.addWord("rat");
        System.out.println(wordDictionary.searchWord("mat"));
        System.out.println(wordDictionary.searchWord("bat"));
        System.out.println(wordDictionary.searchWord(".at")); 
        System.out.println(wordDictionary.searchWord("c.."));     
    }
}
