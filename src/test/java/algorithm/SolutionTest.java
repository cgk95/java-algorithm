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
        assertThat(sol.solution("Naver")).isEqualTo("nAVER");
    }

    @Test
    @DisplayName("테스트케이스 02")
    void test02() {
        assertThat(sol.solution("NAAAAAAAAAA")).isEqualTo("naaaaaaaaaa");
    }

    @Test
    @DisplayName("테스트케이스 03")
    void test03() {
//        assertThat(sol.solution(new int[][] {{3, 5}, {3, 7}, {12, 4}, {12, 10}})).isEqualTo(1);
    }

}
