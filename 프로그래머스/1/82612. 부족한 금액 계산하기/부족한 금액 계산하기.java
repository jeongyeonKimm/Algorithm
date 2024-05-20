class Solution {
    public long solution(int price, int money, int count) {
        long total = 0;
        for (int i = 1; i <= count; i++) {
            total += (price * i);
        }
        
        if (total > money) return (long)(total - money);
        return 0;
    }
}