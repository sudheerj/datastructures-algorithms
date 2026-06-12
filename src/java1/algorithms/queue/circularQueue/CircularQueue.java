package java1.algorithms.queue.circularQueue;

public class CircularQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int capacity;
    private int size;

    CircularQueue(int k) {
        queue = new int[k];
        capacity = k;
        front = 0;
        rear = -1;
        size = 0;
    }

    private boolean enQueue(int value) {
        if(isFull()) return false;

        rear = (rear + 1) % capacity;
        queue[rear] = value;

        size++;
        return true;
    }

    private boolean deQueue() {
        if(isEmpty()) return false;

        front = (front + 1)%capacity;

        size--;
        return true;
    }

    private int Front() {
        return isEmpty() ? -1 : queue[front];
    }

    private int Rear() {
        return isEmpty() ? -1 : queue[rear];
    }

    private boolean isFull() {
        return size == capacity;
    }

    private boolean isEmpty() {
        return size == 0;
    }
}
