
class Queue {
    private int front = -1;
    private int rear = -1;
    private int maxSize = 10;
    private int[] queue = new int[maxSize];

    public void enqueue(int va) {
        if (this.rear == -1) {
            this.front = 0;
            this.rear = 0;
            queue[this.rear] = va;
        } else {
            this.rear++;
            queue[this.rear] = va;
        }
    }

    public int dequeue() {
        if (this.front == -1) {
            return -1;
        } else {
            int popped = queue[this.front];
            this.front++;
            return popped;
        }
    }

    public int top() {
        if (this.front == -1) {
            return -1;
        }
        return queue[this.front];
    }

    public void display() {
        if (this.front == -1) {
            return;
        }
        for (int i = this.front; i <= this.rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
}

public class QueueDemo {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();
        q.dequeue();
        q.display();
        Queue queue = new Queue();
        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(300);
        queue.display();
        queue.dequeue();
        queue.display();
    }
}
