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
            curr.word = word;
        }
        return this.root;
    }

    dfs(board, list, curr, r, c){
        if(r < 0 || c < 0 || r >= board.length || c>= board[0].length) return;

        let ch = board[r][c];
        if(ch === '#' || !curr.children[ch]) return;
        curr = curr.children[ch];
        if(curr.word) {
            list.push(curr.word);
            curr.word = '';
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
        this.word = '';
    }
}

let board = [
    ['o','a','a','n'],
    ['e','t','a','e'],
    ['i','h','k','r'],
    ['i','f','l','v']
];
let words = ["oath","pea","eat","rain"];
let wordSearch2 = new WordSearch2();
console.log(wordSearch2.findWords(board, words));   