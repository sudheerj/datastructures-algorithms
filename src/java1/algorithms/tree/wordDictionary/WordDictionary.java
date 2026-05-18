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

    // TC: O(n) SC: O(n)
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

    //TC: O(26^n) SC: O(n)
    public boolean searchWord(String word) {
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int index, Node node){
        if(node == null) return false;
        //Reached end of word
        if(index == word.length()) return node.isEndOfWord;

        char ch = word.charAt(index);

        //wildcard case
        if(ch == '.') {
            for(Node child: node.children.values()) {
                if(dfs(word, index+1, child)) return true;
            }
            return false;
        }

        //normal character case
        return dfs(word, index+1, node.children.get(ch));
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
