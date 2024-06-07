import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> map = new HashMap<>();
        for (String term : terms) {
            String[] t = term.split(" ");
            map.put(t[0], Integer.parseInt(t[1]));
        }
        
        int tYear = Integer.parseInt(today.split("\\.")[0]);
        int tMonth = Integer.parseInt(today.split("\\.")[1]);
        int tDay = Integer.parseInt(today.split("\\.")[2]);
        int tTotal = (tYear * 12 * 28) + (tMonth * 28) + tDay;
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String date = privacies[i].split(" ")[0];
            String term = privacies[i].split(" ")[1];
            
            int year = Integer.parseInt(date.split("\\.")[0]);
            int month = Integer.parseInt(date.split("\\.")[1]);
            int day = Integer.parseInt(date.split("\\.")[2]);
            month += map.get(term);
            
            int total = (year * 12 * 28) + (month * 28) + day;
            if (tTotal >= total) result.add(i + 1);
        }
        
        return result.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}