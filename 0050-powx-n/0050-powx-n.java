class Solution {
    public double myPow(double x, int n) {
        long power = n;
        if (power < 0) power = -power;   // long avoids overflow for Integer.MIN_VALUE

        double result = 1.0;
        double base = x;
        while (power > 0) {
            if ((power & 1) == 1) result *= base;
            base *= base;
            power >>= 1;
        }
        return n < 0 ? 1.0 / result : result;
    }
}