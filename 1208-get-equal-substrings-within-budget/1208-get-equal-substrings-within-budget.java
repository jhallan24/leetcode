class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int count[]=new int[s.length()];
        for(int i=0;i<s.length();i++){
            count[i]=Math.abs(s.charAt(i)-t.charAt(i));
        }
        int ans=0;
        int right=0;
        int left=0;
        int temp=0;
        while(right<count.length){
            temp=temp+count[right];
            while(temp>maxCost){
                temp=temp-count[left];
                left++;
            }
            ans=Math.max(ans,right-left+1);
            right++;
        }
        return ans;
        
    }
}