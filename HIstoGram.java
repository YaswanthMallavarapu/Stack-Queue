class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = Integer.MIN_VALUE;
        // for(int i=0;i<n;i++){
        // int min=heights[i];
        // for(int j=i;j<n;j++){
        // if(heights[j]<min)min=heights[j];
        // int area=min*(j-i+1);
        // maxArea=Math.max(maxArea,area);
        // }
        // }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                int right = i;
                int element = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                int area = heights[element] * (right - left - 1);
                maxArea = Math.max(area, maxArea);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int right = n;
            int element = stack.pop();
            int left = stack.isEmpty() ? -1 : stack.peek();
            int area = heights[element] * (right - left - 1);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}