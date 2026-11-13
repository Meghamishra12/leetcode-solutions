class Solution {
    public int matrixScore(int[][] arr) {
        int m = arr.length, n = arr[0].length;

        // make the first column all ones by flipping rows
        for (int i = 0; i < m; i++) {
            if (arr[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] ^= 1;
                }
            }
        }

        // flip every column where zeroes > ones
        for (int j = 1; j < n; j++) {
            int ones = 0;
            for (int i = 0; i < m; i++) {   // fixed: i < m
                if (arr[i][j] == 1) ones++;
            }
            if (ones * 2 < m) {
                for (int i = 0; i < m; i++) {
                    arr[i][j] ^= 1;
                }
            }
        }

        int sum = 0;
        for (int j = n - 1, pow = 1; j >= 0; j--, pow <<= 1) {
            int ones = 0;
            for (int i = 0; i < m; i++) {
                if (arr[i][j] == 1) ones++;
            }
            sum += pow * ones;
        }
        return sum;
    }
}