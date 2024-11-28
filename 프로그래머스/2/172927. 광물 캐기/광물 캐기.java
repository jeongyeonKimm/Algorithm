import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int[][] fatigue = new int[][] {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        
        int totalPicks = Arrays.stream(picks).sum();
        
        ArrayList<Turn> turns = new ArrayList<>();
        
        for (int i = 0; i < minerals.length; i += 5) {
            if (totalPicks == 0) break;
            
            int dia = 0;
            int iron = 0;
            int stone = 0;
            for (int j = i; j < i + 5; j++) {
                if (j == minerals.length) break;
                
                String m = minerals[j];
                int idx = m.equals("diamond") ? 0 : m.equals("iron") ? 1 : 2;
                
                dia += fatigue[0][idx];
                iron += fatigue[1][idx];
                stone += fatigue[2][idx];
            }
            
            turns.add(new Turn(dia, iron, stone));
            totalPicks--;
        }
        
        Collections.sort(turns, (o1, o2) -> (o2.stone - o1.stone));
        
        int result = 0;
        for (Turn t : turns) {
            if (picks[0] > 0) {
                result += t.dia;
                picks[0]--;
                continue;
            } 
            
            if (picks[1] > 0) {
                result += t.iron;
                picks[1]--;
                continue;
            }
            
            if (picks[2] > 0) {
                result += t.stone;
                picks[2]--;
                continue;
            }
        }
        
        return result;
    }
    
    class Turn {
        int dia;
        int iron;
        int stone;
        
        public Turn(int dia, int iron, int stone) {
            this.dia = dia;
            this.iron = iron;
            this.stone = stone;
        }
    }
}