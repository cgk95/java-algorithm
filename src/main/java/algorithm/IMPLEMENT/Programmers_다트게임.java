package algorithm.IMPLEMENT;

import java.util.Arrays;

public class Programmers_다트게임 {
    public int solution(String dartResult) {
        StringBuilder sb = new StringBuilder();
        int[] score = new int[3];
        int count = 0;
        for (char c : dartResult.toCharArray()) {
            if (c == '*') {
                if (count > 1) {
                    score[count - 2] *= 2;
                    score[count - 1] *= 2;
                } else {
                    score[count - 1] *= 2;
                }
            } else if (c == '#') {
                score[count - 1] *= -1;
            } else if (48 <= c && c <= 57) {
                sb.append(c);
            } else {
                if (sb.length() > 0) {
                    int dart = Integer.parseInt(sb.toString());
                    score[count] = dart;
                    sb = new StringBuilder();
                }

                if (c == 'D') {
                    score[count] = (int) Math.pow(score[count], 2);
                    count++;
                } else if (c == 'T') {
                    score[count] = (int) Math.pow(score[count], 3);
                    count++;
                } else {
                    count++;
                }

            }
        }
        return Arrays.stream(score).sum();
    }
}
