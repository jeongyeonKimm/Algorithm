import java.util.ArrayList;

class Solution {
    
    private char[] vowels = {'A', 'E', 'I', 'O', 'U'};
    private int count = 0;
    private ArrayList<String> list;
    
    public int solution(String word) {
        list = new ArrayList<>();
        
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