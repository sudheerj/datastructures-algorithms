class Node {
    constructor(value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {

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
        if(index === 0) return !!this.unshift(value);
        if(index === this.length) return !!this.push(value);
        
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
        let prev = null;
        
        while(current !== null) {
            prev = current.prev;
            current.prev = current.next;
            current.next = prev;
            current = current.prev;
        }
        
        prev = this.head;
        this.head = this.tail;
        this.tail = prev;  
        
        return this;
    }

}

const myDoublyLinkedList = new DoublyLinkedList();
console.dir(myDoublyLinkedList.push(1),{depth: null});
console.dir(myDoublyLinkedList.push(2),{depth: null});
console.dir(myDoublyLinkedList.push(3),{depth: null});
console.dir(myDoublyLinkedList.push(4),{depth: null});

console.dir(myDoublyLinkedList.pop(),{depth: null}); 
console.dir(myDoublyLinkedList.pop(),{depth: null}); 

console.dir(myDoublyLinkedList.unshift(0),{depth: null});
console.dir(myDoublyLinkedList.unshift(-1),{depth: null});

console.dir(myDoublyLinkedList.shift(),{depth: null}); 
console.dir(myDoublyLinkedList.shift(),{depth: null});

console.dir(myDoublyLinkedList.get(1),{depth: null});
console.dir(myDoublyLinkedList.get(0),{depth: null}); 

console.dir(myDoublyLinkedList.set(0, 100),{depth: null});
console.dir(myDoublyLinkedList.set(10, 200),{depth: null});

console.dir(myDoublyLinkedList.insert(0, 100),{depth: null});
console.dir(myDoublyLinkedList.insert(2, 300),{depth: null});
console.dir(myDoublyLinkedList.insert(-1, 50),{depth: null});

console.dir(myDoublyLinkedList.remove(2),{depth: null});
console.dir(myDoublyLinkedList.remove(-10),{depth: null});

console.dir(myDoublyLinkedList.reverse(),{depth: null});
console.dir(myDoublyLinkedList.reverse(),{depth: null});



