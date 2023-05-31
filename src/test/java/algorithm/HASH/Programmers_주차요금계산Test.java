package algorithm.HASH;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
class Programmers_주차요금계산Test {
    Programmers_주차요금계산 sol = new Programmers_주차요금계산();

    @Test
    @DisplayName("시분 전환 테스트01")
    void computeTotalMinuteTest01() {
        assertThat(sol.computeTotalMinute("23:45", "23:45")).isEqualTo(0);
    }

    @Test
    @DisplayName("시분 전환 테스트02")
    void computeTotalMinuteTest02() {
        assertThat(sol.computeTotalMinute("21:59", "23:01")).isEqualTo(62);
    }

    @Test
    @DisplayName("테스트케이스 01")
    void test01(){
        assertThat(sol.solution(new int[]{180, 5000, 10, 600},
                new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}))
                .isEqualTo(new int[] {14600, 34400, 5000});
    }@Test
    @DisplayName("테스트케이스 02")
    void test02(){
        assertThat(sol.solution(new int[]{180, 5000, 10, 600},
                new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "05:34 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "22:59 5961 OUT"}))
                .isEqualTo(new int[] {14600, 34400, 0});
    }
}