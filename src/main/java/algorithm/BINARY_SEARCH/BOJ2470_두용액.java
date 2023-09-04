package algorithm.BINARY_SEARCH;

import java.io.*;
import java.util.Arrays;

public class BOJ2470_두용액 {
    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static long[] answer = new long[2];

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        long[] values = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .sorted()
                .toArray();
        br.close();
        //-- 탐색 --//
        search(values);
        //-- 출력 --//
        bw.write(answer[0] + " ");
        bw.write(String.valueOf(answer[1]));
        bw.flush();
        bw.close();
    }

    private static void search(long[] values) {
        int start = 0;
        int end = N - 1;
        long min = Long.MAX_VALUE;
        while (start < end) {
            long sum = values[start] + values[end];
            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                answer[0] = values[start];
                answer[1] = values[end];

                if (sum == 0) {
                    break;
                }
            }
            if (sum < 0) {
                start++;
            } else {
                end--;
            }
        }
    }
}
