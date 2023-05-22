package algorithm.HASH;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
@Nested
@DisplayName("할인행사test")
class Programmers_할인행사Test {
    Programmers_할인행사 sol = new Programmers_할인행사();
    @Test
    @DisplayName("test01")
    void test01() {
        assertThat(sol.solution(new String[]{"banana", "apple", "rice", "pork", "pot"},
                new int[]{3, 2, 2, 2, 1},
                new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}))
                .isEqualTo(3);
    }
    @Test
    @DisplayName("test02")
    void test02() {
        assertThat(sol.solution(new String[]{"apple"},
                new int[]{10},
                new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"}))
                .isEqualTo(0);
    }
    @Test
    @DisplayName("test03")
    void test03() {
        assertThat(sol.solution(new String[]{"banana", "pot"},
                new int[]{3,1},
                new String[]{"banana", "pot", "pot", "pot", "pot", "pot", "pot", "pot", "banana", "banana", "pot", "pot", "pot", "pot", "pot", "pot", "pot", "banana"}))
                .isEqualTo(0);
    }

}