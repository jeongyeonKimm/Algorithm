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
                finishTime = mid;   // 작업이 종료된 시각
                task = count;   // finishTime에 처리될 수 있는 작업의 수
            }
        }
        
        int answer = 0;
        
        task -= n;  // 처리해야 될 n개의 작업 처리 완료
        for (int i = cores.length - 1; i >= 0; i--) {
            if (finishTime % cores[i] == 0) {
                if (task == 0) {
                    answer = i + 1;
                    break;
                }
                task--; // n번째 작업 처리 코어를 찾기 위해 finishTime에 처리 가능한 작업들 중 n번째 이후의 작업을 배제해야 하므로 n개를 처리하고 남은 task를 줄이면서 마지막 코어 찾기
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