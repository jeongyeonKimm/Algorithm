import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(int[] topping) {
        int count = 0;
        
        Set<Integer> older = new HashSet<>();
        Map<Integer, Integer> younger = new HashMap<>();
        
        for (int t : topping) {
            younger.put(t, younger.getOrDefault(t, 0) + 1);
        }
        
        for (int t : topping) {
            older.add(t);
            
            younger.put(t, younger.get(t) - 1);
            if (younger.get(t) == 0) {
                younger.remove(t);
            }
            
            if (older.size() == younger.size()) count++;
        }
        
        return count;
    }
}