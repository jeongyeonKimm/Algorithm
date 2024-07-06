import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(String msg) {
        List<String> dictionary = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            dictionary.add(String.valueOf((char) ('A' + i)));
        }
        
        List<Integer> compress = new ArrayList<>();
        int idx = 0;
        
        while (idx < msg.length()) {
            String prev = String.valueOf(msg.charAt(idx));
            String cur = "";
            for (int i = 1; idx + i <= msg.length(); i++) {
                cur = msg.substring(idx, idx + i);
                if (!dictionary.contains(cur)) {
                    dictionary.add(cur);
                    break;
                }
                prev = cur;
            }
            
            compress.add(dictionary.indexOf(prev) + 1);
            idx += prev.length();
        }
        
        return compress.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}