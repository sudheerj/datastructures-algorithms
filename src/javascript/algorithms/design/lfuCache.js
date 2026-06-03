class LFUNode {
    constructor(key, value) {
        this.key = key;
        this.value = value;
        this.freq = 1;
    }
}
class LFUCache {
    constructor(capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyToNode = new Map();
        this.freqToNodes = new Map();
    }
    get(key) {
        if (!this.keyToNode.has(key)) return -1;
        const node = this.keyToNode.get(key);
        this._increaseFreq(node);
        return node.value;
    }
    put(key, value) {
        if (this.capacity === 0) return;
        if (this.keyToNode.has(key)) {
            const node = this.keyToNode.get(key);
            node.value = value;
            this._increaseFreq(node);
            return;
        }
        if (this.keyToNode.size === this.capacity) {
            this._evict();
        }
        const node = new LFUNode(key, value);
        this.keyToNode.set(key, node);
        if (!this.freqToNodes.has(1)) this.freqToNodes.set(1, []);
        this.freqToNodes.get(1).push(node);
        this.minFreq = 1;
    }
    _evict() {
        const nodes = this.freqToNodes.get(this.minFreq);
        const evictNode = nodes.shift();
        if (nodes.length === 0) this.freqToNodes.delete(this.minFreq);
        this.keyToNode.delete(evictNode.key);
    }
    _increaseFreq(node) {
        const freq = node.freq;
        const nodes = this.freqToNodes.get(freq);
        nodes.splice(nodes.indexOf(node), 1);
        if (nodes.length === 0) {
            this.freqToNodes.delete(freq);
            if (this.minFreq === freq) this.minFreq++;
        }
        node.freq++;
        if (!this.freqToNodes.has(node.freq)) this.freqToNodes.set(node.freq, []);
        this.freqToNodes.get(node.freq).push(node);
    }
}
// Test 1
const cache = new LFUCache(2);
cache.put(1, 1);
cache.put(2, 2);
const r1 = cache.get(1);
cache.put(3, 3);
const r2 = cache.get(2);
const r3 = cache.get(3);
cache.put(4, 4);
const r4 = cache.get(1);
const r5 = cache.get(3);
const r6 = cache.get(4);
console.log("Test 1 |", (r1===1 && r2===-1 && r3===3 && r4===-1 && r5===3 && r6===4) ? "PASS" : "FAIL");
// Test 2
const cache2 = new LFUCache(2);
cache2.put(1, 1);
cache2.put(2, 2);
cache2.get(1);
cache2.put(2, 20);
cache2.put(3, 3);
const t2r1 = cache2.get(2);
const t2r2 = cache2.get(1);
const t2r3 = cache2.get(3);
console.log("Test 2 |", (t2r1===-1 && t2r2===1 && t2r3===3) ? "PASS" : "FAIL");
// Test 3
const cache3 = new LFUCache(0);
cache3.put(1, 1);
const t3r1 = cache3.get(1);
console.log("Test 3 |", t3r1===-1 ? "PASS" : "FAIL");
