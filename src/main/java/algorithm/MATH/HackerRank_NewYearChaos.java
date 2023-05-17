package algorithm.MATH;

import java.util.ArrayList;
import java.util.List;

public class HackerRank_NewYearChaos {
    public static void minimumBribes(List<Integer> q) {
        int sum = 0;
        for (int i = q.size() - 1; i >= 0; i--) {
            int numberOfBribes = q.get(i) - (i + 1);
            if (numberOfBribes > 2) {
                System.out.println("Too chaotic");
                return;
            } else {
                int start = Math.max(0, q.get(i) - 2);
                for (int j = start; j < i; j++) {
                    if (q.get(j) > q.get(i)) {
                        sum++;
                    }
                }
            }
            sum += numberOfBribes;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        minimumBribes(new ArrayList<>(List.of(1, 2, 5, 3, 7, 8, 6, 4)));
        //                                          5  3  7  8  4  6
    }
}
