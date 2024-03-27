class Node {
    constructor() {
        this.children = {};
        this.isEnd = false;
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
        curr.isEnd = true;
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
        return curr.isEnd;
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
trie.insert("apple");
console.log(trie.search("apple"));
console.log(trie.search("app"));
console.log(trie.startsWith("app")); 
trie.insert("app");
console.log(trie.search("app")); 