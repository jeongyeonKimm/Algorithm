import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>();
        
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }
        
        dp.get(1).add(N);
        
        for (int i = 2; i <= 8; i++) {
            int num = Integer.parseInt(("" + N).repeat(i));
            dp.get(i).add(num);
            
            for (int j = 1; j < i; j++) {
                for (int a : dp.get(j)) {
                    for (int b : dp.get(i - j)) {
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(a * b);
                        if (b > 0) dp.get(i).add(a / b);
                    }
                }
            }
        }
        
        int answer = -1;
        for (int i = 1; i <= 8; i++) {
            if (dp.get(i).contains(number)) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}