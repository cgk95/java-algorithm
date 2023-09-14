package algorithm.IMPLEMENT;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
// TODO :: 다시 풀어보기
public class BOJ2448_별찍기11 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char[][] stars;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        stars = new char[N][N * 2 - 1];
        for (int r = 0; r < N; r++) {
            Arrays.fill(stars[r], ' ');
        }
        makeStar(0, N - 1, N);

        for (char[] star : stars) {
            bw.write(star);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    private static void makeStar(int r, int c, int N) {
        if (N == 3) {
            stars[r][c] = '*';
            stars[r + 1][c - 1] = stars[r + 1][c + 1] = '*';
            stars[r + 2][c - 2] = stars[r + 2][c - 1] = stars[r + 2][c] = stars[r + 2][c + 1] = stars[r + 2][c + 2] = '*';
            return;
        }
        int divide = N / 2;
        makeStar(r, c, divide);
        makeStar(r + divide, c - divide, divide); // 왼쪽 아래
        makeStar(r + divide, c + divide, divide); // 오른쪽 아래

    }
}
