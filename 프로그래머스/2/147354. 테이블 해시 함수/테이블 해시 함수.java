import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[col - 1] > o2[col - 1]) {
                    return 1;
                } else if (o1[col - 1] < o2[col - 1]) {
                    return -1;
                } else {
                    return o2[0] - o1[0];
                }
            }
        });
        
        int result = 0;
        for (int i = row_begin; i <= row_end; i++) {
            int modSum = 0;
            for (int j = 0; j < data[i - 1].length; j++) {
                modSum += data[i - 1][j] % i;               
            }
            
            result ^= modSum;
        }
        
        return result;
    }
}