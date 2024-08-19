class Solution {
    public int solution(int storey) {
        int result = 0;
        
        while (storey > 0) {
            int num = storey % 10;
            storey = storey / 10;
            
            if (num == 5) {
                if (storey % 10 >= 5) {
                    result += (10 - num);
                    storey++;
                } else {
                    result += num;
                }
            } else if (num < 5) {
                result += num;
            } else {
                result += (10 - num);
                storey++;
            }
        }
        
        return result;
    }
}