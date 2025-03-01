class Stack {
    private int maxSize = 10;
    private int top = -1;
    private int st[] = new int[maxSize];

    public void push(int val) {
        if (this.top == maxSize - 1)
            return;
        this.top++;
        st[top] = val;
    }

    public int pop() {
        if (this.top == -1) {
            return -1;
        }
        int popped = st[this.top--];
        return popped;
    }

    public int peek() {
        if (this.top == -1) {
            return -1;
        }
        return st[this.top];
    }

    public void display() {
        if (this.top == -1) {
            return;
        }
        for (int i = 0; i <= this.top; i++) {
            System.out.print(st[i] + " ");
        }
        System.out.println();

    }
}

public class StackDemo {
    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(10);
        st.push(20);
        st.push(30);
        st.display();
        st.pop();
        st.display();
    }
}