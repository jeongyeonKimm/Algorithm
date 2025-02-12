class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int n = schedules.length;
        
        int[] recogTime = new int[n];
        for (int i = 0; i < n; i++) {
            recogTime[i] = schedules[i] + 10;
            if (recogTime[i] % 100 > 59) {
                recogTime[i] += 40;
            }
        }
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < 7; j++) {
                if ((j + startday - 1) % 7 <= 4 && recogTime[i] < timelogs[i][j]) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) count++;
        }
        
        return count;
    }
}