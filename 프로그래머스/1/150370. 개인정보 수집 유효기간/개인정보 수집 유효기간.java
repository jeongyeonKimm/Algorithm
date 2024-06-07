import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> map = new HashMap<>();
        for (String term : terms) {
            String[] t = term.split(" ");
            map.put(t[0], Integer.parseInt(t[1]));
        }
        
        int todayTotal = getTotalDate(today);
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String date = privacies[i].split(" ")[0];
            String term = privacies[i].split(" ")[1];
            
            int total = getTotalDate(date) + (map.get(term) * 28);
            if (todayTotal >= total) result.add(i + 1);
        }
        
        return result.stream()
            .mapToInt(i -> i)
            .toArray();
    }
    
    private int getTotalDate(String date) {
        int year = Integer.parseInt(date.split("\\.")[0]);
        int month = Integer.parseInt(date.split("\\.")[1]);
        int day = Integer.parseInt(date.split("\\.")[2]);
        return (year * 12 * 28) + (month * 28) + day;
    }
}