class Solution {
    public int minSwaps(int[] nums) {
        int totalOnes = 0;
        int n = nums.length;
for (int num : nums) {
            if (num == 1) totalOnes++;
        }
if (totalOnes == 0 || totalOnes == n) return 0;
int[] extendedNums = new int[2 * n];
        for (int i = 0; i < n; i++) {
            extendedNums[i] = nums[i];
            extendedNums[i + n] = nums[i];
        }

        int minZeros = Integer.MAX_VALUE;
        int currentZeros = 0;

       
        for (int i = 0; i < totalOnes; i++) {
            if (extendedNums[i] == 0) currentZeros++;
        }
        minZeros = currentZeros;

        
        for (int i = totalOnes; i < 2 * n; i++) {
            if (extendedNums[i] == 0) currentZeros++;
            if (extendedNums[i - totalOnes] == 0) currentZeros--;
            minZeros = Math.min(minZeros, currentZeros);
        }

        return minZeros;
    
    }
}