package algorithm.GREEDY;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
@DisplayName("조이스틱 테스트")
public class Programmers_조이스틱Test {

    Programmers_조이스틱 joy =new Programmers_조이스틱();

    @Test
    @DisplayName("알파벳 아스키 코드 범위 검증")
    void asciiCheck() {
        assertThat(joy.printAsciiChar('A')).isEqualTo(65);
    }
    @Test
    @DisplayName("알파벳 아스키 코드 범위 검증")
    void asciiCheck02() {
        assertThat(joy.printAsciiChar('Z')).isEqualTo(90);
    }
    @Test
    @DisplayName("테스트 케이스 01")
    void test01() {
        assertThat(joy.solution("JEROEN")).isEqualTo(56);
    }
    @Test
    @DisplayName("테스트 케이스 02")
    void test02() {
        assertThat(joy.solution("JAN")).isEqualTo(23);
    }
    @Test
    @DisplayName("테스트 케이스 03")
    void test03() {
        assertThat(joy.solution("AAB")).isEqualTo(2);
    }
}