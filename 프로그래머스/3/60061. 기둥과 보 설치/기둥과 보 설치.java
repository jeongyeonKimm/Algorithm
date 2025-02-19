class Solution {
    
    private boolean[][] pillars;
    private boolean[][] beams;
    
    public int[][] solution(int n, int[][] build_frame) {
        pillars = new boolean[n + 1][n + 1];
        beams = new boolean[n + 1][n + 1];
        int count = 0;
        
        for (int[] frame : build_frame) {
            int x = frame[0];
            int y = frame[1];
            int type = frame[2];
            int job = frame[3];
            
            if (type == 0) {
                if (job == 0) {
                    pillars[x][y] = false;
                    if (!canDelete(n)) {
                        pillars[x][y] = true;
                    } else {
                        count--;
                    }
                } else {
                    if (canInstallPillar(x, y)) {
                        pillars[x][y] = true;
                        count++;
                    }
                }
            } else {
                if (job == 0) {
                    beams[x][y] = false;
                    if (!canDelete(n)) {
                        beams[x][y] = true;
                    } else {
                        count--;
                    }
                } else {
                    if (canInstallBeam(x , y)) {
                        beams[x][y] = true;
                        count++;
                    }
                }
            }
        }
        
        int[][] result = new int[count][3];
        int idx = 0;
        
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (pillars[i][j]) {
                    result[idx][0] = i;
                    result[idx][1] = j;
                    result[idx][2] = 0;
                    idx++;
                }
                
                if (beams[i][j]) {
                    result[idx][0] = i;
                    result[idx][1] = j;
                    result[idx][2] = 1;
                    idx++;
                }
            }
        }
        
        return result;
    }
    
    private boolean canInstallPillar(int x, int y) {
        if(y == 0) return true;
        else if(y > 0 && pillars[x][y - 1]) return true;
        else if(x > 0 && beams[x - 1][y] || beams[x][y]) return true;
        return false;
    }
    
    private boolean canInstallBeam(int x, int y) {
        if(y > 0 && pillars[x][y - 1] || pillars[x + 1][y - 1]) return true;
        else if(x > 0 && beams[x - 1][y] && beams[x + 1][y]) return true;
        return false;
    }
    
    private boolean canDelete(int n) {
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (pillars[i][j] && !canInstallPillar(i, j)) return false;
                else if (beams[i][j] && !canInstallBeam(i, j)) return false;
            }
        }
        return true;
    }
}