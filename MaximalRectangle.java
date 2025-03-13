class Solution {
    public static int histogram(int heights[]) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                int nse = i;
                int element = st.pop();
                int pse = st.isEmpty() ? -1 : st.peek();
                maxArea = Math.max(maxArea, (heights[element] * (nse - pse - 1)));
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            int nse = n;
            int element = st.pop();
            int pse = st.isEmpty() ? -1 : st.peek();
            maxArea = Math.max(maxArea, (heights[element] * (nse - pse - 1)));
        }
        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int maxArea = Integer.MIN_VALUE;
        int heights[] = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, histogram(heights));
        }
        return maxArea;
    }
}