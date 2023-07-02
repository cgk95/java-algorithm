package algorithm.TWO_POINTER;

import java.util.ArrayList;
import java.util.Comparator;

public class Programmers_연속된부분수열의합 {
    public int[] solution(int[] sequence, int k) {
        ArrayList<int[]> answer = new ArrayList<>();
        int left = 0, right = 0, rangeSum = sequence[left];
        while (left <= right) {
            if (rangeSum == k) {
                answer.add(new int[]{left, right});
                if (right + 1 == sequence.length) {
                    break;
                }
                rangeSum += sequence[++right];
            } else if (rangeSum > k) {
                rangeSum -= sequence[left];
                left++;
            } else {
                if (right + 1 == sequence.length) {
                    break;
                }
                rangeSum += sequence[++right];
            }
        }
        answer.sort(Comparator.comparingInt(o -> o[1] - o[0]));
        return answer.get(0);
    }

    public int sumOfSubsequence(int[] sequence, int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += sequence[k];
        }
        return sum;
    }
}
