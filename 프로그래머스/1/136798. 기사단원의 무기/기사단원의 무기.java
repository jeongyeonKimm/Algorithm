class Solution {
    public int solution(int number, int limit, int power) {
        int[] count = new int[number + 1];
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number / i; j++) {
                count[i * j]++;
            }
        }
        
        int result = 0;
        for (int i = 1; i <= number; i++) {
            if (count[i] > limit) result += power;
            else result += count[i];
        }
        return result;
    }
}