class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        backtrack(nums,result,new ArrayList<>(),0);
        return result;
        
    }
    private static void backtrack(int[]nums,List<List<Integer>>result,List<Integer>current,int start){
        result.add(new ArrayList<>(current));
        for(int i=start;i<nums.length;i++){
            current.add(nums[i]);
            backtrack(nums,result,current,i+1);
            current.remove(current.size()-1);
        }
    }
    
}