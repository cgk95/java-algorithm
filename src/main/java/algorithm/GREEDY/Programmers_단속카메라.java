package algorithm.GREEDY;

import java.util.Arrays;

public class Programmers_단속카메라 {
    public int solution(int[][] routes) {
        int answer = 1;
        for (int[] arr : routes) { // 역주행하는 미친놈 제대로 뒤집기
            Arrays.sort(arr);
        }
        Arrays.sort(routes, (o1, o2) -> o1[0] - o2[0]);
        int[] curr = routes[0];
        for (int i = 1; i < routes.length; i++) {
            if (curr[0] <= routes[i][0] && routes[i][0] <= curr[1]) { // 겹치는 부분 존재 시
                curr = new int[]{routes[i][0], routes[i - 1][1]}; // 업데이트
                if (routes[i][1] <= curr[1]) { // 완전한 부분 집합인경우
                    curr[1] = routes[i][1]; // 땡기기
                }
            } else {
                answer++;
                curr = routes[i];
            }
        }
        return answer;
    }
}
