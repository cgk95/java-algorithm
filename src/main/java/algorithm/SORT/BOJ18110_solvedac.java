package algorithm.SORT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BOJ18110_solvedac {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> scores = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        int M = Math.round(N * 0.15f);
        if (N == 0) {
            System.out.println(0);
            return;
        }

        setSortedArray(br, scores, N);
        br.close();

        while (M > 0) {
            scores.pollFirst();
            scores.pollLast();
            M--;
        }
        System.out.println(Math.round(scores.stream()
                .reduce(Integer::sum)
                .orElseThrow() / (1f * scores.size())
        ));
    }

    private static void setSortedArray(BufferedReader br, LinkedList<Integer> scores, int N) throws IOException {
        int[] table = new int[(int) (3 * Math.pow(10, 5) + 1)];
        for (int i = 0; i < N; i++) {
            table[Integer.parseInt(br.readLine())]++;
        }
        for (int i = 0; i < table.length; i++) {
            while (table[i] > 0) {
                scores.add(i);
                table[i]--;
            }
        }
    }
}
