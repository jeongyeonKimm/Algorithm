import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        Arrays.sort(num_list);
        
        return Arrays.stream(num_list)
            .skip(5)
            .toArray();
    }
}