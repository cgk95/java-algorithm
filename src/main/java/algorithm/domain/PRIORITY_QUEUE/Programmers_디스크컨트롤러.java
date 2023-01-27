package algorithm.domain.PRIORITY_QUEUE;
import algorithm.Application;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Programmers_디스크컨트롤러 implements Application {
    static LinkedList<int[]> request;
    static PriorityQueue<int[]> q;
    static int timeStamp;
    static int answer;
    public static void main(String[] args){
        System.out.println(solution(new int[][] {{0,3},{1,9},{2,6}})); //9
        System.out.println(solution(new int[][]{{7, 8}, {3, 5}, {8, 6}})); // 8
        System.out.println(solution(new int[][]{{0, 10}, {4, 10}, {15, 2}, {5, 11}})); // 15 ; 태스크 하나 실행하고 작업목록을 다시 갱신하여야
        System.out.println(solution(new int[][]{{0, 9}, {0, 4}, {0, 5}, {0, 7}, {0, 3}})); // 13
    }
    /**
     * 디스크가 일하는 도중에 요청된 작업에 대해서는 작업시간 짧은 것-> 요청순서 우선,
     * 디스크가 일하지 않는 동안 요청된 작업은 먼저 들어온 요청을 우선
     * @param jobs 정렬되지 않은 입력
     * @return 소요시간의 평균을 리턴
     */
    public static int solution(int[][] jobs) {
        timeStamp=0; answer=0; // 스태틱 변수를 초기화
        Arrays.sort(jobs, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        }); // 정렬되지 않은 입력은 요청순서를 우선하여 정렬
        request=new LinkedList<>(Arrays.asList(jobs)); // 그리고 빼내기 쉽게 옮겨준다.
        
        q=new PriorityQueue<>(((o1, o2) -> {
            if (timeStamp >= o1[0] && timeStamp >= o2[0]) {
                return o1[1]-o2[1];
            }
            if (o1[0] == o2[0]) {
                return o1[1]-o2[1];
            }
            return o1[0]-o2[0];
        }));
        diskProcessing();
        return Math.floorDiv(answer,jobs.length);
    }

    private static void diskProcessing() {
        while(!request.isEmpty()) {
            int[] first = request.poll();
            q.add(first); // 첫 요청은 무조건 우선하여 처리하고
            timeStamp = first[0]; // 첫 시작시간 초기화
            int localAnswer = 0;  // 첫 소요시간 초기화
            localAnswer = getLocalAnswerOfRequestWhileProcessing(localAnswer);
            answer += localAnswer;
        }
    }

    private static int getLocalAnswerOfRequestWhileProcessing(int localAnswer) {
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            localAnswer += (timeStamp - curr[0]) + curr[1]; // 소요시간 추가
            timeStamp += curr[1]; // 시점 갱신
            while (!request.isEmpty() && request.peek()[0] <= timeStamp) { // 작업도중에 들어온 요청이라면 q에 추가
                q.add(request.poll());
            }
        }
        return localAnswer;
    }
}
