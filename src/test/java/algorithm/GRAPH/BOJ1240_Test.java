package algorithm.GRAPH;

import algorithm.GRAPH.BFS.BOJ1240_노드사이의거리;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
@Nested
@DisplayName("노드사이의 거리 테스트 케이스")
public class BOJ1240_Test {
    BOJ1240_노드사이의거리 sol=new BOJ1240_노드사이의거리();
    @Test
    @DisplayName("테스트케이스 01")
    void test01() throws IOException {
        assertThat(6).isEqualTo(6);
    }
    @Test
    @DisplayName("테스트케이스 02")
    void test02(){
    }
    @Test
    @DisplayName("테스트케이스 03")
    void test03(){

    }
}
