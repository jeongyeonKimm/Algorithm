class Solution {
    public int solution(int n, int[] cores) {
        int min = 1;
        int max = 10000 * n;
        int finishTime = 0;
        int task = 0;
        
        while (min <= max) {
            int mid = (min + max) / 2;
            
            int count = countProcessedTask(cores, mid);
            if (count < n) {
                min = mid + 1;
            } else {
                max = mid - 1;
                finishTime = mid;
                task = count;
            }
        }
        
        int answer = 0;
        
        task -= n;
        for (int i = cores.length - 1; i >= 0; i--) {
            if (finishTime % cores[i] == 0) {
                if (task == 0) {
                    answer = i + 1;
                    break;
                }
                task--;
            }
        }
        
        return answer;
    }
    
    public int countProcessedTask(int[] cores, int mid) {
        int count = cores.length;   // 초기에는 모든 코어에서 작업 진행
        
        for (int i = 0; i < cores.length; i++) {
            count += mid / cores[i];
        }
        
        return count;
    }
}