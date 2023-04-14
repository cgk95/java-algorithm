package algorithm.GREEDY;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class Programmers_섬연결하기Test {
    Programmers_섬연결하기 sol = new Programmers_섬연결하기();
    @Test
    void test01(){
        assertThat(sol.solution(4,new int[][] {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}})).isEqualTo(4);
    }

}