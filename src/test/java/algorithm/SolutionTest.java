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
        assertThat(sol.solution(new String[] {"혁준", "하밥", "양상", "심심이", "소스왕"},new String[] {"혁준", "양상"},new String[] {"심심이", "소스왕"})).isEqualTo("1350만원(하밥)");
    }

    @Test
    @DisplayName("테스트케이스 02")
    void test02() {
//        assertThat(sol.solution("! Sex.,is??Coding")).isEqualTo(new String[] {"xeS","si","gnidoC"});;
    }

    @Test
    @DisplayName("테스트케이스 03")
    void test03() {
//        assertThat(sol.solution(new int[][] {{3, 5}, {3, 7}, {12, 4}, {12, 10}})).isEqualTo(1);
    }

}
