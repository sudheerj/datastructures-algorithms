package java1.algorithms.design.lfuCache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

// TC: get, put -> O(1) SC: O(n)
public class LFUCache {
    static class Node {
        int key, value;
        int frequency;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
        }
    }

    private Map<Integer, Node> keyToNode;
    private Map<Integer, LinkedHashSet<Node>> freqToNode;

    private final int capacity;
    private int minFrequency;


    LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFrequency = 1;
        this.keyToNode = new HashMap<>();
        this.freqToNode = new HashMap<>();
    }

    public int get(int key) {
        if(!keyToNode.containsKey(key)) return -1;

        Node node = keyToNode.get(key);
        increaseFrequency(node);

        return node.value;
    }

    public void put(int key, int value) {
        if(capacity == 0) return;

        if(keyToNode.containsKey(key)) {
            Node node = keyToNode.get(key);
            node.value = value;
            increaseFrequency(node);
            return;
        }

        if(keyToNode.size() == capacity) {
            evictLFU();
        }

        Node newNode = new Node(key, value);
        keyToNode.put(key, newNode);

        freqToNode.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(newNode);
        minFrequency = 1;
    }

    public void evictLFU() {
        LinkedHashSet<Node> nodes = freqToNode.get(minFrequency);
        Node lfuNode = nodes.iterator().next();

        nodes.remove(lfuNode);

        if(nodes.size() == 0) {
            freqToNode.remove(minFrequency);
        }

        keyToNode.remove(lfuNode.key);
    }

    public void increaseFrequency(Node node) {
        int oldFreq = node.frequency;
        LinkedHashSet<Node> oldFreqNodes = freqToNode.get(oldFreq);
        oldFreqNodes.remove(node);

        if(oldFreq == minFrequency && oldFreqNodes.isEmpty()) {
            minFrequency++;
        }

        node.frequency++;

        freqToNode.computeIfAbsent(node.frequency, k -> new LinkedHashSet<>()).add(node);
    }

    public static void main(String[] args) {
        // Test 1: Basic LFU behavior
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        int r1 = cache.get(1); // 1
        cache.put(3, 3);       // evicts key 2
        int r2 = cache.get(2); // -1
        int r3 = cache.get(3); // 3
        cache.put(4, 4);       // evicts key 1
        int r4 = cache.get(1); // -1
        int r5 = cache.get(3); // 3
        int r6 = cache.get(4); // 4

        System.out.println(
            "Test 1 | " +
            ((r1 == 1 && r2 == -1 && r3 == 3 &&
            r4 == -1 && r5 == 3 && r6 == 4)
                ? "PASS" : "FAIL")
        );

        // Test 2: Update existing key (frequency increases)
        LFUCache cache2 = new LFUCache(2);
        cache2.put(1, 1);      // freq(1)=1
        cache2.put(2, 2);      // freq(2)=1

        cache2.get(1);         // freq(1)=2

        cache2.put(2, 20);     // freq(2)=2

        cache2.put(3, 3);      // both freq=2 -> evict key 1 (LRU among freq=2)

        int t2r1 = cache2.get(2); // 20
        int t2r2 = cache2.get(1); // -1
        int t2r3 = cache2.get(3); // 3

        System.out.println(
            "Test 2 | " +
            ((t2r1 == 20 && t2r2 == -1 && t2r3 == 3)
                ? "PASS" : "FAIL")
        );

        // Test 3: Capacity = 0
        LFUCache cache3 = new LFUCache(0);
        cache3.put(1, 1);

        int t3r1 = cache3.get(1);

        System.out.println(
            "Test 3 | " +
            (t3r1 == -1 ? "PASS" : "FAIL")
        );

        // Test 4: LFU tie-breaking by LRU
        LFUCache cache4 = new LFUCache(2);

        cache4.put(1, 1);
        cache4.put(2, 2);

        cache4.get(1);         // freq(1)=2
        cache4.get(2);         // freq(2)=2

        cache4.put(3, 3);      // evict key 1 (older in freq=2 bucket)

        int t4r1 = cache4.get(1); // -1
        int t4r2 = cache4.get(2); // 2
        int t4r3 = cache4.get(3); // 3

        System.out.println(
            "Test 4 | " +
            ((t4r1 == -1 && t4r2 == 2 && t4r3 == 3)
                ? "PASS" : "FAIL")
        );
    }
}
