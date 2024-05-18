import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> answer = new ArrayList<>();
        for (int i : arr) {
            if (i % divisor == 0) {
                answer.add(i);
            }
        }
        
        if (answer.size() == 0) {
            return new int[] {-1};
        }
        
        Collections.sort(answer);
        
        return answer.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}