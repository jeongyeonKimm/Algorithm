class Solution {
    
    private int answer = 0;
    private boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        
        dfs(begin, target, words, 0);
      
        return answer;
    }
    
    private void dfs(String begin, String target, String[] words, int count) {
        if (begin.equals(target)) {
            answer = count;
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (visited[i]) continue;
            
            int len = Math.min(begin.length(), words[i].length());
            int sameCount = 0;
            
            for (int j = 0; j < len; j++) {
                if (begin.charAt(j) == words[i].charAt(j)) {
                    sameCount++;
                }
            }
            
            if (sameCount == begin.length() - 1) {
                visited[i] = true;
                dfs(words[i], target, words, count + 1);
                visited[i] = false;
            }
        }
    }
}