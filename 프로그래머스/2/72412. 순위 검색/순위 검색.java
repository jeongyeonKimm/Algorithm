import java.util.*;

class Solution {
    
    private Map<String, List<Integer>> map;
    
    public int[] solution(String[] info, String[] query) {
        int n = info.length;
        int m = query.length;
        
        map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            String[] splitted = info[i].split(" ");
            makeCombination(splitted, 0, "");
        }
        
        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }
        
        int[] answer = new int[m];
        
        for (int i = 0; i < m; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] q = query[i].split(" ");
            answer[i] = map.containsKey(q[0]) ? binarySearch(q[0], Integer.parseInt(q[1])) : 0;
        }
        
        return answer;
    }
    
    private void makeCombination(String[] arr, int count, String combi) {
        if (count == 4) {
            if (!map.containsKey(combi)) {
                List<Integer> scores = new ArrayList<>();
                map.put(combi, scores);
            }
            map.get(combi).add(Integer.parseInt(arr[4]));
            return;
        }
        
        makeCombination(arr, count + 1, combi + "-");
        makeCombination(arr, count + 1, combi + arr[count]);
    }
    
    private int binarySearch(String q, int score) {
        List<Integer> scores = map.get(q);
        
        int start = 0;
        int end = scores.size() - 1;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            if (scores.get(mid) < score) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return scores.size() - start;
    }
}