package algorithm.MATH;

import java.util.List;

public class HackeRank_FlippingTheMatrix {
    public static int flippingMatrix(List<List<Integer>> matrix) {
        int len = matrix.size();
        int sum = 0;
        for (int i = 0; i < len / 2; i++) {
            for (int j = 0; j < len / 2; j++) {
                sum += Math.max(matrix.get(i).get(j),
                        Math.max(matrix.get(i).get(len - 1 - j), Math.max(matrix.get(len - 1 - i).get(j), matrix.get(len - 1 - i).get(len - 1 - j))));
            }
        }
        return sum;
    }
}
