import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int n, int[] numlist) {
        List<Integer> list = new ArrayList<>();
        
        for (int i : numlist) {
            if (i % n == 0) {
                list.add(i);
            }
        }
        
        return list.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}