import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> deleteNum = Arrays.stream(delete_list)
                                .boxed()
                                .collect(Collectors.toList());
        
        List<Integer> answer = new ArrayList<>();
        for (int n : arr) {
            if (!deleteNum.contains(n)) {
                answer.add(n);
            }
        }
        
        return answer.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}