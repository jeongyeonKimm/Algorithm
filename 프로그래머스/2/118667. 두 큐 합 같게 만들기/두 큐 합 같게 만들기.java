import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long sum1 = 0;
        long sum2 = 0;
        
        for (int i = 0; i < queue1.length; i++) {
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
            sum1 += (long) queue1[i];
            sum2 += (long) queue2[i];
        }
        
        int count = 0;
        int num;
        
        while (sum1 != sum2) {
            if (count > (q1.size() + q2.size()) * 2) {
                break;
            }
            
            if (sum1 > sum2) {
                num = q1.poll();
                sum1 -= (long) num;
                q2.offer(num);
                sum2 += (long) num;
                count++;
            } else if (sum1 < sum2) {
                num = q2.poll();
                sum2 -= (long) num;
                q1.offer(num);
                sum1 += (long) num;
                count++;
            }
        }
        
        if (sum1 == sum2) return count;
        else return -1;
    }
}