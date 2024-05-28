import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        
        int zeroCount = 0;
        int lottoCount = 0;
        
        for (int l : lottos) {
            if (l == 0) zeroCount++;
            else map.put(l, true);
        }
        
        for (int num : win_nums) {
            if (map.containsKey(num)) lottoCount++;
        }
        
        int minRate = 7 - lottoCount;
        int maxRate = 7 - (lottoCount + zeroCount);
        
        if (maxRate > 6) {
            maxRate = 6;
        }
        
        if (minRate > 6) {
            minRate = 6;
        }
        
        return new int[] {maxRate, minRate};
    }
}