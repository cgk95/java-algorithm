package algorithm.IMPLEMENT;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class 문자열수식계산Test {
    문자열수식계산 sol=new 문자열수식계산();
    @Test
    void test01() { //	"23*56/3*+15+"
        assertThat(sol.solution("2*3+5/6*3+15")).isEqualTo(23.50);
    }
}