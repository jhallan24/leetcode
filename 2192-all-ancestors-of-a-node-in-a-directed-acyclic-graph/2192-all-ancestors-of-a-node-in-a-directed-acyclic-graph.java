class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> result = new ArrayList<>();
        List<Set<Integer>> ancestors = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            ancestors.add(new HashSet<>());
            result.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.get(from).add(to);
        }
        
        
        for (int i = 0; i < n; i++) {
            dfs(i, i, graph, ancestors);
        }
        
        for (int i = 0; i < n; i++) {
            List<Integer> sortedAncestors = new ArrayList<>(ancestors.get(i));
            Collections.sort(sortedAncestors);
            result.get(i).addAll(sortedAncestors);
        }
        
        return result;
    }
    
    private static void dfs(int start, int current, List<List<Integer>> graph, List<Set<Integer>> ancestors) {
        for (int neighbor : graph.get(current)) {
            if (ancestors.get(neighbor).add(start)) {
                dfs(start, neighbor, graph, ancestors);
            }
        }
    }

   
    }
