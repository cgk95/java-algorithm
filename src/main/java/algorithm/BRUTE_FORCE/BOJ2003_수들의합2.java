package algorithm.BRUTE_FORCE;

import java.util.Scanner;

public class BOJ2003_수들의합2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int start = 0, end = 0, answer = 0, rangeSum = 0;
        while (start < N) {
            if (rangeSum > M || end == N) { // 목표치보다 크거나 end 포인트가 범위를 벗어났다면
                rangeSum -= arr[start++];
            } else {
                rangeSum += arr[end++];
            }
            if (rangeSum == M) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
