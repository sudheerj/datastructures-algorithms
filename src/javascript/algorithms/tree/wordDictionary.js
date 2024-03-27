class Node {
    constructor() {
        this.children = {};
        this.isEnd = false;
    }
}

class WordDictionary {

    constructor() {
        this.root = new Node();
    }

    //TC: O(n) OC: O(n)
    addWord(word) {
        let curr = this.root;

        for(let ch of word) {
            if(!(ch in curr.children)) {
                curr.children[ch] = new Node();
            }
            curr = curr.children[ch];
        }
        curr.isEnd = true;
    }

    //TC: O(n^2) OC: O(n)
    searchWord(word) {
        return this.dfs(word, 0, this.root);
    }

    dfs(word, index, node) {
        if(!node) return false;
        if(index === word.length) return node.isEnd;

        if(word[index] === '.') {
            for(const ch of Object.keys(node.children)) {
                if(this.dfs(word, index+1, node.children[ch])) return true;
            }
            return false;
        } else {
            if(!node.children[word[index]]) return false;
            return this.dfs(word, index+1, node.children[word[index]]);
        }
    }
}

let wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
console.log(wordDictionary.searchWord("pad"));
console.log(wordDictionary.searchWord("bad"));
console.log(wordDictionary.searchWord(".ad")); 
console.log(wordDictionary.searchWord("b.."));  