package java1.algorithms.design.hashMap;

import java.util.Arrays;

//Bounded array(or direct addressing) Insert, update and Remove O(1)
public class MyHashMap {
    int[] map;

    MyHashMap() {
        map = new int[1000001];
        Arrays.fill(map, -1);
    }

    public void put(int key, int value) {
        map[key] = value;
    }

    public int get(int key) {
        return map[key];
    }

    public void remove(int key) {
        map[key] = -1;
    }
    // Inline test harness for MyHashMap (Direct Addressing)
    public static void main(String[] args) {
        System.out.println("Testing MyHashMap (Direct Addressing):");
        MyHashMap map = new MyHashMap();
        map.put(1, 1);
        map.put(2, 2);
        System.out.println((map.get(1) == 1 ? "PASS" : "FAIL") + " get(1) == 1");
        System.out.println((map.get(3) == -1 ? "PASS" : "FAIL") + " get(3) == -1");
        map.put(2, 1);
        System.out.println((map.get(2) == 1 ? "PASS" : "FAIL") + " get(2) == 1");
        map.remove(2);
        System.out.println((map.get(2) == -1 ? "PASS" : "FAIL") + " get(2) == -1");

        System.out.println("\nTesting MyHashMap1 (Chaining):");
        MyHashMap1 map1 = new MyHashMap1();
        map1.put(1, 1);
        map1.put(2, 2);
        System.out.println((map1.get(1) == 1 ? "PASS" : "FAIL") + " get(1) == 1");
        System.out.println((map1.get(3) == -1 ? "PASS" : "FAIL") + " get(3) == -1");
        map1.put(2, 1);
        System.out.println((map1.get(2) == 1 ? "PASS" : "FAIL") + " get(2) == 1");
        map1.remove(2);
        System.out.println((map1.get(2) == -1 ? "PASS" : "FAIL") + " get(2) == -1");
    }
}

//Chaining with linkedlist insert, update and remove:- O(1)
class MyHashMap1 {
    class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[] buckets = new Node[10000];

    private int hash(int key) {
        return key % buckets.length;
    }
    public int get(int key) {
        int idx = hash(key);

        Node curr = buckets[idx];

        while(curr != null) {
            if(curr.key == key) return curr.value;
            curr = curr.next;
        }

        return -1;
    }

    public void put(int key, int value) {
        int idx = hash(key);

        if(buckets[idx] == null) {
            buckets[idx] = new Node(key, value);
            return;
        }

        Node curr = buckets[idx];

        while(curr != null) {
            //update existing node
            if(curr.key == key) {
                curr.value = value;
                return;
            }

            //Insert at end
            if(curr.next == null) {
                curr.next = new Node(key, value);
                break;
            }

            curr = curr.next;
        }
    }

    public void remove(int key) {
        int idx = hash(key);

        Node curr = buckets[idx];
        Node prev = null;

        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }

        if(curr == null) return;

        //deleting head
        if(prev == null) {
            buckets[idx] = curr.next;
        } else {
            prev.next = curr.next;
        }
    }
}
