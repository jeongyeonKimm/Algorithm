import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> map = new HashMap<>();
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char ch = key.charAt(i);
                if (map.containsKey(ch)) {
                    map.put(ch, Math.min(i + 1, map.get(ch)));
                } else {
                    map.put(ch, i + 1);
                }
            }
        }
        
        int[] result = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int count = 0;
            for (int j = 0; j < target.length(); j++) {
                char t = target.charAt(j);
                if (map.containsKey(t)) {
                    count += map.get(t);
                } else {
                    count = 0;
                    break;
                }
            }
            
            if (count > 0) result[i] = count;
            else result[i] = -1;
        }
        
        return result;
    }
}