package algorithm.HASH;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
@DisplayName("테스트 케이스에 대한 검증")
public class Programmers_폰켓몬_Test {
    Programmers_폰켓몬 testClass = new Programmers_폰켓몬();
    @Test
    @DisplayName("1번 테스트케이스")
    void test01(){
        assertThat(testClass.solution(new int[]{3, 3, 3, 3})).isEqualTo(1);
    }
    @Test
    @DisplayName("2번 테스트케이스")
    void test02() {
        assertThat(testClass.solution(new int[]{3, 1, 2, 3})).isEqualTo(2);
    }

    @Test
    @DisplayName("3번 테스트케이스")
    void test03() {
        assertThat(testClass.solution(new int[]{3, 3, 3, 2, 2, 4})).isEqualTo(3);
    }

    @Test
    @DisplayName("4번 테스트케이스")
    void test04(){
        assertThat(testClass.solution(new int[]{3,3,3,2,2,2})).isEqualTo(2);
    }
}
