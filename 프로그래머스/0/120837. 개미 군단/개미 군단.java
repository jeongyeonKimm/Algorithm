class Solution {
    public int solution(int hp) {
        int[] power = {5, 3, 1};
        
        int count = 0;
        
        for (int p : power) {
            count += (hp / p);
            hp %= p;
        }
        
        return count;
    }
}