package algorithm.GREEDY;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
@Nested
class Programmers_요격시스템Test {
    Programmers_요격시스템 sol = new Programmers_요격시스템();

    @Test
    void test01() {
        assertThat(sol.solution(new int[][]{{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}}))
                .isEqualTo(3);
    }
    @Test
    void test02() {
        assertThat(sol.solution(new int[][]{{0,1},{1,5},{3,6}}))
                .isEqualTo(2);
    }
    @Test
    void test03() {
        assertThat(sol.solution(new int[][]{{0,1},{1,5},{3,6},{5,7}}))
                .isEqualTo(3);
    }
    @Test
    void test04() {
        assertThat(sol.solution(new int[][]{{0, 1}, {0, 1}, {1, 2}})).isEqualTo(2);
    }

    @Test
    void test05() {
        assertThat(sol.solution(new int[][]{{0, 1}, {2, 3}, {4, 5}, {6, 7}})).isEqualTo(4);
    }

    @Test
    void test06() {
        assertThat(sol.solution(new int[][]
                {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}, {7, 8}, {8, 9}, {9, 10}, {10, 11}, {11, 12}, {12, 13}, {13, 14}, {14, 15}}))
                .isEqualTo(15);
    }

    @Test
    void test7() {
        assertThat(sol.solution(new int[][]{{0, 12}, {1, 12}, {2, 12}, {3, 12}, {5, 6}, {6, 12}, {10, 12}})).isEqualTo(2);
    }



}