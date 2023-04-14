package algorithm.GREEDY;

import java.util.Arrays;

public class Programmers_단속카메라 {
    public int solution(int[][] routes) {
        int answer = 0, flag = -30001;
        for (int[] arr : routes) { // 역주행하는 미친놈 제대로 뒤집기
            Arrays.sort(arr);
        }
        Arrays.sort(routes, (o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < routes.length; i++) {
            if (flag < routes[i][0]) { // 겹치지 않으면
                answer++;
                flag = routes[i][1];
            }
            flag = Math.min(flag, routes[i][1]);
        }
        return answer;
    }
}
