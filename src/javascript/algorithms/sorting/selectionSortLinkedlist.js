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
    
    selectionSort() {
        if(this.length < 2) return;
        
        let current = this.head;
        while(current.next !== null) {
            let smallest = current;
            let nestedCurrent = current.next;
            while(nestedCurrent !== null) {
                if(nestedCurrent.value < smallest.value) {
                    smallest = nestedCurrent;
                }
                nestedCurrent = nestedCurrent.next;
            }
            if(smallest !== current) {
                let temp = current.value;
                current.value = smallest.value;
                smallest.value = temp;
            }
            current = current.next;
        }
        this.tail = current;
    }
	
}

const myLinkedList = new LinkedList(5);
myLinkedList.push(3);
myLinkedList.push(2);
myLinkedList.push(1);
myLinkedList.push(3);
myLinkedList.push(-9);
myLinkedList.selectionSort();
myLinkedList.printList();