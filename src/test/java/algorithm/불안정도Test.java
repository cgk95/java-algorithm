package algorithm;

import algorithm.DSU.불안정도;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class 불안정도Test {
    불안정도 sol=new 불안정도();
    @Test
    void test01() {
        assertThat(sol.solution(new int[] {1,3,5,6,7,9},new int[] {2,7,4,3,1,1},2))
                .isEqualTo(1);
    }
    @Test
    void test02() {
        assertThat(sol.solution(new int[] {1,3,5,6,7,9},new int[] {2,7,4,3,1,1},0))
                .isEqualTo(4);
    }
    @Test
    void test03() {
        assertThat(sol.solution(new int[] {1,3,4,5,7,9},new int[] {3,2,4,1,1,2},2))
                .isEqualTo(1);
    }
    @Test
    void solution(){
        sol.solution(new int[] {1,3,4,5,7,9},new int[] {3,2,4,1,1,2},2);
    }
}