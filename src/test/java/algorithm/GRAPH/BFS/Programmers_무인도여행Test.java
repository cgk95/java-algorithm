package algorithm.GRAPH.BFS;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Programmers_무인도여행Test {
    Programmers_무인도여행 sol;

    @BeforeEach
    void prepare() {
        sol = new Programmers_무인도여행();
    }

    @Test
    void test01() {
        assertThat(sol.solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"})).isEqualTo(new int[]{1, 1, 27});
    }

}