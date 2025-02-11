class Solution {
    
    private int n, m;
    
    public int solution(int[] mats, String[][] park) {
        n = park.length;
        m = park[0].length;
        int answer = -1;
        
        for (int mat : mats) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++)  {
                    if (park[i][j].equals("-1")) {
                        if (findSpace(park, i, j, mat)) {
                            answer = Math.max(answer, mat);
                        }
                    }
                }
            }
        }
        
        return answer;
    }
    
    private boolean findSpace(String[][] park, int x, int y, int mat) {
        if (x + mat - 1 >= n || y + mat - 1 >= m) {
            return false;
        }
        
        for (int i = x; i < x + mat; i++) {
            for (int j = y; j < y + mat; j++) {
                if (!park[i][j].equals("-1")) {
                    return false;
                }
            }
        }
        
        return true;
    }
}