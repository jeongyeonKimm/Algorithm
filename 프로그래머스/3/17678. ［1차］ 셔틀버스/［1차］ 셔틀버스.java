import java.util.PriorityQueue;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> waitingQueue = new PriorityQueue<>();
        for (String tt : timetable) {
            String[] time = tt.split(":");
            int hour = Integer.parseInt(time[0]);
            int minute = Integer.parseInt(time[1]);
            waitingQueue.offer(hour * 60 + minute);
        }
        
        int startTime = 9 * 60;
        int conTime = 0;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            count = 0;
            
            while (!waitingQueue.isEmpty()) {
                int curTime = waitingQueue.peek();
                if (count >= m || curTime > startTime) {
                    break;
                }
                
                waitingQueue.poll();
                count++;
                conTime = curTime - 1;
            }
            
            startTime += t;
        }
        
        if (count < m) {
            conTime = startTime - t;
        }
        
        String hour = String.format("%02d", conTime / 60);
        String minute = String.format("%02d", conTime % 60);
        
        return hour + ":" + minute;
    }
}