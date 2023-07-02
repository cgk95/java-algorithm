package algorithm.GRAPH.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ12851_숨바꼭질2 {
    static final int INF = 100_000;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer nk = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(nk.nextToken());
            int K = Integer.parseInt(nk.nextToken());

            int[] road = new int[INF + 1];
            int[] visited = new int[INF + 1];
            ArrayDeque<Integer> deq = new ArrayDeque<>();
            int answerCount = 0;
            int answer = INF * 2;
            deq.offer(N);
            visited[N]++;
            while (!deq.isEmpty()) {
                int curr = deq.poll();
                if (curr == K) {
                    if (answerCount < 1) {
                        answer = Math.min(answer, road[curr]);
                        answerCount++;
                    } else if (answer < road[curr]) {
                        break;
                    } else {
                        answerCount++;
                    }
                }
                if (curr * 2 <= INF && (visited[curr * 2] < 1 || road[curr * 2] >= road[curr] + 1)) {
                    deq.offer(curr * 2);
                    visited[curr * 2]++;
                    road[curr * 2] = road[curr] + 1;
                }
                if (curr + 1 <= INF && (visited[curr + 1] < 1 || road[curr + 1] >= road[curr] + 1)) {
                    deq.offer(curr + 1);
                    visited[curr + 1]++;
                    road[curr + 1] = road[curr] + 1;
                }
                if (curr - 1 >= 0 && (visited[curr - 1] < 1 || road[curr - 1] >= road[curr] + 1)) {
                    deq.offer(curr - 1);
                    visited[curr - 1]++;
                    road[curr - 1] = road[curr] + 1;
                }

            }
            System.out.println(answer);
            System.out.println(answerCount);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
