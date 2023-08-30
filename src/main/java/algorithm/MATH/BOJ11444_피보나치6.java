package algorithm.MATH;

import java.util.Scanner;
// TODO :: 다시 풀어보기
public class BOJ11444_피보나치6 {
    static final long[][] A = new long[][]{{1, 1}, {1, 0}};
    static final long INF = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(fibo(n - 1)[0][0]);
    }

    private static long[][] fibo(long n) {
        if (n == 0 || n == 1) {
            return A;
        }
        long[][] divided = fibo(n / 2);
        divided = mxMulti(divided, divided);
        if (n % 2 != 0) {
            divided = mxMulti(divided, A);
        }
        return divided;
    }

    private static long[][] mxMulti(long[][] a, long[][] b) {
        long[][] result = new long[2][2];
        result[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % INF;
        result[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % INF;
        result[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % INF;
        result[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % INF;
        return result;
    }
}
