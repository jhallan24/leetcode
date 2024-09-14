class Solution {
    public int longestSubarray(int[] nums) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        
        int longestLength = 0;
        int currentLength = 0;
        for (int num : nums) {
            if (num == maxVal) {
                currentLength++;
                longestLength = Math.max(longestLength, currentLength);
            } else {
                currentLength = 0;
            }
        }
        
        return longestLength;
   
    }
}