package algorithm.GRAPH;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Programmers_양과늑대Test {
    Programmers_양과늑대 sol;

    @BeforeEach
    void prepare() {
        sol = new Programmers_양과늑대();
    }

    @Test
    void test01() {
        assertThat(sol.solution(new int[]{0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                new int[][]{{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}}))
                .isEqualTo(5);
    }

    @Test
    void test02() {
        assertThat(sol.solution(new int[]{0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0},
                new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {3, 7}, {4, 8}, {6, 9}, {9, 10}}))
                .isEqualTo(5);
    }

}