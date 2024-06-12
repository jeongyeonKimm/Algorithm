import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        List<String> friendList = Arrays.stream(friends).collect(Collectors.toList());
        
        int[][] map = new int[friends.length][friends.length];
        int[] score = new int[friends.length];
        
        for (String gift : gifts) {
            int give = friendList.indexOf(gift.split(" ")[0]);
            int take = friendList.indexOf(gift.split(" ")[1]);
            map[give][take]++;
            score[give]++;
            score[take]--;
        }
        
        int max = 0;
        for (int i = 0; i < friends.length; i++) {
            int count = 0;
            for (int j = 0; j < friends.length; j++) {
                if (i == j) continue;
                
                if ((map[i][j] > map[j][i]) || 
                    (map[i][j] == map[j][i] && score[i] > score[j])) {
                    count++;
                }
            }
            max = Math.max(count, max);
        }
        
        return max;
    }
}