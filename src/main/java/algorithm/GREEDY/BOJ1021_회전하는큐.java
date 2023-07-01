package algorithm.GREEDY;

import algorithm.Application;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ1021_회전하는큐 implements Application {
    static Scanner sc = new Scanner(System.in);
    static LinkedList<Integer> q; // Queue<Integer> q=new LinkedList<>() 와  Queue<Integer> q=new Queue<>(), 그리고 LinkedList<> q=new LinkedList<>(); 의 차이점?
    static int[] seq;
    static int countOp2 = 0;
    static int countOp3 = 0;

    public static void main(String[] args) {
        // N,M 입력 받아서 저장
        int[] NM = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = NM[0];
        // 시작위치를 자기 값으로 가진 양방향 큐 생성
        q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            q.add(i + 1);
        }
        // 뽑아내려는 수의 위치를 입력받아 IntStream으로 기록
        seq = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        // 연산 시작
        int j = 0;
        while (j < seq.length) {
            int idxNumber = seq[j];
            if (!q.isEmpty()) {
                if (q.peek() == idxNumber) { // 뽑고자 하는 위치와 현재 HEAD가 같으면
                    operation1st();
                    j++;            // 다음 순서의 뽑고자 하는 숫자로 이동
                } else {            // 뽑고자 하는 위치와 현재 HEAD가 다르면
                    if (q.indexOf(idxNumber) > q.size() - q.indexOf(idxNumber)) {  // 왼쪽으로 움직여 빼는 횟수보다 오른쪽으로 움직여 빼는 횟수가 적으면
                        operation3rd();
                    } else {
                        operation2nd();
                    }
                }
            }
        }
        System.out.println(countOp2 + countOp3);
    }

    static private void operation1st() {
        q.poll();
    }

    static private void operation2nd() {
        q.add(q.poll());
        countOp2++;
    }

    static private void operation3rd() {
        q.addFirst(q.pollLast());
        countOp3++;
    }
}
