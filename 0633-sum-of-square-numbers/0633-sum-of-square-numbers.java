class Solution {
    public boolean judgeSquareSum(int c) {
        for (int a = 0; a <= Math.sqrt(c); a++) {
            int b2 = c - a * a;
            if (b2 < 0) {
                continue;
            }
            int b = (int) Math.sqrt(b2);
            if (b * b == b2) {
                return true;
            }
        }
        return false;
    }

 }