package algorithm.STACK;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Programmers_뒤에있는큰수찾기Test {
    Programmers_뒤에있는큰수찾기 sol;

    @BeforeEach
    void set() {
        sol = new Programmers_뒤에있는큰수찾기();
    }

    @Test
    @DisplayName("tc01")
    void test01() {
        assertThat(sol.solution(new int[]{2, 3, 3, 5})).isEqualTo(new int[]{3, 5, 5, -1});
    }

    @Test
    @DisplayName("tc02")
    void test02() {
        assertThat(sol.solution(new int[]{9, 1, 5, 3, 6, 2})).isEqualTo(new int[]{-1, 5, 6, 6, -1, -1});
    }
}