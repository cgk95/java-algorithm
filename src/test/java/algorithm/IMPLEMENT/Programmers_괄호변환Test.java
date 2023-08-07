package algorithm.IMPLEMENT;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Programmers_괄호변환Test {
    Programmers_괄호변환 sol;

    @BeforeEach
    void prepare() {
        sol = new Programmers_괄호변환();
    }

    @Test
    void test() {
        assertThat(sol.solution("(()())()")).isEqualTo("(()())()");
    }

    @Test
    void test1() {
        assertThat(sol.solution(")(")).isEqualTo("()");
    }

    @Test
    void test2() {
        assertThat(sol.solution("()))((()")).isEqualTo("()(())()");
    }

}