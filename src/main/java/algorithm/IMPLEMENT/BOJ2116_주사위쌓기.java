package algorithm.IMPLEMENT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2116_주사위쌓기 {

    public BOJ2116_주사위쌓기() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer diceNumber = isdigit(br.readLine()); // 입력이 10^12를 넘어가는 범위면?
        int[][] dice = new int[diceNumber][6];
        int answer = Integer.MIN_VALUE;

        prepareDiceData(dice, br); // 주사위 입력받아서 준비

        for (int i = 0; i < 6; i++) { // 1번 주사위 면마다
            int bottom = dice[0][i];
            int top = dice[0][(i + 3) % 6];
            int sum = calculateMax(bottom, top);
            sum = getSumOfPossibleMaxValue(dice, bottom, top, sum);
            answer = Math.max(answer, sum);
        }
        System.out.println(answer);
    }

    private static int getSumOfPossibleMaxValue(int[][] dice, int bottom, int top, int sum) {
        for (int x = 1; x < dice.length; x++) { // 두번째 주사위 부터 마지막 주사위까지
            for (int y = 0; y < 6; y++) {
                if (dice[x][y] == top) {
                    bottom = dice[x][y];
                    top = dice[x][(y + 3) % 6];
                    break;
                }
            }
            sum += calculateMax(bottom, top);
        }
        return sum;
    }

    private static int calculateMax(int bottom, int top) {
        if (bottom + top == 11) {
            return 4;
        }
        if (bottom == 6 || top == 6) {
            return 5;
        }
        return 6;
    }

    private static void prepareDiceData(int[][] dice, BufferedReader br) throws IOException {
        for (int i = 0; i < dice.length; i++) {
            String[] input = br.readLine().split(" ");
            dice[i][0] = Integer.parseInt(input[0]);
            dice[i][1] = Integer.parseInt(input[1]);
            dice[i][2] = Integer.parseInt(input[2]);
            dice[i][3] = Integer.parseInt(input[5]);
            dice[i][4] = Integer.parseInt(input[3]);
            dice[i][5] = Integer.parseInt(input[4]);
        }
    }

    private static Integer isdigit(String diceNumber) {
        for (char c : diceNumber.toCharArray()) {
            if (48 > c || c > 57) {
                throw new IllegalArgumentException("[ERROR] 주사위의 개수는 양의 정수 하나여야 합니다.");
            }
        }
        return Integer.parseInt(diceNumber);
    }
}
