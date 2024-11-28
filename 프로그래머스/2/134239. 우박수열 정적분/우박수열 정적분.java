import java.util.ArrayList;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        
        ArrayList<Integer> seq = new ArrayList<>();
        seq.add(k);
        
        while (k > 1) {
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k = k * 3 + 1;
            }
            
            seq.add(k);
        }
        
        int n = seq.size() - 1;
        
        double[] sum = new double[n + 1];
        for (int i = 1; i <= n; i++) {
            double min = Math.min(seq.get(i), seq.get(i - 1));
            double max = Math.max(seq.get(i), seq.get(i - 1));
            
            double tmp = min + ((max - min) / 2);
            sum[i] = sum[i - 1] + tmp; 
        }
        
        for (int i = 0; i < ranges.length; i++) {
            if (n + ranges[i][1] < ranges[i][0]) {
                answer[i] = -1;
            } else {
                answer[i] = sum[n + ranges[i][1]] - sum[ranges[i][0]];
            }
        }
        
        return answer;
    }
}