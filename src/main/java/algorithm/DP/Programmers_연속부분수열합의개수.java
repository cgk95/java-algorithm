package algorithm.DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Programmers_연속부분수열합의개수 { // 입력이 커지면 dp로 풀어야 한다...
    List<Integer> answerList = new ArrayList<>();

    public int solution(int[] elements) {
        int len = elements.length;
        List<Integer> target = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            for (int n : elements) {
                target.add(n);
            }
        }
        checkRangeSum(target, len);
        Set<Integer> set = new HashSet<>(answerList);
        return set.size();
    }

    private void checkRangeSum(List<Integer> list, int len) {
        for (int i = 0; i < len; i++) {
            int rangeSum = list.get(i);
            answerList.add(rangeSum);
            for (int j = i + 1; j < i + len; j++) {
                rangeSum += list.get(j);
                answerList.add(rangeSum);
            }
        }
    }

    public static void main(String[] args) {
        Programmers_연속부분수열합의개수 sol = new Programmers_연속부분수열합의개수();
        System.out.println(sol.solution(new int[]{7, 9, 1, 1, 4}));
    }
}
