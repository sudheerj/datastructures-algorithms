class Queue
{
    constructor()
    {
        this.items = []; // Array is used to implement a Queue
    }

    // List of main functions of queue data structure

    enqueue(item) {
        this.items.push(item); // adds an item to the queue
    }

    dequeue() {
        // Underflow if queue is empty
        if(this.isEmpty()) {
            return "Underflow";
        }

        return this.items.shift(); // Removes an item from the front of a queue and return the removed item
    }

    front() {
        if(this.isEmpty())
            return "No elements in Queue";
        return this.items[0]; // returns the front item of the queue without removing it.
    }

    // List of helper functions

    isEmpty() {
        return this.items.length === 0; // return true if the queue is empty.
    }

    printQueue() {
        let data = "";
        for(let i = 0; i < this.items.length; i++)
            data += this.items[i] +" ";
        return data;
    }

}

function useQueue() {
    let queue = new Queue();

    console.log(queue.isEmpty()); // false
    console.log(queue.dequeue()); // Underflow

    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);

    console.log(queue.printQueue()); // 1 2 3
    console.log(queue.front()); // 1

    console.log(queue.dequeue()); // 1

    console.log(queue.printQueue()); // 2 3
}

useQueue();
