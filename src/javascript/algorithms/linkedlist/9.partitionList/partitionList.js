class Node {
  constructor(value) {
    this.value = value;
    this.next = null;
  }
}

class LinkedList {
  constructor(value) {
    this.head = null;
    this.tail = null;
    this.length = 0;
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

  partitionList(x) {
    if (!this.head) return;

    let leftDummy = new Node(0);
    let rightDummy = new Node(0);
    let leftTail = leftDummy;
    let rightTail = rightDummy;

    let current = this.head;
    while (current !== null) {
      if (current.value < x) {
        leftTail.next = current;
        leftTail = current;
      } else {
        rightTail.next = current;
        rightTail = current;
      }
      current = current.next;
    }
    leftTail.next = rightDummy.next;
    rightTail.next = null;
    this.head = leftDummy.next;
  }

  printList() {
    let current = this.head;
    let output = '';
    while(current !== null) {
        output += ''+ current.value;
        current = current.next;
        if (current !== null) output += ' --> ';
    }
    console.log(output);
  }
}

const myLinkedList1 = new LinkedList();
myLinkedList1.push(7);
myLinkedList1.push(3);
myLinkedList1.push(6);
myLinkedList1.push(3);
myLinkedList1.push(5);
myLinkedList1.push(4);
myLinkedList1.push(8);

myLinkedList1.partitionList(5);
myLinkedList1.printList();

const myLinkedList2 = new LinkedList();
myLinkedList2.push(3);
myLinkedList2.push(2);

myLinkedList2.partitionList(3);
myLinkedList2.printList();
