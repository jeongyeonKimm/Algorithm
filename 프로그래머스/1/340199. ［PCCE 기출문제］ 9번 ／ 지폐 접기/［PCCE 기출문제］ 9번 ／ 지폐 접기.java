class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        while (getMin(bill) > getMin(wallet) || getMax(bill) > getMax(wallet)) {
            bill[bill[0] > bill[1] ? 0 : 1] /= 2;
            answer++;
        }
        
        return answer;
    }
    
    private int getMax(int[] arr) {
        return Math.max(arr[0], arr[1]);
    }
    
    private int getMin(int[] arr) {
        return Math.min(arr[0], arr[1]);
    }
}