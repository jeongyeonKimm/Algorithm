import java.util.*;

class Solution {
    
    private Set<String> combinations;   // 가능한 속성 조합
    private int n, m;
    private boolean[] visited;
    private List<String> candidateKeys; // 후보키
    
    public int solution(String[][] relation) {
        n = relation.length;    // 튜플 개수
        m = relation[0].length; // 속성 개수
        
        combinations = new HashSet<>();
        candidateKeys = new ArrayList<>();
        
        for (int i = 1; i <= m; i++) {
            visited = new boolean[m];
            makeCombination(0, i);  // i개의 속성을 가지는 조합 만들기
            findCandidateKey(relation);    // i개의 속성을 가지는 조합 중 후보키 찾기
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
    
    private void findCandidateKey(String[][] relation) {
        for (String s : combinations) {
            String[] attributes = s.split("");
            
            Set<String> set = new HashSet<>();  // 유일성을 만족하는지 확인하기 위한 집합(set은 중복 X)
            for (int i = 0; i < n; i++) {
                String tmp = "";
                for (String a : attributes) {
                    int idx = Integer.parseInt(a);
                    tmp += relation[i][idx];
                }

                set.add(tmp);
            }

            if (set.size() == n) {  // 집합 크기가 튜플 수와 같으면 유일성을 만족하는 경우 -> 최소성 확인
                boolean flag = false;
                for (String c : candidateKeys) {
                    String[] tmp = c.split("");
                    int count = 0;
                    for (String t : tmp) {
                        if (s.contains(t)) {
                            count++;
                        }
                    }
                    
                    if (count == tmp.length) {  // 확인할 s라는 조합에서 이미 후보키라고 판단한 조합이 들어 있으면 후보키가 될 수 X
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