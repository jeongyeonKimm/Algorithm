import java.util.*;

class Solution {
    
    private int[] parent;
    
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        List<Bridge> bridges = new ArrayList<>();
        for (int[] cost : costs) {
            bridges.add(new Bridge(cost[0], cost[1], cost[2]));
        }
        
        Collections.sort(bridges, new Comparator<Bridge>() {
            @Override
            public int compare(Bridge b1, Bridge b2) {
                return b1.cost - b2.cost;
            }
        });
        
        int result = 0;
        
        for (Bridge b : bridges) {
            int v1 = b.v1;
            int v2 = b.v2;
            int cost = b.cost;
            
            if (findParent(v1) != findParent(v2)) {
                unionParent(v1, v2);
                result += cost;
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
    
    class Bridge {
        int v1;
        int v2;
        int cost;
        
        public Bridge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
    }
}