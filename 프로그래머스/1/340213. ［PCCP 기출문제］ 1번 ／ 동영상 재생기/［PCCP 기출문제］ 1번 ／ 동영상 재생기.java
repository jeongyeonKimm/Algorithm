class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int totalLen = Integer.parseInt(video_len.split(":")[0]) * 60 + Integer.parseInt(video_len.split(":")[1]);
        int current = Integer.parseInt(pos.split(":")[0]) * 60 + Integer.parseInt(pos.split(":")[1]);
        int start = Integer.parseInt(op_start.split(":")[0]) * 60 + Integer.parseInt(op_start.split(":")[1]);
        int end = Integer.parseInt(op_end.split(":")[0]) * 60 + Integer.parseInt(op_end.split(":")[1]);
        
        for (String command : commands) {
            if (start <= current && current <= end) {
                current = end;
            }
            
            if (command.equals("prev")) {
                current -= 10;
                if (current < 0) {
                    current = 0;
                }
            } else if (command.equals("next")) {
                current += 10;
                if (current > totalLen) {
                    current = totalLen;
                }
            }
        }
        
        if (start <= current && current <= end) {
            current = end;
        }
        
        int minute = current / 60;
        int second = current % 60;
        
        return String.format("%02d:%02d", minute, second);
    }
}