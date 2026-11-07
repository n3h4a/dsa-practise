class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        Map<Integer, Integer> rank = new HashMap<>();
        for (int x : sorted) rank.putIfAbsent(x, rank.size() + 1);
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) res[i] = rank.get(arr[i]);
        return res;
    }
}