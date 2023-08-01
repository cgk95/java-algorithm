package algorithm.DIVIDE_CONQUER;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Programmers_쿼드압축개수세기Test {
    Programmers_쿼드압축개수세기 sol;
    @BeforeEach
    void prepare(){
        sol = new Programmers_쿼드압축개수세기();
    }
    @Test
    @DisplayName("테스트케이스 01")
    void test01() {
        assertThat(sol.solution(new int[][] {{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}})).isEqualTo(new int[] {4,9});
    }
}