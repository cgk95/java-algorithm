package algorithm.BINARY_SEARCH;

public class Programmers_금과은 {
    public static long solution(int a, int b, int[] gold, int[] silver, int[] weight_limit, int[] t) {
        long max = 2L * 1_000_000_000 * 10_001 * 2;
        long min = 0L;

        // 특정 시간이 주어졌을 때, (a,b) 만큼 조달이 가능할까?
        while (min + 1 < max) {
            long mid = (max + min) / 2L;
            if (checkPossiblity(mid, a, b, gold, silver, weight_limit, t)) {
                max = mid;
                continue;
            }
            min = mid;
        }
        return max;
    }

    private static boolean checkPossiblity(long time, int a, int b, int[] gold, int[] silver, int[] weight_limit, int[] t) {
        int numberOfCities = gold.length;
        long total = 0L;
        long totalGold = 0L;
        long totalSilver = 0L;
        // 각 도시마다
        for (int i = 0; i < numberOfCities; i++) {
            long count = time / (2L * t[i]);   // 이동 가능한 최대 카운트
            if (time % (2L * t[i]) >= t[i]) { // 편도 이동이 한 번 더 가능한 경우엔 횟수 1 추가
                count++;
            }
            // 어찌 됐건 주어진 시간에 조달이 가능한지만 확인
            long availableAtMoment = Math.min(count * weight_limit[i], gold[i] + silver[i]);
            total += availableAtMoment;  // 최대 누적합
            totalGold += Math.min(availableAtMoment, gold[i]);   // 최대 금 누적합
            totalSilver += Math.min(availableAtMoment, silver[i]); // 최대 은 누적합
        }
        return total >= a + b && totalGold >= a && totalSilver >= b;
    }

    public static void main(String[] args) {
        System.out.println(Programmers_금과은
                .solution(10, 10, new int[]{100}, new int[]{100}, new int[]{7}, new int[]{10}));
        System.out.println(Programmers_금과은
                .solution(90, 500, new int[]{70, 70, 0}, new int[]{0, 0, 500}, new int[]{100, 100, 2}, new int[]{4, 8, 1}));
    }
}
