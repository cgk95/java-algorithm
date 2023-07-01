package algorithm;

import algorithm.GRAPH.DFS_BFS.Programmers_아이템줍기;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Programmers_아이템줍기Test {
    Programmers_아이템줍기 sol = new Programmers_아이템줍기();
    @Test
    void test01(){
        assertThat(sol.solution(new int[][] {{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}},1,3,7,8))
                .isEqualTo(17);
    }

}