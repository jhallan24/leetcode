class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int happy=0;
        
        for(int i=0;i!=customers.length;i++){
            if(grumpy[i]==0)
                happy=happy+customers[i];
        }
        int maxunhappy=0;
        int unhappy=0;
        for(int i=1-minutes , j=0 ; j!=customers.length ; i++ , j++){
            if(grumpy[j]==1)
                unhappy=unhappy+customers[j];
            if(i>0){
                if(grumpy[i-1]==1)
                    unhappy=unhappy-customers[i-1];
            }
            if(i>=0){
                maxunhappy=Math.max(maxunhappy,unhappy);
            }
        }
        return happy+maxunhappy;
    }
}