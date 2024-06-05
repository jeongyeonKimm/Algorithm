class Solution {
    int[] left = {3, 0};
    int[] right = {3, 2};
    
    public String solution(int[] numbers, String hand) {
        int[][] btnPos = {{3, 1}, {0, 0}, {0, 1}, {0, 2}, 
                          {1, 0}, {1, 1}, {1, 2},
                          {2, 0}, {2, 1}, {2, 2}};
        
        String answer = "";
        for (int num : numbers) {
            if (num == 1 || num == 4 || num == 7) {
                answer += "L";
                left = btnPos[num];
            } else if (num == 3 || num == 6 || num == 9) {
                answer += "R";
                right = btnPos[num];
            } else {
                if (getDistance(btnPos[num], left) < getDistance(btnPos[num], right)) {
                    answer += "L";
                    left = btnPos[num];
                } else if (getDistance(btnPos[num], left) > getDistance(btnPos[num], right)) {
                    answer += "R";
                    right = btnPos[num];
                } else {
                    if (hand.equals("left")) {
                        answer += "L";
                        left = btnPos[num];
                    } else {
                        answer += "R";
                        right = btnPos[num];
                    }
                }
            }
        }
        
        return answer;
    }
    
    private int getDistance(int[] btn1, int[] btn2) {
        return Math.abs(btn1[0] - btn2[0]) + Math.abs(btn1[1] - btn2[1]);
    }
}