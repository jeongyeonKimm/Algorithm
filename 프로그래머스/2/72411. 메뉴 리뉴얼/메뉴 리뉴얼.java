import java.util.*;
import java.util.Map.Entry;

class Solution {
    
    Map<String, Integer> map;
    
    public String[] solution(String[] orders, int[] course) {
        for (int i = 0; i < orders.length; i++) {
            char[] menus = orders[i].toCharArray();
            Arrays.sort(menus);
            orders[i] = String.valueOf(menus);
        } 
        
        List<String> result = new ArrayList<>();
        
        for (int c : course) {
            map = new HashMap<>();
            
            for (String order : orders) {
                makeCourse(order, c, new StringBuilder(), 0, 0);
            }
            
            int maxCount = 0;
            for (Entry<String, Integer> entry : map.entrySet()) {
                maxCount = Math.max(maxCount, entry.getValue());
            }
            
            if (maxCount >= 2) {
                for (Entry<String, Integer> entry : map.entrySet()) {
                    if (entry.getValue() == maxCount) {
                        result.add(entry.getKey());
                    }
                }
            }
        }
        
        Collections.sort(result);
        
        return result.toArray(new String[result.size()]);
    }
    
    public void makeCourse(String order, int courseSize, StringBuilder courseMenu, int start, int depth) {
        if (depth == courseSize) {
            map.put(courseMenu.toString(), map.getOrDefault(courseMenu.toString(), 0) + 1);
            return;
        }
        
        for (int i = start; i < order.length(); i++) {
            courseMenu.append(order.charAt(i));
            makeCourse(order, courseSize, courseMenu, i + 1, depth + 1);
            courseMenu.delete(depth, depth + 1);
        }
    }
}