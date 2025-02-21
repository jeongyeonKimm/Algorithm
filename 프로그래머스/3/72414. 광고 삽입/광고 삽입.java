class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = toIntTime(play_time);
        int advTime = toIntTime(adv_time);
        
        long[] timeLogs = new long[360000];   // 누적합
        for (String log : logs) {
            String[] l = log.split("-");
            int start = toIntTime(l[0]);
            int end = toIntTime(l[1]);
            
            timeLogs[start]++;
            timeLogs[end]--;
        }
        
        for (int i = 1; i < 360000; i++) {
            timeLogs[i] += timeLogs[i - 1];
        }
        
        long maxTime = 0;
        long current = 0;
        int startTime = 0;
        
        for (int i = advTime; i <= playTime; i++) {
            current += timeLogs[i] - timeLogs[i - advTime];
            
            if (current > maxTime) {
                startTime = i - advTime + 1;
                maxTime = current;
            }
        }
        
        return toStrTime(startTime);
    }
    
    private int toIntTime(String time) {
        String[] t = time.split(":");
        int hour = Integer.parseInt(t[0]);
        int minute = Integer.parseInt(t[1]);
        int second = Integer.parseInt(t[2]);
        
        return hour * 60 * 60 + minute * 60 + second;
    }
    
    private String toStrTime(int time) {
        int hour = time / (60 * 60);
        int minute = time % (3600) / 60;
        int second = time % 60;
        
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}