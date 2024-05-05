import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] num_list) {
        List<Integer> result = Arrays.stream(num_list)
            .boxed()
            .collect(Collectors.toList());
        
        if (num_list[num_list.length - 1] > num_list[num_list.length - 2]) {
            result.add(num_list[num_list.length - 1] - num_list[num_list.length - 2]);
        } else {
            result.add(num_list[num_list.length - 1] * 2);
        }
        
        return result.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}