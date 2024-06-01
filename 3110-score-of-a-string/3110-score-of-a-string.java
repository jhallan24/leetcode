class Solution {
    public int scoreOfString(String s) {
        char[]ch=s.toCharArray();
        int score=0;
        for(int i=1;i<s.length();i++){
            score=score+Math.abs(ch[i-1]-ch[i]);
        }
        return score;
    }
}