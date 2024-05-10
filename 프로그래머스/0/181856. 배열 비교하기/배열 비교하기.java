import java.util.stream.IntStream;

class Solution {
    public int solution(int[] arr1, int[] arr2) {
        if (arr1.length > arr2.length) return 1;
        else if (arr1.length < arr2.length) return -1;
        
        int sum1 = IntStream.of(arr1).sum();
        int sum2 = IntStream.of(arr2).sum();
        
        return (sum1 == sum2) ? 0 :
                (sum1 > sum2) ? 1 : -1;
    }
}