package algorithm.Prefix_Sum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_11659 {
    private static final List<Integer> prepareSum = new ArrayList<>(List.of(0));

    public BOJ_11659() {
        Scanner sc = new Scanner(System.in);
        List<Integer> number = new ArrayList<>();


        int N = sc.nextInt();
        int M = sc.nextInt();
        getNumbers(sc, N, number);
        getRangeAndSum(sc, number, M);
    }

    private static void getRangeAndSum(Scanner sc, List<Integer> number, int M) {
        calculateRangeSum(number);
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            System.out.println(printRangeSum(number, start, end));
        }
    }

    private static int printRangeSum(List<Integer> number, int start, int end) {
        if (!(start == end)) {
            return prepareSum.get(end) - prepareSum.get(start - 1);
        }
        return number.get(end - 1);
    }

    private static void getNumbers(Scanner sc, int N, List<Integer> number) {
        for (int i = 0; i < N; i++) {
            number.add(sc.nextInt());
        }
    }

    private static void calculateRangeSum(List<Integer> number) {
        for (int i = 1; i <= number.size(); i++) {
            prepareSum.add(prepareSum.get(i - 1) + number.get(i - 1));
        }

    }

}
