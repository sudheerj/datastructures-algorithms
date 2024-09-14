class Node {
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}

class LinkedList {
    constructor() {
        this.head = null;
        this.tail = null;
        this.length = 0;
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

    reverseBetween1(left, right) {
        if(!this.head || this.head.next !== null || left === right) return this.head;

        let dummy = new Node(0);
        dummy.next = this.head;

        let leftPrev = dummy;
        let current = this.head;

        for (let i = 0; i < left-1; i++) {
           leftPrev = current;
           current = current.next;
        }

        let prev = null;
        for (let i = 0; i < right-left+1; i++) {
            let temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        leftPrev.next.next = current;
        leftPrev.next = prev;

        this.head = dummy.next;

        return this.head;
    }

    reverseBetween2(left, right) {
        if (this.head === null) return;
 
        const dummy = new Node(0);
        dummy.next = this.head;
        let prev = dummy;
 
        for (let i = 0; i < left-1; i++) {
            prev = prev.next;
        }
 
        let current = prev.next;
        for (let i = 0; i < right - left; i++) {
            const temp = current.next;
            current.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }
 
        this.head = dummy.next;

        return this.head;
    }

    //UsingReverseList
    reverseBetween3(left, right) {
        if(!this.head) return;
        
        let current = this.head;
        let revPrev = null;
        let revBegin = null;
        let revEnd = null;
        let revEndNext = null;
        let i = 0;
        
        while(current && i <= right) {
            if(i < left) {
                revPrev = current;
            }
            if(i === left) {
                revBegin = current;
            }
            if(i === right) {
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

const myLinkedList = new LinkedList();
myLinkedList.push(1);
myLinkedList.push(2);
myLinkedList.push(3);
myLinkedList.push(4);
myLinkedList.push(5);
myLinkedList.push(6);

const myLinkedList1 = new LinkedList();
myLinkedList1.push(4);

console.dir(myLinkedList.reverseBetween1(2, 5), {depth: null});
console.dir(myLinkedList.reverseBetween2(2, 5), {depth: null});
console.dir(myLinkedList.reverseBetween3(1, 3), {depth: null});
console.dir(myLinkedList1.reverseBetween1(1, 1));

