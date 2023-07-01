package algorithm.GREEDY;

public class Programmers_조이스틱 {
    char[] spell;
    int answer = 0;

    public int solution(String name) {
        spell = name.toCharArray();
        answer = 0;
        int leftRight = spell.length - 1; // 기본적인 좌우 횡이동 횟수로 초기화
        for (int i = 0; i < spell.length; i++) {
            countUpDown(i); // 위아래 커서 이동횟수를 추가
            if (i < spell.length - 1 && spell[i + 1] == 'A') {
                int lastIdxOfA = i + 1;
                while (lastIdxOfA < spell.length && spell[lastIdxOfA] == 'A') {
                    lastIdxOfA++; // A 끝나는 위치 업데이트
                }
                leftRight = Math.min(leftRight, (i * 2) + spell.length - lastIdxOfA); // 오른쪽으로 쭉 갔다가 되돌아오는 경우랑 비교
                leftRight = Math.min(leftRight, i + (name.length() - lastIdxOfA) * 2); // 왼쪽으로 쭉 갔다가 되돌아오는 경우
            }
        }
        return answer + leftRight;
    }


    private void countUpDown(int idx) {
        int curr = Character.hashCode(spell[idx]);
        answer += Math.min(91 - curr, curr - 65);
    }

    public int printAsciiChar(char word) { // 아스키 코드 확인용
        System.out.println(word);
        System.out.println(Character.hashCode(word));
        return Character.hashCode(word);
    }

}
