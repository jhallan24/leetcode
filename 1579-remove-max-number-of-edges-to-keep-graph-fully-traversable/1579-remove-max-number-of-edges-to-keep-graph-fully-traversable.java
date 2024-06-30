class Solution {
    
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind ufCommon = new UnionFind(n);
        UnionFind ufAlice = new UnionFind(n);
        UnionFind ufBob = new UnionFind(n);

        int commonEdgesUsed = 0;
        int aliceEdgesUsed = 0;
        int bobEdgesUsed = 0;

    for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (ufCommon.union(edge[1] - 1, edge[2] - 1)) {
                    ufAlice.union(edge[1] - 1, edge[2] - 1);
                    ufBob.union(edge[1] - 1, edge[2] - 1);
                    commonEdgesUsed++;
                }
            }
        }

        
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (ufAlice.union(edge[1] - 1, edge[2] - 1)) {
                    aliceEdgesUsed++;
                }
            }
        }

       
        for (int[] edge : edges) {
            if (edge[0] == 2) {
                if (ufBob.union(edge[1] - 1, edge[2] - 1)) {
                    bobEdgesUsed++;
                }
            }
        }

        
        if (!ufAlice.isConnected() || !ufBob.isConnected()) {
            return -1;
        }

        int totalEdgesUsed = commonEdgesUsed + aliceEdgesUsed + bobEdgesUsed;
        return edges.length - totalEdgesUsed;

            }
}
class UnionFind{
        int[]parent;
        int[]rank;
        
    public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int u) {
            if (parent[u] != u) {
                parent[u] = find(parent[u]);
            }
            return parent[u];
        }

        public boolean union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);
            if (rootU == rootV) {
                return false;
            }
            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
            return true;
        }

        public boolean isConnected() {
            int root = find(0);
            for (int i = 1; i < parent.length; i++) {
                if (find(i) != root) {
                    return false;
                }
            }
            return true;
        }
}