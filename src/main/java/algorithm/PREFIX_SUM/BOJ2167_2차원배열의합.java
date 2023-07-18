package algorithm.PREFIX_SUM;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2167_2차원배열의합 {
    static int[][] array;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        array = new int[N][M];
        for (int i = 0; i < N; i++) {
            array[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int K = sc.nextInt();
        for (int k = 0; k < K; k++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            sc.nextLine();
            System.out.println(getCumulateiveSum(i, j, x, y));
        }
    }

    private static int getCumulateiveSum(int I, int J, int X, int Y) {
        int sum = 0;
        for (int i = I - 1; i < X; i++) {
            for (int j = J - 1; j < Y; j++) {
                sum += array[i][j];
            }
        }
        return sum;
    }
}
