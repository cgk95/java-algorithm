package algorithm.IMPLEMENT;

import java.util.Arrays;

public class Programmers_분수의덧셈 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(1, 2, 3, 4)));
        System.out.println(Arrays.toString(solution(11, 3, 1, 3)));
        System.out.println(Arrays.toString(solution(2, 1, 2, 1)));
        System.out.println(Arrays.toString(solution(3, 2, 3, 2))); // case13
        System.out.println(Arrays.toString(solution(9, 2, 1, 3)));
    }

    public static int[] solution(int numer1, int denom1, int numer2, int denom2) {
        if (denom1 == denom2) {
            return checkFraction(numer1 + numer2, denom1);
        }
        int gcd = myGCD(numer1 * denom2 + numer2 * denom1, denom1 * denom2);
        return new int[]{(numer1 * denom2 + numer2 * denom1) / gcd, denom1 * denom2 / gcd};
    }

    private static int[] checkFraction(int numerSum, int denom) {
        if (numerSum % denom == 0) {
            return new int[]{numerSum / denom, 1};
        }
        int gcd = myGCD(numerSum, denom);
        return new int[]{numerSum / gcd, denom / gcd}; // case13 해결을 위해서
    }

    private static int myGCD(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return myGCD(num2, num1 % num2);
    }
}
