package algorithm.domain;

import java.util.Scanner;

public class SWEA_1206 {
    private static final int T = 10;
    private static int N;
    private static int count = 0;
    static int[] height;

    public SWEA_1206() {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt(); // 건물의 개수
            getHeightOfBuilding(sc); // 건물 높이를 입력 받고
            for (int i = 2; i < N - 2; i++) {
                int left = getHighstLeft(i);
                int right = getHighstRight(i);
                compareHeight(i, left, right);
            }
            System.out.println("#"+test_case+" "+count);
            count = 0; // 카운트 필드를 초기화
        }
    }

    private static void compareHeight(int i, int left, int right) {
        if (left > 0 && right > 0) {
            int leftJomang = height[i] - height[left];
            int rightJomang = height[i] - height[right];
            if (leftJomang > 0 && rightJomang > 0) {
                compareJomangAndCount(leftJomang, rightJomang);
            }
        }
    }

    private static void compareJomangAndCount(int leftJomang, int rightJomang) {
        count += Math.min(leftJomang, rightJomang);
    }

    private static int getHighstRight(int i) {
        if (height[i + 1] >= height[i + 2]) {
            return i + 1;
        }
        return i + 2;
    }

    private static int getHighstLeft(int i) {
        if (height[i - 1] >= height[i - 2]) {
            return i - 1;
        }
        return i - 2;
    }

    private static void getHeightOfBuilding(Scanner sc) {
        height = new int[N];
        for (int i = 0; i < N; i++) {
            height[i] = sc.nextInt();
        }
    }
}