package algorithm.IMPLEMENT;

public class Programmers_마을판사 {
    public int solution(int N, int[][] trust) {
        int[] isNormalPerson = new int[N + 1];
        for (int[] arr : trust) {
            int a = arr[0];
            int b = arr[1];
            isNormalPerson[a] = -1; // 일반임임
            if (isNormalPerson[b] != -1) { // 아무도 안 믿는 새끼인 경우만
                isNormalPerson[b]++;
            }
        }
        for (int i = 1; i < isNormalPerson.length; i++) {
            if (isNormalPerson[i] == N - 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Programmers_마을판사 sol = new Programmers_마을판사();
        System.out.println(sol.solution(4, new int[][]{{1, 2}, {1, 4}, {1, 3}, {2, 1}, {4, 3}}));
        System.out.println(sol.solution(3, new int[][]{{1, 3}, {2, 3}}));
    }
}
