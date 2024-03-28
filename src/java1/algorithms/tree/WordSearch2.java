package java1.algorithms.tree;

import java.util.*;

class DictNode {
    HashMap<Character, DictNode> children;
    String fullword;

    DictNode() {
        this.children = new HashMap<>();
        this.fullword = null;
    }
}

public class WordSearch2 {

    DictNode root;

    WordSearch2() {
        this.root = new DictNode();
    }

    //TC: O(RC * 4^RC) SC: O(n * l) n = number of words, l= longest word
    public List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();
        DictNode root = buildTrie(words);

        for(int r = 0; r < board.length; r++) {
            for(int c=0; c < board[0].length; c++) {
                dfs(board, list, root, r, c);
            }
        }

        return list;
    }

    public void dfs(char[][] board, List<String> list, DictNode curr, int r, int c) {
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

    public DictNode buildTrie(String[] words){

        for(String word: words) {
            DictNode curr = this.root;
            for(char ch: word.toCharArray()) {
                if(!(curr.children.containsKey(ch))) {
                    curr.children.put(ch, new DictNode());
                }
                curr = curr.children.get(ch);
            }
            curr.fullword = word;
        }
        return this.root;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'o','a','a','n'},
            {'e','t','a','e'},
            {'i','h','k','r'},
            {'i','f','l','v'}
        };
        String[] words = {"oath","pea","eat","rain"};
        WordSearch2 wordSearch2 = new WordSearch2();
        System.out.println(wordSearch2.findWords(board, words));        
    }
}
