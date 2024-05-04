import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] num_list, int n) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < num_list.length; i += n) {
            result.add(num_list[i]);
        }
        
        return result.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}