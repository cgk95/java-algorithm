package algorithm.TODO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Programmers_건물의실루엣 {
    public int[][] solution(int[][] buildings) {
        ArrayList<int[]> arrayList = new ArrayList<>();
        Arrays.sort(buildings, Comparator.comparingInt(o -> o[0]));
        arrayList.add(new int[]{buildings[0][0], buildings[0][2]}); // 시작점
        for (int i = 1; i < buildings.length - 1; i++) {
            if (buildings[i][0] < buildings[i - 1][0]) {

            }
        }
        return new int[][]{};
    }

    public static void main(String[] args) {
        Programmers_건물의실루엣 sol = new Programmers_건물의실루엣();
        System.out.println(Arrays.deepToString(sol.solution(new int[][]{{2, 4, 10}, {10, 12, 6}, {3, 5, 6}, {1, 8, 4}})));
        System.out.println(Arrays.deepToString(sol.solution(new int[][]{{1, 10, 2}, {2, 8, 4}, {3, 6, 10}, {4, 7, 11}})));
    }
}
