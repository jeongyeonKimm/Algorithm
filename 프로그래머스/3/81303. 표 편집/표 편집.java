import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int[] prev = new int[n];
        int[] next = new int[n];
        
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        next[n - 1] = -1;
        
        Stack<Node> removed = new Stack<>();
        StringBuilder answer = new StringBuilder("O".repeat(n));
        
        for (String c : cmd) {
            char dir = c.charAt(0);
            if (dir == 'U') {
                int num = Integer.parseInt(c.substring(2));
                while (num-- > 0) {
                    k = prev[k];
                }
            } else if (dir == 'D') {
                int num = Integer.parseInt(c.substring(2));
                while (num-- > 0) {
                    k = next[k];
                }
            } else if (dir == 'C') {
                removed.push(new Node(prev[k], k, next[k]));
                answer.setCharAt(k, 'X');
                
                if (prev[k] != -1) next[prev[k]] = next[k];
                if (next[k] != -1) prev[next[k]] = prev[k];
                
                if (next[k] != -1) k = next[k];
                else k = prev[k];
            } else if (dir == 'Z') {
                Node latest = removed.pop();
                answer.setCharAt(latest.cur, 'O');
                
                if (latest.next != -1) prev[latest.next] = latest.cur;
                if (latest.prev != -1) next[latest.prev] = latest.cur;
            }
        }
        
        return answer.toString();
    }
    
    static class Node {
        int prev;
        int cur;
        int next;
        
        public Node(int prev, int cur, int next) {
            this.prev = prev;
            this.cur = cur;
            this.next = next;
        }
    }
}