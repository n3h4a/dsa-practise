class Solution {
    public int kthSmallest(int[][] mat, int k) {
        // keep only the k smallest sums after adding each row
        List<Integer> sums = new ArrayList<>();
        sums.add(0);
        for (int[] row : mat) {
            List<Integer> next = new ArrayList<>();
            for (int s : sums)
                for (int v : row) next.add(s + v);
            Collections.sort(next);
            sums = new ArrayList<>(next.subList(0, Math.min(k, next.size())));
        }
        return sums.get(k - 1);
    }
}