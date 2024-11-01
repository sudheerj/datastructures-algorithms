class Node {
    constructor(key, value){
        this.key = key;
        this.value = value;
        this.head = null;
        this.tail = null;
    }
}

class LRUCache {
    constructor(capacity){
        this.capacity = capacity;
        this.cache = new Map();
        this.head = new Node(null, null);
        this.tail = new Node(null, null);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    get(key){
        if(this.cache.has(key)) {
            const node = this.cache.get(key);
            this._remove(node);
            this._insert(node);
            return node.value;
        }

        return -1;
    }

    put(key, value) {
        if(this.cache.has(key)) {
            this._remove(this.cache.get(key));
        }

        const node = new Node(key, value);
        this._insert(node);
        this.cache.set(key, node);

        if(this.cache.size > this.capacity){
            const lruNode = this.tail.prev;
            this._remove(lruNode);
            this.cache.delete(lruNode.key);
        }
    }

    _remove(node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    _insert(node) {
        node.next = this.head.next;
        node.prev = this.head;
        this.head.next.prev = node;
        this.head.next = node;
    }
}

let lruCache = new LRUCache(2);
lruCache.put(1, 5);
console.log(lruCache.get(1));
lruCache.put(2, 10);
lruCache.put(3, 15);
console.log(lruCache.get(2));
lruCache.put(4, 20);
console.log(lruCache.get(1));