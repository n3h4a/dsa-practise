class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);
        Queue<Integer> positions = new ArrayDeque<>();
        for (int i = 0; i < n; i++) positions.add(i);
        int[] res = new int[n];
        // simulate the reveal process on positions; place cards smallest first
        for (int card : deck) {
            res[positions.poll()] = card;
            if (!positions.isEmpty()) positions.add(positions.poll());
        }
        return res;
    }
}