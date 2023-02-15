package algorithm.IMPLEMENT;

import java.util.ArrayList;
import java.util.Arrays;

public class Programmers_나누어떨어지는숫자배열 {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int n : arr) {
            if (n % divisor == 0) {
                answer.add(n);
            }
        }
        answer.sort(Integer::compareTo);
        if (!answer.isEmpty()) {
            return Arrays.stream(answer.toArray())
                    .mapToInt(o->(int)o)
                    .toArray();
        }
        return new int[] {};
    }
}


// 람다를 이용한 풀이 !! 꼭 익힐 것!!
class Divisible {
    public int[] divisible(int[] array, int divisor) {
        //ret에 array에 포함된 정수중, divisor로 나누어 떨어지는 숫자를 순서대로 넣으세요.
        return Arrays.stream(array).filter(factor -> factor % divisor == 0).toArray();
    }
    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {
        Divisible div = new Divisible();
        int[] array = {5, 9, 7, 10};
        System.out.println( Arrays.toString( div.divisible(array, 5) ));
    }
}