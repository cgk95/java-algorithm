package algorithm.GREEDY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class BOJ_11047 {
    public BOJ_11047() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> coin = new ArrayList<>();
        int answer = 0;
        int[] NK = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // N종류의 동전, 목표 가치의 합 K
        getCoins(br, coin, NK);
        coin.sort(Comparator.reverseOrder());
        answer = matchCoins(coin, answer, NK);
        System.out.println(answer);
    }

    private static void getCoins(BufferedReader br, List<Integer> coin, int[] NK) throws IOException {
        for (int i = 0; i < NK[0]; i++) {
            coin.add(Integer.parseInt(br.readLine())); // 동전 종류별 가치 입력
        }
    }

    private static int matchCoins(List<Integer> coin, int answer, int[] NK) {
        for (int i = 0; i < coin.size(); i++) {
            if (NK[1] / coin.get(i) != 0) {
                answer += NK[1] / coin.get(i);
                NK[1] = NK[1] % coin.get(i);
            }
        }
        return answer;
    }
}
