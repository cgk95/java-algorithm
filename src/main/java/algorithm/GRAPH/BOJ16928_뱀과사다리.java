package algorithm.GRAPH;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ16928_뱀과사다리 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        int[] board = new int[101];
        int[] dist = new int[101];
        Arrays.fill(dist, -1);
        // 사다리
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            sc.nextLine();
            board[x] = y;
        }
        // 뱀
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            sc.nextLine();
            board[x] = y;
        }
        // 연산 시작
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        dist[1] = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int i = 1; i <= 6; i++) {
                int next = curr + i;
                if (next > 100) {
                    continue;
                }
                if (board[next] != 0) { // 뱀이나 사다리 있으면
                    next = board[next];
                }
                if (dist[next] == -1) { // 첫 방문이면
                    dist[next] = dist[curr] + 1; // 주사위 횟수 +1
                    q.offer(next); // 이동
                }
            }
        }
        System.out.println(dist[100]);
    }

    // 이력서의 분량이 지나치게 길거나 너무 많은 첨부파일은 삼가기
    // 이력서와 코드 분리
    // 정량적인 어필 + 정성적인 어필
    /**
     * 연결성 -> 프로젝트간 연결성이 있고 같은 실수를 반복하지 않는가
     * <head>지원동기</head>
     * 이력서 하나로 돌려막는 느낌 주지 말기 -> 무조건 커스텀 해야해!!
     * 내 동기가 되는 나와 회사의 연결고리 만들고, 투자받은 기사내의 C레벨 인터뷰 앞으로의 미션과 계획, 회사 멤버들의 컨텐츠에서 힌트를 얻기
     * **/

}
