import java.util.*;

class Solution {
    
    Set<Set<String>> answer = new HashSet<>();  // 제재 아이디 목록의 아이디 나열 순서 관계X
    
    public int solution(String[] user_id, String[] banned_id) {
        backtracking(user_id, banned_id, new HashSet<>(), 0);
        return answer.size();
    }
    
    private void backtracking(String[] user_id, String[] banned_id, HashSet<String> set, int depth) {
        if (depth == banned_id.length) {
            answer.add(set);
            return;
        }
        
        for (int i = 0; i < user_id.length; i++) {
            if (set.contains(user_id[i])) continue;
            
            if (isBanned(user_id[i], banned_id[depth])) {
                set.add(user_id[i]);
                backtracking(user_id, banned_id, new HashSet<>(set), depth + 1);
                set.remove(user_id[i]);
            }
        }
    }
    
    private boolean isBanned(String userId, String bannedId) {
        if (userId.length() != bannedId.length()) return false;
        
        for (int i = 0; i < userId.length(); i++) {
            if (bannedId.charAt(i) != '*' && userId.charAt(i) != bannedId.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }
}