class Solution {

    public static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int node) {
        vis[node] = true;

        for (Integer vt : adj.get(node)) {
            if (!vis[vt]) {
                dfs(adj, vis, vt);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Convert adjacency matrix to adjacency list
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if (isConnected[i][j] == 1) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        boolean[] vis = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                count++;
                dfs(adj, vis, i);
            }
        }

        return count;
    }
}