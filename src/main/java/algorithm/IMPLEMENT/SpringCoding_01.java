package algorithm.IMPLEMENT;

import java.util.Arrays;
import java.util.Objects;

public class SpringCoding_01 {
    /**
     * 당첨자 수에서 구매자 수를 뺀 것을 오름차순으로 정렬하고, 그 이후 당첨금액을 내림차순 정렬해야 한다.
     **/
    public int solution(int[][] lotteries) {
        int answer = 0;
        // 복권 정렬
        Double[] sortedLotteries = getSortedLotteries(lotteries);

        for (int i = 0; i < lotteries.length; i++) {
            if (Objects.equals(lotteries[i], sortedLotteries[0])) {
                answer = i + 1;
                break; // 더 순회할 필요 없으므로 시간을 아끼자 == 완전 동일한 복권은 하나만 존재한다고 전제함
            }
        }
        return answer;
    }

    private static Double[] getSortedLotteries(int[][] lotteries) {
        Double[] sortedLotteries = Arrays.stream(lotteries).sorted((o1, o2) -> {
            double a1 = o1[0] / (o1[1] + 1.0);
            double a2 = o2[0] / (o2[1] + 1.0);
            if (a1 >= 1.0 && a2 >= 1.0) { // 둘다 100퍼센트 당첨이면
                return o2[2] - o1[2];    // 당첨금으로 정렬
            }
            if (a1 == a2) {             // 당첨 확률이 서로 같을 경우
                return o2[2] - o1[2];   // 당첨금으로 정렬
            } else if (a1 > a2) {
                return -1;
            } else {
                return 1;
            }
        }).toArray(Double[]::new);
        return sortedLotteries;
    }
}
