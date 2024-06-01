class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] clothes = new int[n + 1];
        
        for (int l : lost) {
            clothes[l]--; 
        }
        
        for (int r : reserve) {
            clothes[r]++;
        }
        
        int count = n;
        for (int i = 1; i < clothes.length; i++) {
            if (clothes[i] == -1) {
                if (i - 1 > 0 && clothes[i - 1] > 0){
                    clothes[i - 1]--;
                    clothes[i]++;
                } else if (i + 1 < clothes.length && clothes[i + 1] > 0) {
                    clothes[i + 1]--;
                    clothes[i]++;
                } else {
                    count--;
                }
            }
        }
        return count;
    }
}