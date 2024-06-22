import java.util.Arrays;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] arr = new int[(int) right - (int) left + 1];
        int idx = 0;
        
        for (long i = left; i <= right; i++) {
            arr[idx++] = (int) Math.max(i / n, i % n) + 1;
        }
        
        return arr;
    }
}