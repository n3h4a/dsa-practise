class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] want = new int[2];
        for (int s : students) want[s]++;
        for (int i = 0; i < sandwiches.length; i++) {
            if (want[sandwiches[i]] == 0) return sandwiches.length - i;  // nobody left wants the top sandwich
            want[sandwiches[i]]--;
        }
        return 0;
    }
}