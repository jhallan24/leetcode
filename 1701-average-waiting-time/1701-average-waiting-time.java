class Solution {
    public double averageWaitingTime(int[][] customers) {
        int currentTime = 0;
        double totalWaitingTime = 0;
for (int[] customer : customers) {
            int arrivalTime = customer[0];
            int preparationTime = customer[1];
 if (currentTime < arrivalTime) {
                currentTime = arrivalTime;
            }

int waitingTime = currentTime - arrivalTime+ preparationTime;
            totalWaitingTime += waitingTime;
    currentTime += preparationTime;
        }
return totalWaitingTime / customers.length;
    
    }
}