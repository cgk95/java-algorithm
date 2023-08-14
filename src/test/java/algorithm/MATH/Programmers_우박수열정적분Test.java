package algorithm.MATH;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Programmers_우박수열정적분Test {
    Programmers_우박수열정적분 sol;

    @BeforeEach
    void prepare() {
        sol = new Programmers_우박수열정적분();
    }

    @Test
    @DisplayName("test01")
    public void test01() {
        assertThat(sol.solution(5, new int[][]{{0, 0}, {0, -1}, {2, -3}, {3, -3}})).isEqualTo(new double[]{33.0, 31.5, 0.0, -1.0});
    }

    @Test
    @DisplayName("test02")
    public void test02() {
        assertThat(sol.solution(3, new int[][]{{0, 0}, {1, -2}, {3, -3}})).isEqualTo(new double[]{47.0, 36.0, 12.0});
    }
}