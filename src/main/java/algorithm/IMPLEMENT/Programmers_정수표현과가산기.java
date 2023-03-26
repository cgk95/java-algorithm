package algorithm.IMPLEMENT;

import java.util.ArrayList;
import java.util.Arrays;

public class Programmers_정수표현과가산기 {
    public int[] solution(int[] a, int[] b) {
        ArrayList<Integer> result = new ArrayList<>();
        int carry = 0;

        int i = a.length - 1;
        int j = b.length - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a[i];
                i--;
            }
            if (j >= 0) {
                sum += b[j];
                j--;
            }
            result.add(sum % 10);
            carry = sum / 10;
        }

        int[] answer = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            answer[k] = result.get(result.size() - 1 - k);
        }

        return answer;
    }

    private void reverseArray(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int tmp = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = arr[i];
            arr[i] = tmp;
        }
    }

    public static void main(String[] args) {
        Programmers_정수표현과가산기 sol = new Programmers_정수표현과가산기();
        System.out.println(Arrays.toString(sol.solution(new int[]{5, 2, 1, 4, 6}, new int[]{6, 1, 0, 4, 4})));
        System.out.println(Arrays.toString(sol.solution(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, new int[]{1})));
    }
}
