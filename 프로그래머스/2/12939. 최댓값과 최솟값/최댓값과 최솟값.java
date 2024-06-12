import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {
        List<Integer> list = Arrays.stream(s.split(" "))
            .map(i -> Integer.parseInt(i))
            .sorted()
            .collect(Collectors.toList());
        
        int maxNum = Collections.max(list);
        int minNum = Collections.min(list);
        
        return minNum + " " + maxNum;
    }
}