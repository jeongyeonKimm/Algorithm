import java.util.Arrays;
import java.util.List;

class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        
        List<String> list2 = Arrays.asList(s2);
        
        for (int i = 0; i < s1.length; i++) {
            if (list2.contains(s1[i])) {
                answer++;
            }
        }
        
        return answer;
    }
}