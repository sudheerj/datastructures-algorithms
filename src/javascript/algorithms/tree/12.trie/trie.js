class Node {
    constructor() {
        this.children = {};
        this.isEndOfWord = false;
    }
}

class Trie {
    constructor() {
        this.root = new Node();
    }

    //TC: O(n) SC: O(n)
    insert(word) {
        let curr = this.root;
        for(let ch of word) {
            if(!(ch in curr.children)) {
                curr.children[ch] = new Node();
            }
            curr = curr.children[ch];
        }
        curr.isEndOfWord = true;
    }

    //TC: O(n) SC: O(1)
    search(word) {
        let curr = this.root;
        for(let ch of word) {
            if(!(ch in curr.children)) {
                return false;
            }
            curr = curr.children[ch];
        }
        return curr.isEndOfWord;
    }

    //TC: O(n) SC: O(1)
    startsWith(prefix) {
        let curr = this.root;
        for(let ch of prefix) {
            if(!(ch in curr.children)) {
                return false;
            }
            curr = curr.children[ch];
        }
        return true;
    }
}

let trie = new Trie();
trie.insert("mango");
console.log(trie.search("mango"));
console.log(trie.search("man"));
console.log(trie.startsWith("man")); 
trie.insert("word");
trie.insert("world");
console.log(trie.search("word")); 