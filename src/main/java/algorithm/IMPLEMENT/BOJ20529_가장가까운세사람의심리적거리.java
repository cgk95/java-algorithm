package algorithm.IMPLEMENT;

import java.util.Scanner;

public class BOJ20529_가장가까운세사람의심리적거리 {
    static int answer;
    static String[] input;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            sc.nextLine();
            input = sc.nextLine().split(" ");
            Solution(input, N);

        }
    }

    private static void Solution(String[] input, int N) {
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    int temp = 0;
                    temp += calculateDistance(input[i], input[j]) + calculateDistance(input[j], input[k]) + calculateDistance(input[k], input[i]);
                    answer = Math.min(answer, temp);
                    if (answer == 0) {
                        break;
                    }
                }
                if (answer == 0) {
                    break;
                }
            }
            if (answer == 0) {
                break;
            }
        }
        System.out.println(answer);
    }


    private static int calculateDistance(String person1, String person2) {
        int dist = 0;
        for (int i = 0; i < person1.length(); i++) {
            if (person1.charAt(i) != person2.charAt(i)) {
                dist++;
            }
        }
        return dist;
    }
}
