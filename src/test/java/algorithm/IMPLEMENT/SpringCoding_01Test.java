package algorithm.IMPLEMENT;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
@DisplayName("SpringCodeing 문제 1번")
class SpringCoding_01Test {
    SpringCoding_01 spCd=new SpringCoding_01();
    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("테스트케이스 01")
    void testCase01(){
        assertThat(spCd.solution(new int[][]{{100, 100, 500}, {1000, 1000, 100}})).isEqualTo(2);
    }
    @Test
    @DisplayName("테스트케이스 02")
    void testCase02(){
        assertThat(spCd.solution(new int[][]{{10, 19, 800}, {20, 39, 200},{100,199,500}})).isEqualTo(1);
    }
    @Test
    @DisplayName("테스트케이스 03")
    void testCase03(){
        assertThat(spCd.solution(new int[][]{{50,1,50}, {100,199,100},{1,1,500}})).isEqualTo(1);
    }
    @Test
    @DisplayName("테스트케이스 04")
    void testCase04(){
        assertThat(spCd.solution(new int[][]{{50,1,50}, {100,99,100},{1,0,500}})).isEqualTo(3);
    }
}