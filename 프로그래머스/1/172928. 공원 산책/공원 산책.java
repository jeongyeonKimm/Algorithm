class Solution {
    public int[] solution(String[] park, String[] routes) {
        int h = park.length;
        int w = park[0].length();
        
        int startX = 0;
        int startY = 0;
        
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (park[i].charAt(j) == 'S') {
                    startX = i;
                    startY = j;
                    break;
                }
            }
        }
        
        int curX = startX;
        int curY = startY;
        for (String r : routes) {
            String direction = r.split(" ")[0];
            int num = Integer.parseInt(r.split(" ")[1]);
        
            int nx = curX;
            int ny = curY;
            
            for (int i = 0; i < num; i++) {
                switch(direction) {
                    case "N":
                        nx--;
                        break;
                    case "E":
                        ny++;
                        break;
                    case "S":
                        nx++;
                        break;
                    case "W":
                        ny--;
                        break;
                }
                
                if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                    if (park[nx].charAt(ny) == 'X') {
                        break;
                    }
                    
                    if (i == num - 1) {
                        curX = nx;
                        curY = ny;
                    }
                }
            }
        }
        
        return new int[] {curX, curY};
    }
}