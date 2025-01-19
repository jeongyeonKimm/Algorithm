import java.util.*;

class Solution {
    
    private List<String> routes;
    private boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        routes = new ArrayList<>();
        visited = new boolean[tickets.length];
        
        dfs(tickets, "ICN", "ICN", 0);
        
        Collections.sort(routes);
        
        return routes.get(0).split(" ");
    }
    
    private void dfs(String[][] tickets, String start, String route, int depth) {
        if (depth == tickets.length) {
            routes.add(route);
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && start.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(tickets, tickets[i][1], route + " " + tickets[i][1], depth + 1);
                visited[i] = false;
            }
        }
    }
}