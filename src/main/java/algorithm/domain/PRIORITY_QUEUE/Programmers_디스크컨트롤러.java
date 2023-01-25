package algorithm.domain.PRIORITY_QUEUE;
import algorithm.Application;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Programmers_디스크컨트롤러 implements Application {
    static int timeStamp;
    static int answer;
    static int totalTime;
    public static void main(String[] args){
        System.out.println(solution(new int[][] {{0,3},{1,9},{2,6}}));
        System.out.println(solution(new int[][] {{1,4},{7,9},{1000,3}}));
    }
    public static int solution(int[][] jobs) {
        timeStamp=0;
        answer=0;
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[]
                }
            }
        });
        System.out.println();
        PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(timeStamp>=o1[0] && timeStamp>=o2[0]){
                    return o1[1]-o2[1];
                }
                if (o1[0] == o2[0]) {
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        totalTime=0;
        for (int[] arr : jobs) {
            totalTime+= Arrays.stream(arr).sum();
        }
        while (timeStamp < totalTime) {
            for (int[] arr : jobs) {
                if (arr[0] <= timeStamp) { // 큐에 집어넣은건 삭제해야함, 도착시간을 무한대로 맞춰서 삭제하는 것처럼 만들거임
                    queue.add(arr.clone()); // 복사해서 넣지 않으면 주소값을 넘겨주기 때문에 MaxValue가 전달됨
                    arr[0]=Integer.MAX_VALUE;
                }
            }
            if (!queue.isEmpty()) {
                int[] curr=queue.poll();
                answer += (timeStamp-curr[0])+curr[1]; // 기다린 시간(작업시작시간-도착한시간) + 작업시간
                timeStamp+=curr[1];
            } else{
                timeStamp++;
            }
        }
        return answer/3;
    }
}
