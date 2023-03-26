package algorithm.BRUTE_FORCE;

import java.util.Arrays;

public class Programmers_주변평균 {
    public int[][] solution(int[][] image, int K) {
        int[][] answer = new int[image.length][image[0].length];
        int range = (K - 1) / 2;
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                int rangeSum = 0;
                for (int x = i - range; x <= i + range; x++) {
                    for (int y = j - range; y <= j + range; y++) {
                        if (0 <= x && x < image.length && 0 <= y && y < image[i].length) {
                            rangeSum += image[x][y];
                        }
                    }
                }
                answer[i][j] = rangeSum / (K * K);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Programmers_주변평균 sol = new Programmers_주변평균();
        System.out.println(Arrays.deepToString(sol.solution(new int[][]{{4, 5, 2, 6, 7}, {5, 4, 2, 4, 6}, {6, 8, 4, 8, 7}, {7, 3, 6, 6, 4}, {5, 0, 4, 1, 5}}, 3)));
    }
}
