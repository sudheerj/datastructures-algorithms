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

    let firstTemp = new Node(0);
    let secondTemp = new Node(0);
    let firstHead = firstTemp;
    let secondHead = secondTemp;

    let current = this.head;
    while (current !== null) {
      if (current.value < x) {
        firstTemp.next = current;
        firstTemp = current;
      } else {
        secondTemp.next = current;
        secondTemp = current;
      }
      current = current.next;
    }
    firstTemp.next = secondHead.next;
    secondTemp.next = null;
    this.head = firstHead.next;
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

const myLinkedList = new LinkedList();
myLinkedList.push(7);
myLinkedList.push(3);
myLinkedList.push(6);
myLinkedList.push(3);
myLinkedList.push(5);
myLinkedList.push(4);
myLinkedList.push(8);

myLinkedList.partitionList(5);
myLinkedList.printList();
