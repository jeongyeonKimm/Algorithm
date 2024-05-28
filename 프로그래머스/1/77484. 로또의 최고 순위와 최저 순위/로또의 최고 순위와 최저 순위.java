import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        List<Integer> winList = Arrays.stream(win_nums).boxed().collect(Collectors.toList());
        
        int zeroCount = 0;
        int lottoCount = 0;
        for (int l : lottos) {
            if (l == 0) zeroCount++;
            else if (winList.indexOf(l) != -1) lottoCount++;
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