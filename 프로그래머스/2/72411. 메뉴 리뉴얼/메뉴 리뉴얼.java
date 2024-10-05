import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;

class Solution {
    
    Map<String, Integer> map;
    
    public String[] solution(String[] orders, int[] course) {
        // 최종 코스요리 메뉴가 오름차순으로 정렬되어 있어야 하기 때문에 각 손님들의 단품메뉴 오름차순 정렬
        for (int i = 0; i < orders.length; i++) {
            char[] order = orders[i].toCharArray();
            Arrays.sort(order);
            orders[i] = String.valueOf(order);
        }
        
        ArrayList<String> result = new ArrayList<>();
        
        for (int i = 0; i < course.length; i++) {
            map = new HashMap<>();
            StringBuilder sb = new StringBuilder();
            
            for (int j = 0; j < orders.length; j++) {
                if (course[i] <= orders[j].length()) {
                    makeCourse(sb, orders[j], 0, 0, course[i]);
                }
            }
            
            int max = 0;    // 가장 많이 주문된 조합의 주문 횟수
            
            for (Entry<String, Integer> entry : map.entrySet()) {
                max = Math.max(max, entry.getValue());    
            }
            
            if (max >= 2) {
                for (Entry<String, Integer> entry : map.entrySet()) {
                    if (entry.getValue() == max) {
                        result.add(entry.getKey());
                    }
                }
            }
        }
        
        Collections.sort(result);
        
        return result.toArray(new String[result.size()]);
    }
    
    public void makeCourse(StringBuilder sb, String order, int start, int depth, int n) {
        if (depth == n) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }
        
        for (int i = start; i < order.length(); i++) {
            sb.append(order.charAt(i));
            makeCourse(sb, order, i + 1, depth + 1, n);
            sb.delete(depth, depth + 1);   
        }
    }
}