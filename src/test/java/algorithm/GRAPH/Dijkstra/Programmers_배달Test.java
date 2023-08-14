package algorithm.GRAPH.Dijkstra;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Programmers_배달Test {
    Programmers_배달 sol;

    @BeforeEach
    public void prepare() {
        sol = new Programmers_배달();
    }

    @Test
    @DisplayName("test01")
    public void test01() {
        assertThat(sol.solution(5, new int[][]{{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}}, 3));
    }

    @Test
    @DisplayName("test02")
    public void test02() {
        assertThat(sol.solution(6, new int[][]{{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}}, 4));
    }
}