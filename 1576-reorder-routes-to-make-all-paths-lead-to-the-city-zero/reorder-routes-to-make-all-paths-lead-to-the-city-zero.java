class Solution {
    public int minReorder(int n, int[][] connections) {
        // store each road both ways; +v means the original road points away from u (needs flipping)
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] c : connections) {
            adj.get(c[0]).add(c[1]);
            adj.get(c[1]).add(-c[0]);
        }
        boolean[] seen = new boolean[n];
        seen[0] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        int flips = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int e : adj.get(u)) {
                int v = Math.abs(e);
                if (seen[v]) continue;
                if (e > 0) flips++;  // road goes u -> v, away from city 0
                seen[v] = true;
                q.add(v);
            }
        }
        return flips;
    }
}