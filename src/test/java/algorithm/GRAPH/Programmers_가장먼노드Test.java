package algorithm.GRAPH;

import algorithm.GRAPH.Dijkstra.Programmers_가장먼노드;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
class Programmers_가장먼노드Test {
    Programmers_가장먼노드 sol = new Programmers_가장먼노드();
    @Test
    @DisplayName("test01")
    void test01() {
        assertThat(sol.solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}})).isEqualTo(3);
    }
}