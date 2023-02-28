package algorithm.IMPLEMENT;
import java.util.ArrayList;
import java.util.Arrays;
public class Programmers_나누어떨어지는숫자배열 {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int n : arr) {
            if (n % divisor == 0) {
                answer.add(n);
            }
        }
        answer.sort(Integer::compareTo);
        if (!answer.isEmpty()) {
            return Arrays.stream(answer.toArray())
                    .mapToInt(o->(int)o)
                    .toArray();
        }
        return new int[] {};
    }
}
