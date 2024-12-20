import java.util.Arrays;

class Solution {
    public int[] solution(long begin, long end) {
        int b = (int) begin;
        int e = (int) end; 
        int len = e - b + 1;
        int[] blocks = new int[len];
        
        for (int i = b; i <= e; i++) {
            blocks[i - b] = 1;
            
            for (int j = 2; j <= Math.floor(Math.sqrt(i)); j++) {
                if (i % j == 0) {
                    blocks[i - b] = j;
                    if (i / j <= 10000000) {
                        blocks[i - b] = i / j;
                        break;
                    }
                }
            }
        }
        
        if (b == 1) {
            blocks[0] = 0;
        }
        
        return blocks;
    }
}