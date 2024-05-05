class Solution {
    public int solution(int[] num_list) {
        int oddNum = 0;
        int evenNum = 0;
        
        for (int num : num_list) {
            if (num % 2 == 0) {
                evenNum = evenNum * 10 + num;
            } else {
                oddNum = oddNum * 10 + num;
            }
        }
        
        return evenNum + oddNum;
    }
}