import java.util.*;

class Solution {
    int k;
    HashMap<Long, Integer> memo = new HashMap<>();

    public int waysToReachStair(int k) {
        this.k = k;
        return solve(1, 0, 1);
    }

    private int solve(long i, int jump, int canDown) {
        if (i > (long) k + 1) return 0;

        long key = ((i * 32) + jump) * 2 + canDown;
        if (memo.containsKey(key)) return memo.get(key);

        int res = (i == k) ? 1 : 0;                       // reached k, count it and keep going
        if (canDown == 1 && i > 0)
            res += solve(i - 1, jump, 0);                 // down: next move can't be down
        res += solve(i + (1L << jump), jump + 1, 1);      // up: jump grows, down allowed again

        memo.put(key, res);
        return res;
    }
}