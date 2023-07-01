package algorithm.DFS_BFS;

import algorithm.GRAPH.DFS_BFS.Programmers_퍼즐조각채우기;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Programmers_퍼즐조각채우기Test {
    Programmers_퍼즐조각채우기 sol = new Programmers_퍼즐조각채우기();

    @Test
    void test01() {
        assertThat(sol.solution(new int[][]{{1, 1, 0, 0, 1, 0}, {0, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 0, 1}, {1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 1, 0}, {0, 1, 1, 1, 0, 0}}
                , new int[][]{{1, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 1, 0, 0, 0}, {1, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 0, 0}}))
                .isEqualTo(14);
    }

    @Test
    void test02() {
        assertThat(sol.solution(new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 1}}
                , new int[][]{{1, 1, 1}, {1, 0, 0}, {0, 0, 0}}))
                .isEqualTo(0);
    }

}