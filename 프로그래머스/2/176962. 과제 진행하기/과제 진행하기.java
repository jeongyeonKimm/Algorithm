import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        PriorityQueue<Homework> pq = new PriorityQueue<>(Comparator.comparing(h -> h.start));
        
        for (int i = 0; i < plans.length; i++) {
            String name = plans[i][0];
            
            String[] splitted = plans[i][1].split(":");
            int hour = Integer.parseInt(splitted[0]);
            int minute = Integer.parseInt(splitted[1]);
            int start = hour * 60 + minute;
            
            int playtime = Integer.parseInt(plans[i][2]);
            
            pq.add(new Homework(name, start, playtime));
        }
        
        Stack<Homework> pausedHomeworks = new Stack<>();
        ArrayList<String> answer = new ArrayList<>();
        
        while (!pq.isEmpty()) {
            Homework h = pq.poll();
            
            String curName = h.name;
            int curTime = h.start;
            int curPlaytime = h.playtime;
            
            if (!pq.isEmpty()) {
                Homework next = pq.peek();
                
                if (curTime + curPlaytime > next.start) {
                    int time = next.start - curTime;
                    pausedHomeworks.add(new Homework(curName, curPlaytime - time));
                } else if (curTime + curPlaytime == next.start) {
                    answer.add(curName);
                } else {
                    answer.add(curName);
                    curTime += curPlaytime;
                    
                    while (!pausedHomeworks.isEmpty()) {
                        Homework p = pausedHomeworks.pop();
                        
                        if (curTime + p.playtime <= next.start) {
                            curTime += p.playtime;
                            answer.add(p.name);
                        } else {
                            int time = next.start - curTime;
                            pausedHomeworks.push(new Homework(p.name, p.playtime - time));
                            break;
                        }
                    }
                }
            } else {
                if (pausedHomeworks.isEmpty()) {
                    curTime += curPlaytime;
                    answer.add(h.name);
                } else {
                    answer.add(h.name);
                    
                    while (!pausedHomeworks.isEmpty()) {
                        Homework p = pausedHomeworks.pop();
                        answer.add(p.name);
                    }
                }
            }
        }
        
        return answer.toArray(new String[answer.size()]);
    }
    
    class Homework {
        
        String name;
        int start;
        int playtime;
        
        public Homework(String name, int start, int playtime) {
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
        
        public Homework(String name, int playtime) {
            this.name = name;
            this.playtime = playtime;
        }
    }
}