import java.util.Arrays;

class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        
        for (int i = arr[arr.length - 1]; ; i++) {
            boolean flag = true;
            for (int n : arr) {
                if (i % n != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) return i;
        } 
    }
}