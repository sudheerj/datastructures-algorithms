package java1.algorithms.tree;

import java.util.HashMap;

class Node {
    HashMap<Character, Node> children = new HashMap<>();
    boolean isEnd = false;
}

public class Trie {

    Node root;

    Trie(){
        this.root = new Node();
    }

    //TC: O(n) SC: O(n)
    public void insert(String word) {
        Node curr = root;
        for(char ch: word.toCharArray()) {
            if(!curr.children.containsKey(ch)) {
                curr.children.put(ch, new Node());
            }
            curr = curr.children.get(ch);
        }
        curr.isEnd = true;
    }

    //TC: O(n) SC: O(1)
    public boolean search(String word) {
        Node curr = root;
        for(char ch: word.toCharArray()) {
            if(!(curr.children.containsKey(ch))) {
                return false;
            }
            curr = curr.children.get(ch);
        }
        return curr.isEnd;
    }

    //TC: O(n) SC: O(1)
    public boolean startsWith(String prefix) {
        Node curr = root;
        for(char ch: prefix.toCharArray()) {
            if(!(curr.children.containsKey(ch))) {
                return false;
            }
            curr = curr.children.get(ch);
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app")); 
        trie.insert("app");
        System.out.println(trie.search("app")); 
    }
}