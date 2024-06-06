import java.util.Map;
import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);
        
        int[] scores = {3, 2, 1, 0, 1, 2, 3};
        
        for (int i = 0; i < survey.length; i++) {
            String s = survey[i];
            if (choices[i] < 4) {
                map.put(s.charAt(0), map.get(s.charAt(0)) + scores[choices[i] - 1]);
            } else if (choices[i] > 4) {
                map.put(s.charAt(1), map.get(s.charAt(1)) + scores[choices[i] - 1]);
            }
        }
        
        String answer = "";
        if (map.get('R') >= map.get('T')) answer += "R";
        else answer += "T";
        if (map.get('C') >= map.get('F')) answer += "C";
        else answer += "F";
        if (map.get('J') >= map.get('M')) answer += "J";
        else answer += "M";
        if (map.get('A') >= map.get('N')) answer += "A";
        else answer += "N";
        
        return answer;
    }
}