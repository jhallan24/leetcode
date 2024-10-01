class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> minutesList = new ArrayList<>();
 for (String time : timePoints) {
            String[] timeParts = time.split(":");
            int hours = Integer.parseInt(timeParts[0]);
            int minutes = Integer.parseInt(timeParts[1]);
            int totalMinutes = hours * 60 + minutes;
            minutesList.add(totalMinutes);
        }

       
        Collections.sort(minutesList);

        
        int minDifference = Integer.MAX_VALUE;

        
        for (int i = 1; i < minutesList.size(); i++) {
            int diff = minutesList.get(i) - minutesList.get(i - 1);
            minDifference = Math.min(minDifference, diff);
        }

      
        int circularDiff = (1440 + minutesList.get(0)) - minutesList.get(minutesList.size() - 1);
        minDifference = Math.min(minDifference, circularDiff);

        return minDifference;
    
    }
}