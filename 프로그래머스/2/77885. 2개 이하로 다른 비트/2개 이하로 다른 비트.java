class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            } else {
                String target = Long.toBinaryString(numbers[i]);
                int index = target.lastIndexOf("0");
                if (index == -1) {
                    answer[i] = Long.parseLong("10" + target.substring(1), 2);
                } else {
                    answer[i] = Long.parseLong(target.substring(0, index) + "10" + target.substring(index + 2), 2);
                }
            }
        }
        
        return answer;
    }
}