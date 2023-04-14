package algorithm.GREEDY;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Programmers_섬연결하기Test {
    Programmers_섬연결하기 sol = new Programmers_섬연결하기();

    @Test
    void test01() {
        assertThat(sol.solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}})).isEqualTo(4);
    }

    @Test
    void test02() {
        assertThat(sol.solution(4, new int[][]{{1, 2, 5}, {2, 3, 8}, {0, 1, 1}, {0, 2, 2}, {1, 3, 1}})).isEqualTo(4);
    }
    @Test
    void test03() {
        assertThat(sol.solution(5, new int[][]{{0, 1, 5}, {1, 2, 3}, {2, 3, 3}, {3, 1, 2}, {3, 0, 4}, {2, 4, 6}, {4, 0, 7}})).isEqualTo(15);
    }
    @Test
    void test04() {
        assertThat(sol.solution(5, new int[][]{{0, 1, 1}, {2, 3, 1}, {3, 4, 2}, {1, 2, 2}, {0, 4, 100}})).isEqualTo(6);
    }

    @Test
    void test05() {
        assertThat(sol.solution(5, new int[][]{{0, 1, 5}, {1, 2, 3}, {2, 3, 3}, {3, 1, 2}, {3, 0, 4}, {2, 4, 6}, {4, 0, 7}})).isEqualTo(15);
    }
    @Test
    void test06() {
        assertThat(sol.solution(6, new int[][]{{0, 1, 1}, {2, 3, 1}, {3, 4, 2}, {1, 2, 2}, {0, 4, 100},{0,5,100}})).isEqualTo(106);
    }
    @Test
    void test07() {
        assertThat(sol.solution(1, new int[][]{})).isEqualTo(0);
    }
    @Test
    void test08() {
        assertThat(sol.solution(2, new int[][]{{1,0,4}})).isEqualTo(4);
    }
    @Test
    void test09() {
        assertThat(sol.solution(5, new int[][]{{3,0,1},{4,0,1},{1,3,1},{1,2,1},{2,4,7},{4,1,2}})).isEqualTo(4);
    }
}