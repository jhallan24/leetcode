class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x < y) {
            return maximumGainHelper(s, 'b', 'a', y, x);
        } else {
            return maximumGainHelper(s, 'a', 'b', x, y);
        }
    }
private static int maximumGainHelper(String s, char first, char second, int firstPoints, int secondPoints) {
        int totalPoints = 0;
        StringBuilder remaining = new StringBuilder();

        
        for (char c : s.toCharArray()) {
            if (remaining.length() > 0 && remaining.charAt(remaining.length() - 1) == first && c == second) {
                remaining.deleteCharAt(remaining.length() - 1);
                totalPoints += firstPoints;
            } else {
                remaining.append(c);
            }
        }

       StringBuilder finalRemaining = new StringBuilder();
        for (char c : remaining.toString().toCharArray()) {
            if (finalRemaining.length() > 0 && finalRemaining.charAt(finalRemaining.length() - 1) == second && c == first) {
                finalRemaining.deleteCharAt(finalRemaining.length() - 1);
                totalPoints += secondPoints;
            } else {
                finalRemaining.append(c);
            }
        }

        return totalPoints;
    
    }
}