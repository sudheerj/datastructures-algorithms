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
    if (!word) return;
    let curr = this.root;
    for (let ch of word) {
      if (!(ch in curr.children)) {
        curr.children[ch] = new Node();
      }
      curr = curr.children[ch];
    }
    curr.isEndOfWord = true;
  }

  //TC: O(n) SC: O(1)
  search(word) {
    if (!word) return false;
    let curr = this.root;
    for (let ch of word) {
      if (!(ch in curr.children)) {
        return false;
      }
      curr = curr.children[ch];
    }
    return curr.isEndOfWord;
  }

  //TC: O(n) SC: O(1)
  startsWith(prefix) {
    if (!prefix) return false;
    let curr = this.root;
    for (let ch of prefix) {
      if (!(ch in curr.children)) {
        return false;
      }
      curr = curr.children[ch];
    }
    return true;
  }

  //TC: O(n) SC: O(n)
  delete(word) {
    if (!word) return;
    function deleteHelper(node, word, depth) {
      if (!node) return false;
      if (depth === word.length) {
        if (!node.isEndOfWord) return false;
        node.isEndOfWord = false;
        return Object.keys(node.children).length === 0;
      }
      let ch = word[depth];
      if (!(ch in node.children)) return false;
      let shouldDelete = deleteHelper(node.children[ch], word, depth + 1);
      if (shouldDelete) {
        delete node.children[ch];
        return Object.keys(node.children).length === 0 && !node.isEndOfWord;
      }
      return false;
    }
    deleteHelper(this.root, word, 0);
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
trie.delete("word");
console.log(trie.search("word")); // false
