package algorithm.HASH;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Programmers_귤고르기 {
    public int solution(int K, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o2[1] == o1[1]) {
                return o2[0] - o1[0];
            }
            return o2[1] - o1[1];
        });
        int answer = 0;

        for (int n : tangerine) {
            map.computeIfPresent(n, (k, v) -> v + 1);
            map.putIfAbsent(n, 1);
        }
        map.forEach((k, v) -> pq.offer(new int[]{k, v}));

        while (K > 0 && !pq.isEmpty()) {
            int curr = pq.poll()[1];
            K -= curr;
            answer++;
        }
        return answer;
    }


    public static void main(String[] args) {
        Programmers_귤고르기 sol = new Programmers_귤고르기();
        System.out.println(sol.solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(sol.solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
    }
}
