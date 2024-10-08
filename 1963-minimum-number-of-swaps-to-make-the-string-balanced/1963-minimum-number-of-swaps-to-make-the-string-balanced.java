class Solution {
    public int minSwaps(String s) {
        int openCount = 0;   
        int maxOpenCount = 0; 

        
        for (char c : s.toCharArray()) {
            if (c == '[') {
                openCount++; 
            } else {
                openCount--; 
            }
            
            
            maxOpenCount = Math.max(maxOpenCount, -openCount);
        }

        
        return (maxOpenCount + 1) / 2;
   
    }
}