package algorithm.GRAPH;

import algorithm.GRAPH.FloydWarshall.Programmers_순위;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Programmers_순위Test {
    Programmers_순위 sol = new Programmers_순위();
    @Test
    void test01(){
        assertThat(sol.solution(5,new int[][] {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}})).isEqualTo(2);
    }

}