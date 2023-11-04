class LinkedList {
    constructor(value) {
        const newNode = new Node(value);
        this.head = newNode;
        this.tail = this.head;
        this.length = 1;
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

    pop() {
        if (this.length === 0) return undefined;
        let temp = this.head;
        let prev = this.head;
        while(temp.next) {
            prev = temp;
            temp = temp.next;
        }
        this.tail = prev;
        this.tail.next = null;
        this.length--;
        if(this.length === 0) {
            this.head = null;
            this.tail = null;
        }
        return temp;
    }

    unshift(value) {
        const newNode = new Node(value);
        if(!this.head) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
        this.length++;
        return this;
    }

    shift() {
        if(!this.head) return undefined;
        let temp = this.head;
        this.head = this.head.next;
        temp.next = null;
        this.length--;
        if(this.length === 0) {
            this.tail = null;
        }
        return temp;
    }

    get(index) {
        if(index < 0 || index >= this.length) return undefined;
        let temp = this.head;
        for(let i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    set(index, value) {
        let temp = this.get(index);
        if(temp) {
            temp.value = value;
            return true;
        }
        return false;
    }

    insert(index, value) {
        if(index < 0 || index > this.length) return false;
        if(index === 0) return this.unshift(value);
        if(index === this.length) return this.push(value);

        const newNode = new Node(value);
        const temp = this.get(index-1);
        newNode.next = temp.next;
        temp.next = newNode;
        this.length++;
        return true;
    }

    remove(index) {
        if(index < 0 || index > this.length) return undefined;
        if(index === 0) return this.shift();
        if(index === this.length-1) return this.pop();

        const prev = this.get(index-1);
        const temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        this.length--;
        return temp;
    }

    reverse() {
        let temp = this.head;
        this.head = this.tail;
        this.tail = temp;
        let next = temp.next;
        let prev = null;
        for(let i = 0; i < this.length; i++) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return this;
    }

}

const myLinkedList = new LinkedList(1);
myLinkedList.push(2);
myLinkedList.push(3);

myLinkedList.pop();
myLinkedList.pop();

myLinkedList.unshift(2);
myLinkedList.unshift(3);

myLinkedList.shift();

myLinkedList.get(1);
myLinkedList.get(0);

myLinkedList.set(0, 1);
myLinkedList.set(1, 3);

myLinkedList.insert(1, 2);
myLinkedList.insert(3, 4);

myLinkedList.remove(3);
myLinkedList.remove(2);

myLinkedList.reverse();
myLinkedList.reverse();
