class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
         Map<Integer, Integer> modMap = new HashMap<>();
        modMap.put(0, -1); 
        int cumulativeSum = 0;
        for (int i = 0; i < nums.length; i++) {
            cumulativeSum += nums[i];
            int mod = cumulativeSum % k;
            if (modMap.containsKey(mod)) {
                if (i - modMap.get(mod) > 1) {
                    return true; 
                }
            } else {
                modMap.put(mod, i);
            }
        }
        
        return false;
    }

}