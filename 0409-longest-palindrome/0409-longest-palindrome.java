class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer>hm=new HashMap<>();
        int ans=0;
        for(char ch:s.toCharArray()){
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            if(hm.get(ch)==2){
                ans=ans+2;
                hm.remove(ch);
            }
        }
        if(!hm.isEmpty())ans=ans+1;
        return ans;
        
    }
}