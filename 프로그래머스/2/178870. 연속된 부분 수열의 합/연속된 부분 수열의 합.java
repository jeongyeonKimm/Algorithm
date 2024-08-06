class Solution {
    public int[] solution(int[] sequence, int k) {
        int len = sequence.length;
        int start = 0;
        int end = len;
        int sum = 0;
        
        for (int i = 0, idx = 0; i < len; i++) {
            while (sum < k && idx < len) {
                sum += sequence[idx++];
            }
            
            if (sum == k) {
                if ((idx - i - 1) < (end - start)) {
                    start = i;
                    end = idx - 1;
                }
            }
            
            sum -= sequence[i]; // sum에서 i번째 수만 빼서 sum을 다시 계산하는 비용을 줄임(sum: 인덱스 i ~ idx의 합)
        }
        
        return new int[] {start, end};
    }
}