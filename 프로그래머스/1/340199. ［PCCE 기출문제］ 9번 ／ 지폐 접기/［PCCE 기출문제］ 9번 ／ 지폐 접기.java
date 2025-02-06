class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int billShort = Math.min(bill[0], bill[1]);
        int billLong = Math.max(bill[0], bill[1]);
        int walletShort = Math.min(wallet[0], wallet[1]);
        int walletLong = Math.max(wallet[0], wallet[1]);
        
        while (billShort > walletShort || billLong > walletLong) {
            if (bill[0] > bill[1]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
            answer++;
            billShort = Math.min(bill[0], bill[1]);
            billLong = Math.max(bill[0], bill[1]);
        }
        
        return answer;
    }
}