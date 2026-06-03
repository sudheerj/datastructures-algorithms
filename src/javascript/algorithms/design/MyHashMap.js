// MyHashMap - Design a HashMap without built-in hash table libraries.
// LeetCode 706. Design HashMap

class MyHashMap {
    constructor() {
        this.map = new Array(1000001).fill(-1);
    }
    put(key, value) {
        this.map[key] = value;
    }
    get(key) {
        return this.map[key];
    }
    remove(key) {
        this.map[key] = -1;
    }
}

// Chaining with linked list
class MyHashMap1 {
    constructor() {
        this.buckets = new Array(10000).fill(null);
    }
    _hash(key) {
        return key % this.buckets.length;
    }
    put(key, value) {
        const idx = this._hash(key);
        if (!this.buckets[idx]) {
            this.buckets[idx] = { key, value, next: null };
            return;
        }
        let curr = this.buckets[idx];
        while (curr) {
            if (curr.key === key) {
                curr.value = value;
                return;
            }
            if (!curr.next) {
                curr.next = { key, value, next: null };
                return;
            }
            curr = curr.next;
        }
    }
    get(key) {
        const idx = this._hash(key);
        let curr = this.buckets[idx];
        while (curr) {
            if (curr.key === key) return curr.value;
            curr = curr.next;
        }
        return -1;
    }
    remove(key) {
        const idx = this._hash(key);
        let curr = this.buckets[idx], prev = null;
        while (curr && curr.key !== key) {
            prev = curr;
            curr = curr.next;
        }
        if (!curr) return;
        if (!prev) this.buckets[idx] = curr.next;
        else prev.next = curr.next;
    }
}

// Test harness
function testMyHashMap() {
    console.log("Testing MyHashMap (Direct Addressing):");
    const map = new MyHashMap();
    map.put(1, 1);
    map.put(2, 2);
    console.log((map.get(1) === 1 ? "PASS" : "FAIL"), "get(1) == 1");
    console.log((map.get(3) === -1 ? "PASS" : "FAIL"), "get(3) == -1");
    map.put(2, 1);
    console.log((map.get(2) === 1 ? "PASS" : "FAIL"), "get(2) == 1");
    map.remove(2);
    console.log((map.get(2) === -1 ? "PASS" : "FAIL"), "get(2) == -1");

    console.log("\nTesting MyHashMap1 (Chaining):");
    const map1 = new MyHashMap1();
    map1.put(1, 1);
    map1.put(2, 2);
    console.log((map1.get(1) === 1 ? "PASS" : "FAIL"), "get(1) == 1");
    console.log((map1.get(3) === -1 ? "PASS" : "FAIL"), "get(3) == -1");
    map1.put(2, 1);
    console.log((map1.get(2) === 1 ? "PASS" : "FAIL"), "get(2) == 1");
    map1.remove(2);
    console.log((map1.get(2) === -1 ? "PASS" : "FAIL"), "get(2) == -1");
}

testMyHashMap();
