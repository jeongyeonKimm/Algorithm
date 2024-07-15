import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> in = new HashMap<>();
        Map<String, Integer> out = new HashMap<>();
        
        for (String r : records) {
            String[] info = r.split("[: ]");
            int time = Integer.parseInt(info[0]) * 60 + Integer.parseInt(info[1]);
            String carNum = info[2];
            String inOrOut = info[3];
            
            if (inOrOut.equals("IN")) {
                in.put(carNum, time);
            } else {
                int inTime = in.get(carNum);
                if (out.containsKey(carNum)) {
                    int outTime = out.get(carNum);
                    out.put(carNum, outTime + time - inTime);
                } else {
                    out.put(carNum, time - inTime);
                }
                in.remove(carNum);
            }
        }
        
        int finalTime = 23 * 60 + 59;
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        // 입차 후 출차 하지 않은 차는 11:59 기준으로 처리
        for (String carNum : in.keySet()) {
            int inTime = in.get(carNum);
            if (out.containsKey(carNum)) {
                int outTime = out.get(carNum);
                out.put(carNum, outTime + finalTime - inTime);
            } else {
                out.put(carNum, finalTime - inTime);
            }
        }
        
        Object[] cars = out.keySet().toArray();
        Arrays.sort(cars);
        
        int[] result = new int[cars.length];
        
        for (int i = 0; i < cars.length; i++) {
            int total = baseFee;
            
            int time = out.get(String.valueOf(cars[i]));
            if (time > baseTime) {
                time -= baseTime;
                total += (int) (Math.ceil((double) time / unitTime) * unitFee);
            }
            
            result[i] = total;
        }
        
        return result;
    }
}