class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int[] dq = new int[n]; // stores indices, values decreasing
        int head = 0, tail = 0; // deque is dq[head .. tail-1]

        for (int i = 0; i < n; i++) {
            // Remove index that has fallen out of the window
            while (head < tail && dq[head] <= i - k) {
                head++;
            }

            // Remove smaller elements; they can never be the max
            while (head < tail && nums[dq[tail - 1]] < nums[i]) {
                tail--;
            }

            dq[tail++] = i;

            // Window is fully formed starting at i = k - 1
            if (i >= k - 1) {
                result[i - k + 1] = nums[dq[head]];
            }
        }
        return result;
    }
}