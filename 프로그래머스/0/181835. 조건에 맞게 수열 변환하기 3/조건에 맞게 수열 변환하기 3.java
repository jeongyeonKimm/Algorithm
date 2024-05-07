import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int k) {
        return Arrays.stream(arr)
            .map(n -> k % 2 == 0 ? n + k : n * k)
            .toArray();
    }
}