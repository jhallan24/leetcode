class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
         int n=x;
        int rev=0,rem;
        int temp=n;
        
        while(temp!=0){
            rem=temp%10;
            rev=rev*10+rem;
            temp=temp/10;
        }
        if(n==rev){
            return true;
        }
        else{
            return false;
        }
    }
}