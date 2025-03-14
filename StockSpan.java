class StockSpanner {
    int ind = -1;
    Stack<int[]> st = new Stack<>();

    public StockSpanner() {
        st.clear();
        ind = -1;
    }

    public int next(int price) {
        ind += 1;
        while (!st.isEmpty() && st.peek()[0] <= price) {
            st.pop();
        }
        int pge = st.isEmpty() ? -1 : st.peek()[1];
        int cnt = ind - pge;
        st.push(new int[] { price, ind });
        return cnt;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */