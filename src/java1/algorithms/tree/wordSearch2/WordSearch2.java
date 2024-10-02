package java1.algorithms.tree.wordSearch2;

import java.util.*;

class Node {
    HashMap<Character, Node> children;
    String fullword;

    Node() {
        this.children = new HashMap<>();
        this.fullword = null;
    }
}

public class WordSearch2 {

    Node root;

    WordSearch2() {
        this.root = new Node();
    }

    //TC: O(RC * 4^RC) SC: O(n * l) n = number of words, l= longest word
    public List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();
        Node root = buildTrie(words);

        for(int r = 0; r < board.length; r++) {
            for(int c=0; c < board[0].length; c++) {
                dfs(board, list, root, r, c);
            }
        }

        return list;
    }

    public void dfs(char[][] board, List<String> list, Node curr, int r, int c) {
        if(r < 0 || c < 0 || r >= board.length | c >= board[0].length) return;

        char ch = board[r][c];

        if(ch == '#' || curr.children.get(ch) ==  null) return;
        curr = curr.children.get(ch);
        if(curr.fullword != null) {
            list.add(curr.fullword);
            curr.fullword = null;
        }

        board[r][c] = '#';
         // top, left, down, right
        dfs(board, list, curr, r-1, c);
        dfs(board, list, curr, r, c-1);
        dfs(board, list, curr, r+1, c);
        dfs(board, list, curr, r, c+1);
        board[r][c] = ch;
    }

    public Node buildTrie(String[] words){

        for(String word: words) {
            Node curr = this.root;
            for(char ch: word.toCharArray()) {
                if(!(curr.children.containsKey(ch))) {
                    curr.children.put(ch, new Node());
                }
                curr = curr.children.get(ch);
            }
            curr.fullword = word;
        }
        return this.root;
    }

    public static void main(String[] args) {
        char[][] board1 = {
            {'o','b','e','l'},
            {'k','a','p','p'},
            {'i','n','a','n'},
            {'w','i','p','a'}
        };
        String[] words1 = {"apple","banana","pineapple","kiwi", "orange"};

        char[][] board2 = {
            {'p','q'},
            {'p','q'},
  
        };
        String[] words2 = {"pqpq"};

        WordSearch2 wordSearch2 = new WordSearch2();
        System.out.println(wordSearch2.findWords(board1, words1));    
        System.out.println(wordSearch2.findWords(board2, words2));     
    }
}
