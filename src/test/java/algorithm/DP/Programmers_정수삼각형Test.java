package algorithm.DP;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Programmers_정수삼각형Test {
    Programmers_정수삼각형 sol;

    @BeforeEach
    void prepare() {
        sol = new Programmers_정수삼각형();
    }

    @Test
    void test() {
        assertThat(sol.solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}})).isEqualTo(30);
    }

}