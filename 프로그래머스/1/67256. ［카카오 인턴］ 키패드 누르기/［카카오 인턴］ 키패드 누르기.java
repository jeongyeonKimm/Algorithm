class Solution {
    int[] left = {3, 0};
    int[] right = {3, 2};
    
    int[][] btnPos = {{3, 1}, {0, 0}, {0, 1}, {0, 2}, 
                          {1, 0}, {1, 1}, {1, 2},
                          {2, 0}, {2, 1}, {2, 2}};
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        for (int num : numbers) {
            String finger = getFinger(num, hand);
            answer += finger;
            
            if (finger.equals("L")) left = btnPos[num];
            else right = btnPos[num];
        }
        
        return answer;
    }
    
    private String getFinger(int num, String hand) {
        if (num == 1 || num == 4 || num == 7) return "L";
        if (num == 3 || num == 6 || num == 9) return "R";
        
        if (getDistance(left, btnPos[num]) < getDistance(right, btnPos[num])) return "L";
        if (getDistance(left, btnPos[num]) > getDistance(right, btnPos[num])) return "R";
        
        if (hand.equals("left")) return "L";
        else return "R";
    }
    
    private int getDistance(int[] btn1, int[] btn2) {
        return Math.abs(btn1[0] - btn2[0]) + Math.abs(btn1[1] - btn2[1]);
    }
}