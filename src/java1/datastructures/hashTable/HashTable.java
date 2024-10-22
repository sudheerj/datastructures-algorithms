package java1.datastructures.hashTable;

import java.util.ArrayList;
import java.util.List;

class Node {
    String key;
    int value;
    Node next;

    Node(String key, int value){
        this.key = key;
        this.value = value;
    }
}

public class HashTable {
    private int size = 7;
    private Node[] dataMap;

    HashTable(){
        this.dataMap = new Node[size];
    }

    private int hash(String key){
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (char ch : keyChars) {
            int asciiValue = ch;
            hash = (hash + asciiValue * 23) % this.dataMap.length; 
        } 
        return hash;
    }

    public void set(String key, int value){
        int index = this.hash(key);
        Node newNode = new Node(key, value);
        if(this.dataMap[index] == null) {
            this.dataMap[index] = newNode;
        } else {
            Node temp = this.dataMap[index];
            if(temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public int get(String key) {
        int index = this.hash(key);
        Node temp = this.dataMap[index];
        while(temp != null) {
            if(temp.key == key) return temp.value;
            temp = temp.next;
        }
        return 0;
    }

    public List<String> keys(){
        List<String> keys = new ArrayList<>();
        for (int i = 0; i < this.dataMap.length; i++) {
            Node temp = this.dataMap[i];
            while(temp != null){
                keys.add(temp.key);
                temp = temp.next;
            }
        }
        return keys;
    }

    public void printHashTable() {
        for (int i = 0; i < this.dataMap.length; i++) {
            System.out.println(i + ": ");
            Node temp = this.dataMap[i];
            while(temp != null){
                System.out.println(" {" + temp.key +" - "+ temp.value + " }");
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args) {
        HashTable myHashTable = new HashTable();

        myHashTable.set("bolts", 70);
        myHashTable.set("nails", 120);
        myHashTable.set("paint", 40);
        myHashTable.set("tile", 60);
        myHashTable.set("lumber", 90);

        System.out.println(myHashTable.keys());
        myHashTable.printHashTable();
    }

}
