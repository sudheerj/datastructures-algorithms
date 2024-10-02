//TC: O(RC * 4^RC) SC: O(n * l) n = number of words, l= longest word
class WordSearch2 {

    constructor() {
        this.root = new Node();
    }

    findWords(board, words) {
        let list = [];
        let root = this.buildTrie(words);
        for(let r=0; r < board.length; r++) {
            for(let c=0; c < board[0].length; c++) {
                this.dfs(board, list, root, r, c);
            }
        }
        return list;
    }

    buildTrie(words) {
        for(let word of words){ 
            let curr = this.root;
            for(let ch of word) {
                if(!(ch in curr.children)) {
                    curr.children[ch] = new Node();
                }
                curr = curr.children[ch];
            }
            curr.fullword = word;
        }
        return this.root;
    }

    dfs(board, list, curr, r, c){
        if(r < 0 || c < 0 || r >= board.length || c>= board[0].length) return;

        let ch = board[r][c];
        if(ch === '#' || !curr.children[ch]) return;
        curr = curr.children[ch];
        if(curr.fullword) {
            list.push(curr.fullword);
            curr.fullword = '';
        }
        board[r][c]= '#';
        //top, left, down, right
        this.dfs(board, list, curr, r-1, c);
        this.dfs(board, list, curr, r, c-1);
        this.dfs(board, list, curr, r+1, c);
        this.dfs(board, list, curr, r, c+1);
        board[r][c] = ch;
    }
}

class Node {
    constructor() {
        this.children = {};
        this.fullword = '';
    }
}

let board1 = [
    ['o','b','e','l'],
    ['k','a','p','p'],
    ['i','n','a','n'],
    ['w','i','p','a']
];
let words1 = ["apple","banana","pineapple","kiwi", "orange"];

let board2 = [
    ["p","q"],
    ["p","q"]
];
let words2 = ["pqpq"];

let wordSearch2 = new WordSearch2();
console.log(wordSearch2.findWords(board1, words1));  
console.log(wordSearch2.findWords(board2, words2)); 

