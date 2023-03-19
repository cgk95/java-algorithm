package algorithm.GREEDY;

public class Programmers_조이스틱 {
    char[] spell;
    int answer = 0;

    public int solution(String name) {
        spell = name.toCharArray();
        answer = 0;
        int leftRight= spell.length-1; // 기본적인 좌우 횡이동 횟수로 초기화
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
        return answer+leftRight;
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

//// 오른쪽으로 진행하는 경우
//        for (int idx = 0; idx < spell.length; idx++) {
//        int i = idx;
//        for (int j = 0; j < spell.length; j++) {
//        countUpDown(i);
//        target[i] = spell[i];
//        if (Arrays.equals(target, spell)) {
//        break;
//        }
//        i++;
//        if (j == spell.length - 1) {
//        break;
//        }
//        count++;
//        }
//        answer = Math.min(answer, count);
//
//        // 왼쪽으로 진행하는 경우
//        i = idx;
//        count = 0;
//        Arrays.fill(target, 'A'); // 초기화
//        for (int j = 0; j < spell.length; j++) {
//        countUpDown(i);
//        target[i] = spell[i];
//        i--;
//        if (i < 0) {
//        i = i + spell.length;
//        }
//        if (Arrays.equals(target, spell)) {
//        break;
//        }
//        if (j == spell.length - 1) {
//        break;
//        }
//
//        count++;
//
//        }
//        answer = Math.min(answer, count);
//        }