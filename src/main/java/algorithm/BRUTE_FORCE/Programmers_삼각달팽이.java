package algorithm.BRUTE_FORCE;

import java.util.ArrayList;
import java.util.Arrays;

public class Programmers_삼각달팽이 {
    int[][] snail;
    int[] answer;
    int num = 1;
    int[] dx = {1, 0, -1};
    int[] dy = {0, 1, -1};

    public int[] solution(int n) {
        setSnail(n);
        makeSnail();
        makeAnswerArray(n);
        return answer;
    }

    private void makeAnswerArray(int n) {
        ArrayList<Integer> tmp = new ArrayList<>();
        for (int[] floor : snail) {
            for (int num : floor) {
                tmp.add(num);
            }
        }
        answer = new int[size(n)];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = tmp.get(i);
        }
    }

    public int size(int n) {
        if (n == 1) {
            return 1;
        }
        return size(n - 1) + n;
    }

    private void setSnail(int n) {
        snail = new int[n][];
        for (int i = 0; i < snail.length; i++) {
            snail[i] = new int[i + 1];
        }
    }

    private void makeSnail() {
        int row = 0;
        int col = 0;
        snail[row][col] = num;
        while (checkVaild(row, col)) {
            while (row + 1 < snail.length && snail[row + 1][col] <= 0) {
                snail[++row][col] = ++num;
            }
            while (col + 1 < snail[row].length && snail[row][col + 1] <= 0) {
                snail[row][++col] = ++num;
            }
            while (snail[row - 1][col - 1] <= 0) { // 배열 범위 설정 안해도 어차피 알아서 범위 조절됨
                snail[--row][--col] = ++num;
            }
        }
    }

    public boolean checkVaild(int row, int col) {
        for (int k = 0; k < 3; k++) {
            int nr = row + dx[k];
            int nc = col + dy[k];
            if (0 <= nr && nr < snail.length && 0 <= nc && nc < snail[nr].length && snail[nr][nc] <= 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Programmers_삼각달팽이 sol = new Programmers_삼각달팽이();
        System.out.println(Arrays.toString(sol.solution(4)));

    }
}
