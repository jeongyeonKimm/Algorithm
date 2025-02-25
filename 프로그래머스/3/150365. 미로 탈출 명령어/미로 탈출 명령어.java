import java.util.*;

class Solution {
    
    private int[] dx = {1, 0, 0, -1};
    private int[] dy = {0, -1, 1, 0};
    private String[] dir = {"d", "l", "r", "u"};
    private int endR, endC, lenR, lenC;
    private String answer = null;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        endR = r;
        endC = c;
        lenR = n;
        lenC = m;
        
        int shortest = getDistance(x, y, r, c);   // (x, y) -> (r, c) 최단거리
        if ((k - shortest) % 2 != 0 || k < shortest) {  // k - shortest는 짝수만 가능 => 같은 지점을 두번 이상 방문 가능하기 때문에 k를 맞추기 위해 왔다 갔다
            return "impossible";
        }
        
        dfs(x, y, k, 0, new StringBuilder(""));
        return answer == null ? "impossible" : answer;
    }
    
    private int getDistance(int x, int y, int r, int c) {
        return (int) Math.abs(r - x) + (int) Math.abs(c - y);
    }
    
    private void dfs(int curX, int curY, int k, int depth, StringBuilder path) {
        if (answer != null) return; // dir 배열의 방향이 사전 순으로 정렬된 상태이기 때문에 answer가 null이 아니면 return  
        if (depth + getDistance(curX, curY, endR, endC) > k) return;
        if (depth == k) {
            answer = path.toString();
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int nx = curX + dx[i];
            int ny = curY + dy[i];
            
            if (nx < 1 || nx > lenR || ny < 1 || ny > lenC) {
                continue;
            }
            
            path.append(dir[i]);
            dfs(nx, ny, k, depth + 1, path);
            path.delete(depth, depth + 1);
        }
    }
}