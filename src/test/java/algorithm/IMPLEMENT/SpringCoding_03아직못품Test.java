package algorithm.IMPLEMENT;

import algorithm.IMPLEMENT.SpringCoding_03_아직못품;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
@DisplayName("SpringCoding 테스트케이스")
class SpringCoding_03아직못품Test {
    SpringCoding_03_아직못품 springCoding03 = new SpringCoding_03_아직못품();
    @Test
    @DisplayName("테스트케이스 01")
    void test01(){
        assertThat(springCoding03.solution(new int[][]{{2, 0}, {3, 1}})).isEqualTo(new int[]{0, 0});
    }
    @Test
    @DisplayName("테스트케이스 02")
    void test02(){
        assertThat(springCoding03.solution(new int[][]{{1,4,3}, {1,2,2}})).isEqualTo(new int[]{0, 1});
    }
    @Test
    @DisplayName("테스트케이스 03")
    void test03(){
        assertThat(springCoding03.solution(new int[][]{{0,2,0,1}, {0,1,0,1}})).isEqualTo(new int[]{1, 0});
    }
}