import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        List<String> reportList = Arrays.stream(report)
                    .distinct()
                    .collect(Collectors.toList());
        
        Map<String, Integer> map = new HashMap<>();
        for (String r : reportList) {
            String target = r.split(" ")[1];
            map.put(target, map.getOrDefault(target, 0) + 1);
        }
        
        int[] result = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            int count = 0;
            for (String r : reportList) {
                if (r.startsWith(id + " ") && map.getOrDefault(r.split(" ")[1], 0) >= k) {
                    count++;
                }
            }
            result[i] = count;
        }
        
        return result;
    }
}