/**
 * Node class for singly linked list.
 */
class Node {
  /**
   * @param {*} value
   */
  constructor(value) {
    this.value = value;
    this.next = null;
  }
}

/**
 * Singly Linked List implementation.
 */
class LinkedList {
  constructor() {
    this.head = null;
    this.tail = null;
    this.length = 0;
  }

  /**
   * Adds a new node with the given value at the end of the list.
   * @param {*} value
   * @returns {LinkedList}
   */
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

  /**
   * Removes the last node from the list and returns it.
   * @returns {Node|undefined}
   */
  pop() {
    if (!this.head) return undefined;
    let current = this.head;
    let newTail = this.head;
    while (current.next) {
      newTail = current;
      current = current.next;
    }
    this.tail = newTail;
    this.tail.next = null;
    this.length--;
    if (this.length === 0) {
      this.head = null;
      this.tail = null;
    }
    return current;
  }

  /**
   * Adds a new node with the given value at the start of the list.
   * @param {*} value
   * @returns {LinkedList}
   */
  unshift(value) {
    const newNode = new Node(value);
    if (!this.head) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      newNode.next = this.head;
      this.head = newNode;
    }
    this.length++;
    return this;
  }

  /**
   * Removes the first node from the list and returns it.
   * @returns {Node|undefined}
   */
  shift() {
    if (!this.head) return undefined;
    let currentHead = this.head;
    this.head = this.head.next;
    currentHead.next = null;
    this.length--;
    if (this.length === 0) {
      this.tail = null;
    }
    return currentHead;
  }

  /**
   * Returns the node at the given index.
   * @param {number} index
   * @returns {Node|undefined}
   */
  get(index) {
    if (index < 0 || index >= this.length) return undefined;
    let current = this.head;
    for (let i = 0; i < index; i++) {
      current = current.next;
    }
    return current;
  }

  /**
   * Updates the value of the node at the given index.
   * @param {number} index
   * @param {*} value
   * @returns {boolean}
   */
  set(index, value) {
    const node = this.get(index);
    if (node) {
      node.value = value;
      return true;
    }
    return false;
  }

  /**
   * Inserts a new node with the given value at the specified index.
   * @param {number} index
   * @param {*} value
   * @returns {boolean}
   */
  insert(index, value) {
    if (index < 0 || index > this.length) return false;
    if (index === 0) return !!this.unshift(value);
    if (index === this.length) return !!this.push(value);

    const newNode = new Node(value);
    const prevNode = this.get(index - 1);
    newNode.next = prevNode.next;
    prevNode.next = newNode;
    this.length++;
    return true;
  }

  /**
   * Removes the node at the specified index and returns it.
   * @param {number} index
   * @returns {Node|undefined}
   */
  remove(index) {
    if (index < 0 || index >= this.length) return undefined;
    if (index === 0) return this.shift();
    if (index === this.length - 1) return this.pop();

    const prevNode = this.get(index - 1);
    const removedNode = prevNode.next;
    prevNode.next = removedNode.next;
    removedNode.next = null;
    this.length--;
    return removedNode;
  }

  /**
   * Reverses the linked list in place.
   * @returns {LinkedList}
   */
  reverse() {
    if(this.length === 0) return undefined;

    let temp = this.head;
    this.head = this.tail;
    this.tail = temp;
    let next = temp.next;
    let prev = null;
    for (let i = 0; i < this.length; i++) {
      next = temp.next;
      temp.next = prev;
      prev = temp;
      temp = next;
    }
    return this;
  }

  /**
   * Converts the linked list to an array.
   * @returns {Array}
   */
  toArray() {
    const arr = [];
    let current = this.head;
    while (current) {
      arr.push(current.value);
      current = current.next;
    }
    return arr;
  }

  /**
   * Prints the linked list as a string.
   * @returns {string}
   */
  printList() {
    return this.toArray().join(" -> ");
  }
}

// Usage example
const list = new LinkedList();
list.push(1).push(2).push(3);
console.log("List:", list.printList());

console.log("Pop:", list.pop());
console.log("Pop:", list.pop());
console.log("After pop:", list.printList());

list.unshift(2);
list.unshift(3);
console.log("After unshift:", list.printList());

console.log(list.shift());
console.log("After shift:", list.printList());

console.log(list.get(1));
console.log(list.get(0));

console.log(list.set(0, 1));
console.log(list.set(1, 3));
console.log("After set:", list.printList());

list.insert(1, 2);
list.insert(3, 4);
console.log("After insert:", list.printList());

console.log(list.remove(3));
console.log(list.remove(2));
console.log("After Remove:", list.printList());

list.reverse();
console.log("After reverse:", list.printList());
list.reverse();
console.log("After reverse:", list.printList());
