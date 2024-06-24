import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] c : clothes) {
            map.put(c[1], map.getOrDefault(c[1], 0) + 1);
        }
        
        int count = 1;
        for (String key : map.keySet()) {
            count *= (map.get(key) + 1);
        }
        
        count -= 1;
        
        return count;
    }
}