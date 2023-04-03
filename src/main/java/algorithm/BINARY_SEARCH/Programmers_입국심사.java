package algorithm.BINARY_SEARCH;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Programmers_입국심사 {
    public long solution(int n, int[] times) {
        long answer = 0;
        PriorityQueue<int[]> officer = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int t = 0; t < times.length; t++) {
            officer.offer(new int[]{times[t], t});
            n--;
        }
        while (!officer.isEmpty() && n > 0) {
            int[] curr = officer.poll();
            n--;
            answer += curr[0]; // 시간 지난거 입력
            updateTime(officer, curr);

            int check = checkBetterChoice(times, officer, curr);
            if (check != -1 && !officer.isEmpty()) {
                int[] tmp = officer.poll();
                n--;
                answer += tmp[0];
                updateTime(officer, tmp);
                officer.offer(new int[]{times[tmp[1]], tmp[1]});
            } else {
                officer.offer(new int[]{times[curr[1]], curr[1]});
            }
        }
        while (!officer.isEmpty()) {
            answer += officer.poll()[0];
        }
        return answer;
    }

    /**
     * 시간 업데이트
     **/
    private static void updateTime(PriorityQueue<int[]> officer, int[] tmp) {
        officer.forEach(x -> {
            x[0] -= tmp[0];
        });
    }

    /**
     * 꺼낸 자리가 비었으니까 바로 들어가는 것이 아니라, 지금 심사 중인 자리 중, 남은 시간 + 그 자리에서 심사시간이
     * 내가 지금 들어가야할 자리에서 보낼 시간보다 짧으면 그자리에 기다려서 들어가야
     **/
    private static int checkBetterChoice(int[] times, PriorityQueue<int[]> officer, int[] curr) {
        int tmp = -1; //arr[0]+ times[arr[1]]< times[curr[1]]
        for (int[] arr : officer) {
            if (arr[0] + times[arr[1]] < times[curr[1]]) {
                return arr[1];
            }
        }

        return tmp;
    }

    public static void main(String[] args) {
        Programmers_입국심사 sol = new Programmers_입국심사();
        System.out.println(sol.solution(6, new int[]{7, 10}));
    }
}
