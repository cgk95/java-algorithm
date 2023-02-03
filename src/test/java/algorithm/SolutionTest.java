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
        assertThat(sol.numberOfCouplesSample(20)).isEqualTo(6);
    }
    @Test
    @DisplayName("테스트케이스 02")
    void test02(){
        assertThat(sol.numberOfCouplesSample(100)).isEqualTo(9);
    }
    @Test
    @DisplayName("테스트케이스 03")
    void test03(){

    }

}
