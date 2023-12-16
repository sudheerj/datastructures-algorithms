class Node {
    constructor(value){
        this.value = value;
        this.next = null;
    }
}
 
class LinkedList {
    constructor(value) {
        const newNode = new Node(value);
        this.head = newNode;
        this.tail = this.head;
        this.length = 1;
    }

    printList() {
        let temp = this.head;
        let output = "";
        if (temp === null) {
            console.log("empty");
            return;
        }
        while (temp !== null) {
            output += String(temp.value);
            temp = temp.next;
            if (temp !== null) {
                output += " -> ";
            }
        }
        console.log(output);
    }

    push(value) {
        const newNode = new Node(value);
        if (!this.head) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.length++;
        return this;
    }
    
    merge(secondList) {
        let secondListHead = secondList.head;
        const dummy = new Node(0);
        let current = dummy;
        while(this.head !== null && secondListHead !== null) {
            if(this.head.value < secondListHead.value) {
                current.next = this.head;
                this.head = this.head.next;
            } else {
                current.next = secondListHead;
                secondListHead = secondListHead.next;
            }
            current = current.next;
        }
        if(this.head !== null) {
            current.next = this.head;
        } else {
            current.next = secondListHead;
            this.tail = secondList.tail;
        }
        this.head = dummy.next;
        this.length += secondList.length;
    }
	
}

const list1 = new LinkedList(3);
list1.push(5);
list1.push(5);
list1.push(6);
const list2 = new LinkedList(1);
list2.push(2);
list2.push(4);
list2.push(7);
console.log("Merging two sorted lists:");
list1.printList();
list2.printList();
list1.merge(list2);
list1.printList();
