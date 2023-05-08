package algorithm.TODO;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Programmers_숯불구이 {
    public int solution(int[] amount, int[] value, int[] stomach) {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (int i = 0; i < amount.length; i++) {
            pq.offer(new int[]{amount[i], value[i]});
        }
        int[] mostValuableMeat = pq.poll();
        int mvmAmount = mostValuableMeat[0];
        answer += mostValuableMeat[1] * (mvmAmount / stomach.length) * stomach.length;
        if (mvmAmount / stomach.length > 0 && Arrays.stream(stomach).noneMatch(p -> p == 0)) {
            for (int i = 0; i < stomach.length; i++) {
                stomach[i] -= (mvmAmount / stomach.length); // 제일 비싼 고기 나눠 먹기
            }
        }
        int[] stomachList = Arrays.stream(stomach).boxed().sorted((o1, o2) -> o2 - o1).mapToInt(Integer::intValue).toArray();
        while (!pq.isEmpty()) {
            int[] currMVM = pq.poll();
            for (int i = 0; i < stomachList.length; i++) {
                if (currMVM[0] == 0) {
                    break;
                }
                if (stomachList[i] == 0) {
                    continue;
                }
                if (currMVM[0] >= stomachList[i] && stomachList[i] != 0) {
                    currMVM[0] -= stomachList[i];
                    answer += stomachList[i] * currMVM[1];
                    stomachList[i]=0;
                } else {
                    stomachList[i] -= currMVM[i];
                    answer += currMVM[i] * currMVM[1];
                    currMVM[0]=0;
                }
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        Programmers_숯불구이 sol = new Programmers_숯불구이();
        System.out.println(sol.solution(new int[]{7, 10, 4, 5}, new int[]{5, 4, 3, 1}, new int[]{4, 6, 2, 8}));
    }
}
