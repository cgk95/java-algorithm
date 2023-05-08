package algorithm.BINARY_SEARCH;

import java.util.Arrays;

public class Programmers_징검다리 {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int start=0;
        int end = distance;
        int mid;
        int answer=Integer.MIN_VALUE;
        // 바위를 제거하여 mid 값보다 작은 거리 사이에 바위가 없도록
        while (start <= end) {
            mid = (start + end)/2;
            int removedRock=0;
            int prevRock=0;
            for (int rock : rocks) {
                if (rock - prevRock < mid) { // mid 값보다 작은 거리 사이에 바위가 있으면
                    removedRock++;  // 해당 바위를 제거
                } else { // mid 값보다 큰 거리 사이에 바위가 있으면
                    prevRock=rock;  // 현재 바위를 이전 바위로 설정
                }
            }
            // 마지막 바위와 도착지점 사이의 거리를 체크
            if (distance - prevRock < mid) { // mid 값보다 작은 거리 사이에 바위가 있으면
                removedRock++; // 해당 바위를 제거
            }
            // 제거한 바위 수가 n보다 크거나 같으면 mid 값을 answer에 저장하고,
            // mid 값보다 작은 거리 사이에 바위가 너무 많이 남아있으면 mid 값 감소
            if (removedRock <= n) {
                answer = Math.max(answer, mid);
                start = mid + 1;
            } else {
                end=mid-1;
            }
        }
        return answer;
    }
}
