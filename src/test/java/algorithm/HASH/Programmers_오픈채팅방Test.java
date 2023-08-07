package algorithm.HASH;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Programmers_오픈채팅방Test {
    Programmers_오픈채팅방 sol;

    @BeforeEach
    void prepare() {
        sol = new Programmers_오픈채팅방();
    }

    @Test
    void test01() {
        assertThat(sol.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"}))
                .isEqualTo(new String[]{"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."});
    }

}