import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] numbers) {
        int answer = 45;
        
        for (int i : numbers) {
            answer -= i;
        }
        
        return answer;
    }
}