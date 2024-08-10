class Solution {
    
    class UnionFind{
     private int[] parent;
        private int[] rank;
        private int count;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            count = size;
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); 
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
                count--;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public int regionsBySlashes(String[] grid) {
             int n = grid.length;
        int size = 4 * n * n;
        UnionFind uf = new UnionFind(size);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int root = 4 * (i * n + j);

                
                char c = grid[i].charAt(j);

                
                if (c == '/') {
                    uf.union(root + 0, root + 3);
                    uf.union(root + 1, root + 2);
                } else if (c == '\\') {
                    uf.union(root + 0, root + 1);
                    uf.union(root + 2, root + 3);
                } else {
                    uf.union(root + 0, root + 1);
                    uf.union(root + 1, root + 2);
                    uf.union(root + 2, root + 3);
                }

               
                if (j + 1 < n) {
                    uf.union(root + 1, 4 * (i * n + j + 1) + 3);
                }
                
                if (i + 1 < n) {
                    uf.union(root + 2, 4 * ((i + 1) * n + j) + 0);
                }
            }
        }

       
        return uf.getCount();
    }
}