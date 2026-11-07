class Solution {
    public int findCenter(int[][] edges) {
        // the center appears in every edge, so it is the node shared by the first two
        int a = edges[0][0], b = edges[0][1];
        return (a == edges[1][0] || a == edges[1][1]) ? a : b;
    }
}