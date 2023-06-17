package algorithm.MATH;

import java.util.Scanner;
// 모듈러 연산의 분배법칙을 이용한 분할정복으로 풀이
// TODO :: 다시 풀어보기
public class BOJ1629_곱셈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();
        long c = sc.nextInt();
        sc.close();
        System.out.println(calculate(a, b, c));
    }

    private static long calculate(long a, long b, long mod) {
        long answer = 1;
        while (b > 0) {
            if (b % 2 == 1) {
                answer = (answer * a) % mod;
            }
            a = ((a % mod) * (a % mod)) % mod;
            b /= 2;
        }
        return answer;
    }
}
