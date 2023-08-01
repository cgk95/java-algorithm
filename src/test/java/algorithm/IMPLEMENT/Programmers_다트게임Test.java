package algorithm.IMPLEMENT;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
class Programmers_다트게임Test {
    Programmers_다트게임 sol;

    @BeforeEach
    void prepare() {
        sol = new Programmers_다트게임();
    }

    @Test
    void test01() {
        assertThat(sol.solution("1S2D*3T")).isEqualTo(37);
    }

    @Test
    void test02() {
        assertThat(sol.solution("1D2S#10S")).isEqualTo(9);
    }

    @Test
    void test03() {
        assertThat(sol.solution("1D2S0T")).isEqualTo(3);
    }

    @Test
    void test04() {
        assertThat(sol.solution("1S*2T*3S")).isEqualTo(23);
    }

    @Test
    void test05() {
        assertThat(sol.solution("1D#2S*3S")).isEqualTo(5);
    }

    @Test
    void test06() {
        assertThat(sol.solution("1T2D3D#")).isEqualTo(-4);
    }

    @Test
    void test07() {
        assertThat(sol.solution("1D2S3T*")).isEqualTo(59);
    }

}

