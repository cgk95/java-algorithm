package algorithm.BINARY_SEARCH;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Programmers_징검다리Test {
    Programmers_징검다리 sol= new Programmers_징검다리();

    @Test
    void test01() {
        assertThat(sol.solution(25,new int[] {2,14,11,21,17},2)).isEqualTo(4);
    }
}