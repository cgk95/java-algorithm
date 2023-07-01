package algorithm.BRUTE_FORCE;

import java.util.ArrayList;

public class Programmers_소수찾기 {
    ArrayList<Integer> permutations;
    String[] number;

    public int solution(String numbers) {
        number = numbers.split("");
        permutations = new ArrayList<>();
        for (int j = 1; j <= number.length; j++) {
            myDfs(number, 0, number.length, j);
        }
        return permutations.stream().filter(this::isPrime).toArray(Integer[]::new).length;
    }

    private void myDfs(String[] arr, int depth, int n, int k) {
        if (depth == k) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < k; i++) {
                sb.append(arr[i]);
            }
            int currNum = Integer.parseInt(sb.toString());
            if (!permutations.contains(currNum)) {
                permutations.add(currNum);
            }
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            myDfs(number, depth + 1, n, k);
            swap(arr, depth, i);
        }

    }

    private void swap(String[] arr, int index, int i) {
        String temp = arr[index];
        arr[index] = arr[i];
        arr[i] = temp;
    }

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int j = 2; j < n; j++) {
            if (n % j == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Programmers_소수찾기 sol = new Programmers_소수찾기();
        System.out.println(sol.solution("011"));
    }
}
