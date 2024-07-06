class Solution {
    public int passThePillow(int n, int time) {
        int cycleLength = 2 * (n - 1);
        int effectiveTime = time % cycleLength;
        int position = 1;
        int direction = 1;  
        for (int i = 0; i < effectiveTime; i++) {
            position += direction;
            if (position == n || position == 1) {
                direction *= -1;
            }
        }
        
        return position;
    }

    
}