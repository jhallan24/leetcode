class Solution {
    public int appendCharacters(String s, String t) {
        int idx=0;
        int idxt=0;
        while(idx<s.length()){
            if(s.charAt(idx)==t.charAt(idxt)){
                idxt++;
                if(idxt==t.length()){
                    return 0;
                }
            }
            idx++;
        }
return t.length()-idxt;        
    }
}