import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        
        int answer = 0;
        for (int money : d) {
            if (budget >= money) {
                answer++;
                budget -= money;
            }
        }
        return answer;
    }
}