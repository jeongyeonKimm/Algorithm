class Solution {
    
    private int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(0, numbers, target, 0);
        
        return answer;
    }
    
    private void dfs(int depth, int[] numbers, int target, int sum) {
        if (depth == numbers.length) {
            if (sum == target) answer++;
            return;
        }
        
        dfs(depth + 1, numbers, target, sum + numbers[depth]);
        dfs(depth + 1, numbers, target, sum - numbers[depth]);
    }
}