package java1.algorithms.queue.circularDeque;

public class CircularDeque {
    private int[] deque;
    private int front;
    private int rear;
    private int capacity;
    private int size;

    CircularDeque(int k) {
        deque = new int[capacity];
        capacity = k;
        front = 0;
        rear = -1;
        size = 0;
    }

    private boolean insertFront(int value) {
        if(isFull()) return false;

        front = (front-1+capacity)%capacity;
        deque[front] = value;

        if(size == 0) {
            rear = front;
        }

        size++;
        return true;
    }

    private boolean insertLast(int value) {
        if(isFull()) return false;

        rear = (rear + 1)%capacity;
        deque[rear] = value;

        if(size == 0) {
            front = rear;
        }

        size++;
        return true;
    }

    private boolean deleteFirst() {
        if(isEmpty()) return false;

        front = (front+1)%capacity;

        size--;
        return true;
    }

    private boolean deleteLast() {
        if(isEmpty()) return false;

        rear = (rear - 1 + capacity)%capacity;

        size--;
        return true;
    }

    private int getFront(){
        if(isEmpty()) return -1;

        return deque[front];
    }

    private int getRear() {
        if(isEmpty()) return -1;

        return deque[rear];
    }

    private boolean isFull() {
        return size == capacity;
    }

    private boolean isEmpty() {
        return size == 0;
    }

}
