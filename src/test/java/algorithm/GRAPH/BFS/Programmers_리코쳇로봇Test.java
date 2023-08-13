package algorithm.GRAPH.BFS;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Programmers_리코쳇로봇Test {
    Programmers_리코쳇로봇 sol;

    @BeforeEach
    void prepare() {
        sol = new Programmers_리코쳇로봇();
    }

    @Test
    void test01() {
        assertThat(sol.solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}))
                .isEqualTo(7);
    }@Test
    void test02() {
        assertThat(sol.solution(new String[]{".D.R", "....", ".G..", "...D"}))
                .isEqualTo(-1);
    }

}