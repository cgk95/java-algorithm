package algorithm.BRUTE_FORCE;

import java.util.Arrays;

public class Programmers_행렬의곱셈 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                for (int k = 0; k < arr1[i].length; k++) { // arr1의 열 또는 arr2의 행
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Programmers_행렬의곱셈 sol = new Programmers_행렬의곱셈();
//        System.out.println(Arrays.deepToString(sol.solution(new int[][]{{2, 3, 2}, {4, 2, 4}, {3, 1, 4}}, new int[][]{{5, 4, 3}, {2, 4, 1}, {3, 1, 1}})));
        System.out.println(Arrays.deepToString(sol.solution(new int[][]{{1, 4}, {3, 2}, {4, 1}}, new int[][]{{3, 3}, {3, 3}})));
        System.out.println(Arrays.deepToString(sol.solution(new int[][]{{1, 2, 3}, {4, 5, 6}}, new int[][]{{1, 4}, {2, 5}, {3, 6}})));
    }

}
