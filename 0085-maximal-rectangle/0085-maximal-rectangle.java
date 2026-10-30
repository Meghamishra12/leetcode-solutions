class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        if (n == 0) return 0;
        int[] heights = new int[n];
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') heights[j]++;
                else heights[j] = 0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        nse[n-1] = n;
        Stack<Integer> st = new Stack<>();
        st.push(n-1);
        for (int i = n-2; i >= 0; i--) {
            while (st.size() > 0 && arr[st.peek()] >= arr[i]) st.pop();
            if (st.size() == 0) nse[i] = n;
            else nse[i] = st.peek();
            st.push(i);
        }
        while (st.size() > 0) st.pop();

        int[] pse = new int[n];
        pse[0] = -1;
        st.push(0);
        for (int i = 1; i < n; i++) {
            while (st.size() > 0 && arr[st.peek()] >= arr[i]) st.pop();
            if (st.size() == 0) pse[i] = -1;
            else pse[i] = st.peek();
            st.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int area = arr[i] * (nse[i] - pse[i] - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}