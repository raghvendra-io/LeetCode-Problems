class Solution {
    public int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean negative = (dividend < 0) ^ (divisor < 0);

        long dividendAbs = Math.abs((long) dividend);
        long divisorAbs = Math.abs((long) divisor);

        long result = 0;

        while (dividendAbs >= divisorAbs) {
            long value = divisorAbs;
            long multiple = 1;
            
            while (dividendAbs >= (value << 1)) {
                value <<= 1;
                multiple <<= 1;
            }

            dividendAbs -= value;
            result += multiple;
        }

        return (int) (negative ? -result : result);
    }
}