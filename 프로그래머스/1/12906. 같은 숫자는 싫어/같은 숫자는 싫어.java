import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] != arr[i]) {
                answer.add(arr[i]);
            }
        }

        return answer.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}