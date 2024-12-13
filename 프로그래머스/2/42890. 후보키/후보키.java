import java.util.*;

class Solution {
    
    private Set<String> combinations;
    private int n, m;
    private boolean[] visited;
    private List<String> candidateKeys;
    
    public int solution(String[][] relation) {
        n = relation.length;
        m = relation[0].length;
        
        combinations = new HashSet<>();
        candidateKeys = new ArrayList<>();
        
        for (int i = 1; i <= m; i++) {
            visited = new boolean[m];
            makeCombination(0, i);
            checkCandidateKey(relation);
        }
        
        return candidateKeys.size();
    }
    
    private void makeCombination(int depth, int size) {
        if (depth == size) {
            String num = "";
            for (int i = 0; i < m; i++) {
                if (visited[i]) {
                    num += i;
                }
            }
            combinations.add(num);
            return;
        }
        
        for (int i = 0; i < m; i++) {
            if (!visited[i]) {
                visited[i] = true;
                makeCombination(depth + 1, size);
                visited[i] = false;
            }
        }
    }
    
    private void checkCandidateKey(String[][] relation) {
        for (String s : combinations) {
            String[] attributes = s.split("");
            
            Set<String> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                String tmp = "";
                for (String a : attributes) {
                    int idx = Integer.parseInt(a);
                    tmp += relation[i][idx];
                }

                set.add(tmp);
            }

            if (set.size() == n) {
                boolean flag = false;
                for (String c : candidateKeys) {
                    String[] tmp = c.split("");
                    int count = 0;
                    for (String t : tmp) {
                        if (s.contains(t)) {
                            count++;
                        }
                    }
                    
                    if (count == tmp.length) {
                        flag = true;
                    }
                }
                
                if (!flag) {
                    candidateKeys.add(s);
                }
            }
        }
    }
}