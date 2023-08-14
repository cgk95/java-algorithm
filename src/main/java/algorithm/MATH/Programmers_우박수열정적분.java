package algorithm.MATH;

import java.util.ArrayList;

public class Programmers_우박수열정적분 {
    public double[] solution(int k, int[][] ranges) {
        ArrayList<Integer> fx = new ArrayList<>();
        double[] answer = new double[ranges.length];
        fx.add(k);
        while (k != 1) {
            if (k % 2 == 0) {
                k /= 2;
                fx.add(k);
                continue;
            }
            k = k * 3 + 1;
            fx.add(k);
        }

        double[] integrals = new double[fx.size()];
        makeCumulativeSum(fx, integrals);
        makeAnswer(ranges, fx, answer, integrals);

        return answer;
    }

    private static void makeAnswer(int[][] ranges, ArrayList<Integer> fx, double[] answer, double[] integrals) {
        for (int i = 0; i < ranges.length; i++) {
            int a = ranges[i][0];
            int b = ranges[i][1];
            if (b <= 0) {
                b = fx.size() + b;
            }
            if (a >= b) {
                answer[i] = -1;
                continue;
            }
            answer[i] = integrals[b - 1] - integrals[a];
        }
    }

    private static void makeCumulativeSum(ArrayList<Integer> fx, double[] integrals) {
        for (int x = 1; x < fx.size(); x++) {
            int dy = fx.get(x) - fx.get(x - 1);
            int b = fx.get(x) - dy * x;
            double fst = (dy / 2.0d * x + b) * x;
            double snd = (dy / 2.0d * (x - 1) + b) * (x - 1);
            double sum = fst - snd;
            integrals[x] = sum;
        }
        for (int i = 1; i < integrals.length; i++) {
            integrals[i] = integrals[i] + integrals[i - 1];
        }
    }
}
