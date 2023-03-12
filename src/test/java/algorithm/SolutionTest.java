package algorithm;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
@DisplayName("짜잘한 문제들 테스" + "트용")
public class SolutionTest {
    Solution sol = new Solution();

    @Test
    @DisplayName("테스트케이스 01")
    void test01() {
        assertThat(sol.문제가이상함(15)).isEqualTo(4);
    }

    @Test
    @DisplayName("테스트케이스 02")
    void test02() {
        assertThat(sol.최소비용문열기(new int[][]{{1}, {2, 5}, {7, 10, 1}, {9, 4, 4, 5}})).isEqualTo(11);
    }

    @Test
    @DisplayName("테스트케이스 03")
    void test03() {
        assertThat(sol.solution(new int[]{10})).isEqualTo(new int[]{10});
    }
    @Test
    @DisplayName("테스트케이스 04")
    void test04() {
        assertThat(sol.n자리의펠린드롬수(11)).isEqualTo(90);
    }

    @Test
    @DisplayName("테스트케이스 05")
    void test05() {
        assertThat(sol.n자리의펠린드롬수(12)).isEqualTo(900);
    }

    @Test
    @DisplayName("테스트케이스 06")
    void test06() {
        assertThat(sol.n자리의펠린드롬수(13)).isEqualTo(900);
    }

    @Test
    @DisplayName("테스트케이스 07")
    void test07() {
        assertThat(sol.n자리의펠린드롬수(14)).isEqualTo(9000);
    }

}
