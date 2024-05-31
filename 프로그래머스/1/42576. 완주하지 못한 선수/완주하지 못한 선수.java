import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hm = new HashMap<>();
        for (String p : participant) hm.put(p, hm.getOrDefault(p, 0) + 1);
        for (String c : completion) hm.put(c, hm.get(c) - 1);
        
        String answer = "";
        for (String name : hm.keySet()) {
            if (hm.get(name) > 0) answer = name;
        }
        
        return answer;
    }
}