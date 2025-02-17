import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        if (w == 1) {
            return n - num + 1;
        }
        
        num--;
        n--;
        
        int x = num / w;
        int y = num % w;
        if (x % 2 != 0) {
            y = w - 1 - y;
        }
        
        int rows = n / w;
        int cols = n % w;
        int answer = rows - x;
        
        if (rows % 2 != 0) {
            cols = w - 1 - cols;
            answer += (cols <= y && y < w) ? 1 : 0;
        } else {
            answer += (0 <= y && y <= cols) ? 1 : 0;
        }
        
        return answer;
    }
}