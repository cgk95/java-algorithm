package algorithm.GRAPH;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Programmers_방문길이Test {
    Programmers_방문길이 sol;
    @BeforeEach
    void prepare(){
        sol = new Programmers_방문길이();
    }
    @Test
    void test01(){
        assertThat(sol.solution("ULURRDLLU")).isEqualTo(7);
    }@Test
    void test02(){
        assertThat(sol.solution("LULLLLLLU")).isEqualTo(7);
    }

}