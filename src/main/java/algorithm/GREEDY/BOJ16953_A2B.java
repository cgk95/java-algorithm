package algorithm.GREEDY;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ16953_A2B { // 2를 곱하거나(2로 나누기) 오른쪽에 1을 더하는 연산 둘 중에 하나 골라야 함.(1을 빼고 10으로 나누기)
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        sc.close();
        // 연산
        Queue<Node> q = new LinkedList<>();
        boolean flag = false;
        q.offer(new Node(B, 0));
        while (!q.isEmpty() && q.peek().index >= A) {
            Node curr = q.poll();
            if (curr.index == A) {
                System.out.println(curr.minCount + 1);
                flag = true;
                break;
            }
            if ((curr.index - 1) % 10 == 0 && (curr.index - 1) / 10 >= A) {
                q.offer(new Node((curr.index - 1) / 10, curr.minCount + 1));
            }
            if (curr.index % 2 == 0 && curr.index / 2 >= A) {
                q.offer(new Node(curr.index / 2, curr.minCount + 1));
            }
        }
        if (!flag) {
            System.out.println(-1);
        }
    }

    private static class Node {
        int index;
        int minCount;

        public Node(int index, int minCount) {
            this.index = index;
            this.minCount = minCount;
        }
    }

}
