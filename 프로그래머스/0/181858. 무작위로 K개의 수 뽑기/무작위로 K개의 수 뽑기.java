import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        int[] result = new int[k];
        Arrays.fill(result, -1);
        
        List<Integer> list = new ArrayList<>();
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!list.contains(arr[i])) {
                list.add(arr[i]);
                result[idx++] = arr[i];
            }
            if (list.size() >= k) break;
        }
        
        return result;
    }
}