import java.util.stream.IntStream;

class Solution {
    public int[] solution(int start_num, int end_num) {
        return IntStream.rangeClosed(-start_num, -end_num)
            .map(i -> -i)
            .toArray();
    }
}