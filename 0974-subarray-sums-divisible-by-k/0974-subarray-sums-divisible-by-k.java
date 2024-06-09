class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer>rm=new HashMap<>();
        rm.put(0,1);
        int count=0;
        int prefixsum=0;
        for(int num:nums){
            prefixsum=prefixsum+num;
            int rem=prefixsum%k;
            if(rem<0){
                rem=rem+k;
            }
            if(rm.containsKey(rem)){
                count=count+rm.get(rem);
            }
            rm.put(rem,rm.getOrDefault(rem,0)+1);
        }
        return count;
    }
}