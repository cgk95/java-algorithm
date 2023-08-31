package algorithm.BINARY_SEARCH;

import java.io.*;
import java.util.Arrays;

public class BOJ2512_예산 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] requests = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int M = Integer.parseInt(br.readLine());
        br.close();

        int low = 0;
        int high = Arrays.stream(requests).max().orElseThrow();
        int sum = -1;
        int answer = -1;
        while (low - 1 < high) {
            int mid = (low + high) / 2;
            int rangeSum = 0;
            for (int budget : requests) {
                rangeSum += Math.min(budget, mid);
            }
            if (rangeSum <= M) { // 합이 총예산보다 작으면서
                if (sum < rangeSum) { // 가질 수 있는 최댓값을 저장하기
                    sum = rangeSum;
                    answer = mid; // 그 최댓값의 상한액을 저장
                }
                low = mid + 1;

            } else {
                high = mid - 1;
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
