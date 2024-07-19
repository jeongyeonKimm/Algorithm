import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> users = new HashMap<>();
        
        for (String r : record) {
            String[] info = r.split(" ");
            String command = info[0];
            String userId = info[1];
            
            if (command.equals("Enter") || command.equals("Change")) {
                String nickname = info[2];
                users.put(userId, nickname);
            }
        }
        
        List<String> result = new ArrayList<>();
        
        for (String r : record) {
            String[] info = r.split(" ");
            String command = info[0];
            String userId = info[1];
            
            if (command.equals("Enter")) {
                result.add(users.get(userId) + "님이 들어왔습니다.");
            } else if (command.equals("Leave")) {
                result.add(users.get(userId) + "님이 나갔습니다.");
            }
        }
        
        return result.toArray(new String[result.size()]);
    }
}