import java.util.ArrayList;

class Solution {
    
    private char[] vowels = {'A', 'E', 'I', 'O', 'U'};
    private ArrayList<String> list = new ArrayList<>();
    
    public int solution(String word) {
        dfs("", 0);
        
        return list.indexOf(word);
    }
    
    private void dfs(String str, int depth) {
        list.add(str);
        
        if (depth == 5) return;
        
        for (int i = 0; i < 5; i++) {
            dfs(str + vowels[i], depth + 1);
        }
    }
}