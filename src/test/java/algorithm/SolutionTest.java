package algorithm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
@DisplayName("짜잘한 문제들 테스트용")
public class SolutionTest {
    Solution sol=new Solution();
    @Test
    @DisplayName("테스트케이스 01")
    void test01(){
        assertThat(sol.solution(new int[] {1,2,28},20)).isEqualTo(28);
    }
    @Test
    @DisplayName("테스트케이스 02")
    void test02(){
        assertThat(sol.solution(new int[]{10,11,12},13)).isEqualTo(12);
    }
    @Test
    @DisplayName("테스트케이스 03")
    void test03(){
        assertThat(sol.solution(new int[]{7,13,19},10)).isEqualTo(7);
    }

}
