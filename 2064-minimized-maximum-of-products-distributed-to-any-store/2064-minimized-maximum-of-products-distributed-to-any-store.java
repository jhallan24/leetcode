class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int max=0;
        for(int quantity:quantities){
            max=Math.max(max,quantity);
        }
        int left=0;
        int right=max;
        while(left<right){
            int mid=left+(right-left)/2;
            if(canWeA(mid,n,quantities)){
                right=mid;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }
    boolean canWeA(int max,int shop,int[]quantities){
        int shopN=0;
        for(int quantity:quantities){
            shopN+=(int)Math.ceil((quantity*1.0)/max);
            if(shopN>shop)return false;
        }
        return true;
    }
}