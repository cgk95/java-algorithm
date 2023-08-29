package algorithm.IMPLEMENT;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Programmers_1차캐시Test {
    Programmers_1차캐시 sol;

    @BeforeEach
    void prepare() {
        sol = new Programmers_1차캐시();
    }

    @Test
    void test01() {
        assertThat(sol.solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"})).isEqualTo(50);
    }

    @Test
    void test010() {
        assertThat(sol.solution(5, new String[]{"leo", "leo", "leo"})).isEqualTo(7);
    }

    @Test
    void test011() {
        assertThat(sol.solution(3, new String[]{"a", "b", "c", "a", "b", "d", "c"})).isEqualTo(27);
    }


}