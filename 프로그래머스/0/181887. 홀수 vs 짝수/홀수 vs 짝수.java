class Solution {
    public int solution(int[] num_list) {
        int oddSum = 0, evenSum = 0;
        
        for (int i = 0; i < num_list.length; i++) {
            if (i % 2 == 0) {
                oddSum += num_list[i];
            } else {
                evenSum += num_list[i];
            }
        }
        
        return oddSum > evenSum ? oddSum : evenSum;
    }
}