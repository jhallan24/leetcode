class Solution {
    public int[] singleNumber(int[] nums) {
       int a=0;
        for(int i:nums){
            a=a^i;
        }
        a=a& -a;
        int x=0;
        int y=0;
        for(int num:nums){
            if((num & a)==0){
                x=x^num;
            }else{
                y=y^num;
            }
        }
        return new int[]{x,y};
    }
}