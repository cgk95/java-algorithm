package algorithm.GRAPH.TREE;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Programmers_길찾기게임Test {
    Programmers_길찾기게임 sol;

    @BeforeEach
    void prepare() {
        sol = new Programmers_길찾기게임();
    }

    @Test
    @DisplayName("test01")
    void test01() {
        assertThat(sol.solution(new int[][]{{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}}))
                .isEqualTo(new int[][]{{7, 4, 6, 9, 1, 8, 5, 2, 3}, {9, 6, 5, 8, 1, 4, 3, 2, 7}});
    }
}