package algorithm.GREEDY;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
class Programmers_단속카메라Test {
    Programmers_단속카메라 sol = new Programmers_단속카메라();

    @Test
    void test01() {
        assertThat(sol.solution(new int[][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}})).isEqualTo(2);
    }

    @Test
    void test02() {
        assertThat(sol.solution(new int[][]{{-2, -1}, {1, 2}, {-3, 0}})).isEqualTo(2);
    }

    @Test
    void test03() {
        assertThat(sol.solution(new int[][]{{0, 0}})).isEqualTo(1);
    }

    @Test
    void test04() {
        assertThat(sol.solution(new int[][]{{0, 1}, {0, 1}, {1, 2}})).isEqualTo(1);
    }

    @Test
    void test05() {
        assertThat(sol.solution(new int[][]{{0, 1}, {2, 3}, {4, 5}, {6, 7}})).isEqualTo(4);
    }

    @Test
    void test07() {
        assertThat(sol.solution(new int[][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}})).isEqualTo(2);
    }

    @Test
    void test08() {
        assertThat(sol.solution(new int[][]{{-20, 15}, {-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}})).isEqualTo(2);
    }

    @Test
    void test09() {
        assertThat(sol.solution(new int[][]
                {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}, {7, 8}, {8, 9}, {9, 10}, {10, 11}, {11, 12}, {12, 13}, {13, 14}, {14, 15}}))
                .isEqualTo(8);
    }

    @Test
    void test10() {
        assertThat(sol.solution(new int[][]{{0, 12}, {1, 12}, {2, 12}, {3, 12}, {5, 6}, {6, 12}, {10, 12}})).isEqualTo(2);
    }

    @Test
    void test11() {
        assertThat(sol.solution(new int[][]{{0, 0}, {0, 10}, {1, 1}, {3, 3}})).isEqualTo(3);
    }

    @Test
    void test12() {
        assertThat(sol.solution(new int[][]{{-100, 100}, {50, 170}, {150, 200}, {-50, -10}, {10, 20}, {30, 40}})).isEqualTo(4);
    }
}