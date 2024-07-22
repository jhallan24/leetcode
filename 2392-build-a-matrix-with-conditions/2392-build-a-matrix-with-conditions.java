class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] matrix = new int[k][k];
        List<Integer> rowOrder = topologicalSort(k, rowConditions);
        List<Integer> colOrder = topologicalSort(k, colConditions);
        
        if (rowOrder.isEmpty() || colOrder.isEmpty()) {
            return new int[0][0];
        }
        
        int[] rowIndex = new int[k + 1];
        int[] colIndex = new int[k + 1];
        
        for (int i = 0; i < k; i++) {
            rowIndex[rowOrder.get(i)] = i;
            colIndex[colOrder.get(i)] = i;
        }
        
        for (int num = 1; num <= k; num++) {
            matrix[rowIndex[num]][colIndex[num]] = num;
        }
        
        return matrix;
    }
    
    private List<Integer> topologicalSort(int k, int[][] conditions) {
        List<Integer> order = new ArrayList<>();
        int[] inDegree = new int[k + 1];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for (int i = 1; i <= k; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int[] condition : conditions) {
            int from = condition[0];
            int to = condition[1];
            graph.get(from).add(to);
            inDegree[to]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            order.add(node);
            for (int neighbor : graph.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        if (order.size() != k) {
            return new ArrayList<>();
        }
        
        return order;
   
    }
}