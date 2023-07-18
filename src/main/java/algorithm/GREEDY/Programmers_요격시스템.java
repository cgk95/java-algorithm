package algorithm.GREEDY;

import java.util.Arrays;
import java.util.Comparator;

public class Programmers_요격시스템 {
    public int solution(int[][] targets) {
        int answer = 0;
        double flag = -1d;
        Arrays.sort(targets, Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < targets.length; i++) {
            if (flag < targets[i][0]) { // 하나의 미사일로 요격하지 못한다면 :: 겹치지 않는다면
                answer++;
                flag = targets[i][1] - 0.1;
            }
            flag = Math.min(flag, targets[i][1] - 0.1);
        }
        return answer;
    }

}
