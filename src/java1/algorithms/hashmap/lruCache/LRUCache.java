package java1.algorithms.hashmap.lruCache;

import java.util.HashMap;
import java.util.Map;

class Node {
    Integer key;
    Integer value;
    Node next;
    Node prev;

    Node(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {
    int capacity;
    Map<Integer, Node> cache;
    Node head;
    Node tail;
    
    LRUCache(int capacity){
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(null, null);
        this.tail = new Node(null, null);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key){
        if(this.cache.containsKey(key)) {
            Node node = this.cache.get(key);
            this._remove(node);
            this._insert(node);
            return node.value;
        }

        return -1;
    }

    public void set(int key, int value){
        if(this.cache.containsKey(key)) {
            this._remove(this.cache.get(key));
        }

        Node node = new Node(key, value);
        this._insert(node);
        this.cache.put(key, node);

        if(this.cache.size() > this.capacity) {
            Node lruNode = this.tail.prev;
            this._remove(lruNode);
            this.cache.remove(lruNode.key);
        }
    }

    private void _remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void _insert(Node node) {
        node.next = this.head.next;
        node.prev = this.head;
        this.head.next.prev = node;
        this.head.next = node;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.set(1, 5);
        System.out.println(lruCache.get(1));
        lruCache.set(2, 10);
        lruCache.set(3, 15);
        System.out.println(lruCache.get(2));
        lruCache.set(4, 20);
        System.out.println(lruCache.get(1));
    }
}


