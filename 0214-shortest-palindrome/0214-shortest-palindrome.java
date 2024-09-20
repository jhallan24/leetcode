class Solution {
    public String shortestPalindrome(String s) {
        
        String rev_s = new StringBuilder(s).reverse().toString();
        String new_s = s + "#" + rev_s;
        int[] kmpTable = computeKMPTable(new_s);
        int palinPrefixLength = kmpTable[new_s.length() - 1];
        String suffix = rev_s.substring(0, rev_s.length() - palinPrefixLength);
         return suffix + s;
    }
    
      private int[] computeKMPTable(String str) {
        int n = str.length();
        int[] kmpTable = new int[n];
        int j = 0; 
        for (int i = 1; i < n; i++) {
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = kmpTable[j - 1];
            }
            if (str.charAt(i) == str.charAt(j)) {
                j++;
            }
            kmpTable[i] = j;
        }
        
        return kmpTable;
    
    }
}