package algorithm.IMPLEMENT;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers_아메바 {
    public int solution(int delay, int N) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int count = 1;
        for (int i = 1; i <= N; i++) {
            Queue<Integer> newQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                int d = queue.remove();
                if (d == 0) {
                    newQueue.add(0);
                    newQueue.add(delay);
                    count += 2;
                } else {
                    newQueue.add(d - 1);
                }
            }
            queue = newQueue;
        }
        return count;
    }


    public static void main(String[] args) {
        Programmers_아메바 sol = new Programmers_아메바();
        System.out.println(sol.solution(1, 2));
    }
//    public int solution(int delay, int N) {
//        int answer = 0;
//        int[] dp = new int[N + 1];
//        int[] available = new int[N + 1];
//        Queue<int[]> resting = new LinkedList<>();
//        dp[0]=1; available[0]=1;
//        dp[1]=2; available[1]=1; resting.offer(new int[] {1,0});
//
//        for (int time = 1; time < N + 1; time++) {
//            for (int i = 0; i<resting.size(); i++) { // 상태 갱신
//                int[] temp=resting.poll();
//                temp[1]++;
//                resting.offer(temp);
//            }
//            while(!resting.isEmpty()){
//                if (resting.peek()[1] == delay) {
//                    available[time] += resting.poll()[0];
//                } else {
//                    break;
//                }
//            }
//            dp[time]=available[time]*2+dp[time-1]-available[time-1];
//        }
//        return dp[N];
//    }
}
