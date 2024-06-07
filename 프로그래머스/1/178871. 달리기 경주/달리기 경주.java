import java.util.Map;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0;i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for (String c : callings) {
            int rank = map.get(c);
            
            String tmp = players[rank];
            players[rank] = players[rank - 1];
            players[rank - 1] = tmp;
            
            map.put(players[rank - 1], rank - 1);
            map.put(players[rank], rank);
        }
        return players;
    }
}