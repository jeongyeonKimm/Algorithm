import java.util.Arrays;

class Solution {
    
    private int[] parent;
    
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        Arrays.sort(costs, (b1, b2) -> b1[2] - b2[2]);
        
        int result = 0;
        
        for (int[] cost : costs) {
            int v1 = cost[0];
            int v2 = cost[1];
            int c = cost[2];
            
            if (findParent(v1) != findParent(v2)) {
                unionParent(v1, v2);
                result += c;
            }
        }
        
        return result;
    }
    
    private int findParent(int x) {
        if (parent[x] != x) {
            parent[x] = findParent(parent[x]);
        }
        return parent[x];
    }
    
    private void unionParent(int v1, int v2) {
        v1 = findParent(v1);
        v2 = findParent(v2);
        
        if (v1 < v2) parent[v2] = v1;
        else parent[v1] = v2;
    }
}