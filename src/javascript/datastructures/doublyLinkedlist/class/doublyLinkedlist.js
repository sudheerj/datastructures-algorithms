class DoublyLinkedList {

    constructor(value) {
        const newNode = new Node(value);
        this.head = newNode;
        this.tail = this.head;
        this.length = 1;
    }

    push(value) {
        const newNode = new Node(value);
        if(!this.head) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
        this.length++;
        return this;
    }

    pop() {
        if (this.length === 0) return undefined;
        let temp = this.tail;
        if (this.length === 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
            temp.prev = null;
        }
        this.length--;
        return temp;
    }
    
    unshift(value) {
        const newNode = new Node(value);
        if(this.length === 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        this.length++;
        return this;
    }

    shift() {
        if(this.length === 0) return undefined;
        const temp = this.head;
        if(this.length === 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = temp.next;
            temp.next = null;
            this.head.prev = null;
        }
        this.length--;
        return temp;
    }

    get(index) {
        if(index < 0 || index > this.length-1) return undefined;
        let temp = this.head;
        if(index < this.length/2) {
            for(let i=0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = this.tail;
            for(let i= this.length-1; i > index;  i--) {
               temp = temp.prev;
            }
        }
        return temp;
    }

    set(index, value) {
        const temp = this.get(index);
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
        const before = this.get(index-1);
        const after = before.next;
        
        before.next = newNode;
        newNode.next = after;
        newNode.prev  = before;
        after.prev = newNode;
        
        this.length++;
        return true;
    }

    remove(index) {
        if(index < 0 || index >= this.length) return undefined;
        if(index === 0) return this.shift();
        if(index === this.length-1) return this.pop();
        
        const temp = this.get(index);
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        
        temp.next = null;
        temp.prev = null;
        this.length--;
        
        return temp;
    }

    reverse() {
        if(this.length <=1) return;
        let current = this.head;
        let temp = null;
        
        while(current !== null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        
        temp = this.head;
        this.head = this.tail;
        this.tail = temp;   
    }

}

const myDoublyLinkedList = new DoublyLinkedList(1);
myDoublyLinkedList.push(2);
myDoublyLinkedList.push(3);
myDoublyLinkedList.push(4);

myDoublyLinkedList.pop(); //4
myDoublyLinkedList.pop(); //3

myDoublyLinkedList.unshift(0);
myDoublyLinkedList.unshift(-1);

myDoublyLinkedList.shift(); //0
myDoublyLinkedList.shift(); //-1

myDoublyLinkedList.get(1); //2
myDoublyLinkedList.get(0); //1

myDoublyLinkedList.set(0, 100); //true
myDoublyLinkedList.set(10, 200); //false

myDoublyLinkedList.insert(0, 100); //true
myDoublyLinkedList.insert(2, 300); //true
myDoublyLinkedList.insert(-1, 50); //false

myDoublyLinkedList.remove(2); //300
myDoublyLinkedList.remove(-10); //undefined



