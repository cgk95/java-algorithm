package algorithm.GREEDY;

import algorithm.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class BOJ25556_포스택 implements Application {
    static Scanner sc = new Scanner(System.in);
    static int[] array;
    static boolean flag = true;
    static ArrayList<Stack<Integer>> stacks;

    public static void main(String[] args) {
        sc.nextInt();
        sc.nextLine();
        array = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        // 네개의 스택 준비
        stacks = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            stacks.add(new Stack<>());
            stacks.get(i).add(0); // 비교를 위해 초기화
        }
        //풀이
        for (int i = 0; i < array.length; i++) {
            findAndPushRightPosition(i);
            if (!flag) {
                break;
            }
        }
        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static void findAndPushRightPosition(int i) {
        int minDiff = Integer.MAX_VALUE;
        int minStk = -1;
        // 포스택의 원소와의 차가 가장 작은 원소를 가진 포스택 찾기
        for (int j = 0; j < stacks.size(); j++) {
            Stack<Integer> stk = stacks.get(j);
            if (stk.peek() < array[i]) { //  현재 숫자보다 작을 경우
                int diff = array[i] - stk.peek();
                if (diff < minDiff) {
                    minDiff = diff; // 업데이트
                    minStk = j; // 몇 번 스택인지 기록
                }
            }
        }
        if (minStk != -1) { // 집어넣을 만한 스택이 있엇다면
            stacks.get(minStk).push(array[i]); // 차이가 가장 작은 쪽에 푸시
        } else { // 현재 숫자보다 큰 녀석밖에 없다면 실패
            flag = false;
        }
    }
}

//    //풀이
//        for (int i = 0; i < array.length; i++) {
//        if (is4StacksAllNotEmpty()) { //네 개의 스택이 원소를 한가지 이상은 가지고 있는 경우
//            if (findAndPushRightPosition(i)) {
//                break;
//            }
//        } else { // 비어 있는 스택이 있는 경우
//            if (array[i] <= 4) { // 현재 숫자가 1,2,3,4 중 하나일 경우
//                stacks.get(array[i] - 1).push(array[i]);
//            } else {  // 1,2,3,4 가 아닌 경우
//                if (findAndPushRightPosition(i)) {
//                    break;
//                }
//
//            }
//        }
//    }
//        if (flag) {
//        System.out.println("YES");
//    } else {
//        System.out.println("NO");
//    }
//}
//
//    private static boolean findAndPushRightPosition(int i) {
//        int minDiff = Integer.MAX_VALUE;
//        int minStk = -1;
//        // 포스택의 원소와의 차가 가장 작은 원소를 가진 포스택 찾기
//        for (int j = 0; j < stacks.size(); j++) {
//            Stack<Integer> stk = stacks.get(j);
//            if (!stk.isEmpty() && stk.peek() < array[i]) { // 채워져 있는 스택이 있고, 현재 숫자보다 작을 경우
//                int diff = array[i] - stk.peek();
//                if (diff < minDiff) {
//                    minDiff = diff; // 업데이트
//                    minStk = j; // 몇 번 스택인지 기록
//                }
//            }
//        }
//        if (minStk != -1) { // 집어넣을 만한 스택이 있엇다면
//            stacks.get(minStk).push(array[i]); // 차이가 가장 작은 쪽에 푸시
//        } else { // 현재 숫자보다 큰 녀석밖에 없다면 실패
//            flag = false;
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     * @return flag : 포스택이 모두 원소를 가지고 있는 경우 true, 하나라도 비어 있으면 false
//     */
//    private static boolean is4StacksAllNotEmpty() {
//        for (Stack<Integer> stk : stacks) {
//            if (stk.isEmpty()) return false;
//        }
//        return true;
//    }

