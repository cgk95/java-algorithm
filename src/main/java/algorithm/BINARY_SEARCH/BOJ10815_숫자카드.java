package algorithm.BINARY_SEARCH;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ10815_숫자카드 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<Integer> answer;

    public static void main(String[] args) throws IOException {
        answer = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(numbers);

        int m = Integer.parseInt(br.readLine());
        int[] targets = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        br.close();
        //-- 탐색 --//
        for (int i = 0; i < m; i++) {
            int low = 0;
            int high = n - 1;
            boolean isCorrect = false;
            while (low - 1 < high) {
                int mid = (low + high) / 2;
                if (numbers[mid] == targets[i]) {
                    answer.add(1);
                    isCorrect = true;
                    break;
                } else if (numbers[mid] < targets[i]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            if (isCorrect) {
                continue;
            }
            answer.add(0);
        }
        //-- 출력 --//
        for (int num : answer) {
            bw.write(num + " ");
        }
        bw.flush();
        bw.close();
    }
}
