package algorithm.GRAPH;

import algorithm.GRAPH.FloydWarshall.Programmers_합승택시요금;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Programmers_합승택시요금Test {
    Programmers_합승택시요금 sol;
    @BeforeEach
    public void prepare(){
        sol = new Programmers_합승택시요금();
    }

    @Test
    void test() {
        assertThat(sol.solution(6,4,6,2,new int[][] {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}})).isEqualTo(82);
    }@Test
    void test2() {
        assertThat(sol.solution(7,3,4,1,new int[][] {{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}})).isEqualTo(14);
    }@Test
    void test3() {
        assertThat(sol.solution(6,4,5,6,new int[][] {{2, 6, 6}, {6, 3, 7}, {4, 6, 7}, {6, 5, 11}, {2, 5, 12}, {5, 3, 20}, {2, 4, 8}, {4, 3, 9}})).isEqualTo(18);
    }

}