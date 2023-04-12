package algorithm;

import algorithm.TwoPointer.Programmers_연속된부분수열의합;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
class Programmers_연속된부분수열의합Test {
    Programmers_연속된부분수열의합 sol= new Programmers_연속된부분수열의합();
    @Test
    @DisplayName("테스트 01")
    void test01(){
        assertThat(sol.solution(new int[]{1, 2, 3, 4, 5}, 7)).isEqualTo(new int[]{2, 3});
    }
    @Test
    @DisplayName("테스트 02")
    void test02(){
        assertThat(sol.solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5)).isEqualTo(new int[]{6,6});
    }
    @Test
    @DisplayName("테스트 03")
    void test03(){
        assertThat(sol.solution(new int[]{2, 2, 2, 2, 2}, 6)).isEqualTo(new int[]{0, 2});
    }
    @Test
    @DisplayName("수열의 합 메서드 테스트")
    void testsumOfSubsequence(){
        assertThat(sol.sumOfSubsequence(new int[]{1, 2, 3, 4},1,2)).isEqualTo(5);
    }
}