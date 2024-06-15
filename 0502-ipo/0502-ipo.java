class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
          int n = profits.length;
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i][0] = profits[i];
            projects[i][1] = capital[i];
        }

        Arrays.sort(projects, (a, b) -> Integer.compare(a[1], b[1]));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int idx = 0;
        for (int i = 0; i < k; i++) {
            
            while (idx < n && projects[idx][1] <= w) {
                maxHeap.offer(projects[idx][0]);
                idx++;
            }

           
            if (!maxHeap.isEmpty()) {
                w += maxHeap.poll(); 
            } else {
                break;
            }
        }

        return w;
    }
}