class Node {
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}

class LinkedList {
    constructor(value) {
        const newNode = new Node(value);
        this.head = newNode;
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }

    push(value) {
        const newNode = new Node(value);
        if(!this.head) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.length++;
        return this;
    }

    reverseBetween(m, n) {
        if (this.head === null) return;
 
        const dummy = new Node(0);
        dummy.next = this.head;
        let prev = dummy;
 
        for (let i = 0; i < m; i++) {
            prev = prev.next;
        }
 
        let current = prev.next;
        for (let i = 0; i < n - m; i++) {
            const temp = current.next;
            current.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }
 
        this.head = dummy.next;
    }

    reverseBetweenUsingReverseList(m, n) {
        if(!this.head) return;
        
        let current = this.head;
        let revPrev = null;
        let revBegin = null;
        let revEnd = null;
        let revEndNext = null;
        let i = 0;
        
        while(current && i <= n) {
            if(i < m) {
                revPrev = current;
            }
            if(i === m) {
                revBegin = current;
            }
            if(i === n) {
                revEnd = current;
                revEndNext = current.next;
            }
            current = current.next;
            i++;
        }
        revEnd.next = null;
        
        revEnd = this.reverse(revBegin);
        
        if(revPrev) {
            revPrev.next = revEnd;
        } else {
            this.head = revEnd;
        }
        revBegin.next = revEndNext;
        return this.head;
    }
    
    reverse(head) {
        let current = head;
        let prev = null;
        while(current){
            let next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

}

const myLinkedList = new LinkedList(1);
myLinkedList.push(2);
myLinkedList.push(3);
myLinkedList.push(4);
myLinkedList.push(5);

myLinkedList.reverseBetween(2, 4);
myLinkedList.reverseBetweenUsingReverseList(1, 3);

