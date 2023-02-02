package algorithm.DP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ9461_파도반수열 {
    public BOJ9461_파도반수열() {
        List<Long> sequence = new ArrayList<>(List.of(1L, 1L, 1L, 2L, 2L, 3L, 4L, 5L, 7L, 9L));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            makeExtraSequence(sequence, N);
            System.out.println(sequence.get(N - 1));
        }

    }

    private static void makeExtraSequence(List<Long> sequence, int N) {
        for (int i = 2; i < N; i++) {
            if (i >= sequence.size()) {
                sequence.add(sequence.get(i - 2) + sequence.get(i - 3));
            }
        }
    }
}
