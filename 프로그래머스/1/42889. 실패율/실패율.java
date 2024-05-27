import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] players = new int[N + 2];
        for (int s : stages) {
            players[s]++;
        }
        
        int allPlayers = stages.length;
        List<Stage> stageInfo = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            Stage stage = new Stage(i, (double)players[i] / allPlayers);
            stageInfo.add(stage);
            
            allPlayers -= players[i];
        }
        
        Collections.sort(stageInfo, Collections.reverseOrder());
        
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = stageInfo.get(i).id;
        }
        return result;
    }
    
    class Stage implements Comparable<Stage>{
        int id;
        double failRate;
        
        public Stage(int id, double failRate) {
            this.id = id;
            this.failRate = failRate;
        }
        
        @Override
        public int compareTo(Stage o) {
            if (this.failRate > o.failRate) {
                return 1;
            } else if (this.failRate < o.failRate) {
                return -1;
            }
            return 0;
        }
    }
}