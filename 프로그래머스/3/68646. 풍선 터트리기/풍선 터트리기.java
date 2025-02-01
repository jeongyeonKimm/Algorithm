class Solution {
    public int solution(int[] a) {
        int n = a.length;
        
        // 인접한 두 풍선 중에서 번호가 더 작은 풍선을 터트리는 행위는 최대 1번만 가능
        // -> 풍선이 최후에 살아남기 위해서는 양쪽에 자기자신 보다 작은 풍선만 계속해서 위치해야 함
        // -> i번째 풍선을 기준으로 좌우에 있는 풍선들 중 가장 작은 값을 left, right 배열에 저장하고
        // -> left[i]와 right[i]에게 모두 작은 a[i]는 살아남을 수 X
        
        int[] left = new int[n];
        int[] right = new int[n];
        
        left[0] = a[0];
        right[n - 1] = a[n - 1];
        
        for (int i = 1; i < n; i++) {
            left[i] = Math.min(left[i - 1], a[i]);
        }
        
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.min(right[i + 1], a[i]);
        }
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (left[i] < a[i] && right[i] < a[i]) {
                continue;
            }
            answer++;
        }
        
        return answer;
    }
}