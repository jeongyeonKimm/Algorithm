import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] num_list) {
        int[] result = new int[num_list.length + 1];
        
        for (int i = 0; i < num_list.length; i++) {
            result[i] = num_list[i];
        }
        
        if (num_list[num_list.length - 1] > num_list[num_list.length - 2]) {
            result[result.length - 1] = num_list[num_list.length - 1] - num_list[num_list.length - 2];
        } else {
            result[result.length - 1] = num_list[num_list.length - 1] * 2;
        }
        
        return result;
    }
}