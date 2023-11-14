class Stack {
    constructor() {
        this.array = [];
    }

    isEmpty() {
        return this.array.length === 0;
    }

    peek() {
        if (this.isEmpty()) {
            return null;
        } else {
            return this.array[this.array.length - 1];
        }
    }

    push(value) {
        this.array.push(value);
    }

    pop() {
        if (this.isEmpty()) return null;
        return this.array.pop();
    }
    
}

class MyQueue {
    constructor() {
        this.stack1 = new Stack();
        this.stack2 = new Stack();
    }
    
    peek() {
        return this.stack1.peek();
    }

    isEmpty() {
        return this.stack1.isEmpty();
    }

    enqueue(value) {
        while(!this.stack1.isEmpty()) {
            this.stack2.push(this.stack1.pop());
        }
        
        this.stack2.push(value);
        
        while(!this.stack2.isEmpty()) {
            this.stack1.push(this.stack2.pop());
        }
    }

    dequeue() {
        if(this.stack1.isEmpty()) return null;
        return this.stack1.pop();
    }
}



const queue = new MyQueue();

queue.enqueue(1);
queue.enqueue(2);
queue.enqueue(3);
console.log("Top element: ", queue.peek()); // 3 

queue.dequeue(3);

console.log("Top element: ", queue.peek()); // 2