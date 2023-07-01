package algorithm.GREEDY;

import java.util.ArrayList;
import java.util.Comparator;

public class Programmers_구명보트 {
    public int solution(int[] people, int limit) {
        ArrayList<Integer> boatPeople = new ArrayList<>();
        int answer = 0;
        for (int kg : people) {
            if (kg >= limit) {
                answer++;
                continue;
            }
            boatPeople.add(kg);
        }
        boatPeople.sort((Comparator.comparingInt(o -> o)));
        int max = boatPeople.size() - 1;
        int min = 0;
        while (min <= max) {
            if (boatPeople.get(min) + boatPeople.get(max) <= limit) {
                answer++;
                min++;
                max--;
                continue;
            }
            max--;
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Programmers_구명보트 sol = new Programmers_구명보트();
        System.out.println(sol.solution(new int[]{70, 50, 80, 50}, 100));
        System.out.println(sol.solution(new int[]{70, 80, 50}, 100));
        System.out.println(sol.solution(new int[]{30, 40, 50, 60}, 100));
    }
}
//    boolean[] visited = new boolean[boatPeople.size()];
//        for (int i = 0; i < boatPeople.size(); i++) {
//        if (!visited[i]) {
//        for (int j = i + 1; j < boatPeople.size(); j++) {
//        if (!visited[j] && boatPeople.get(i) + boatPeople.get(j) <= limit) {
//        answer++;
//        visited[i] = visited[j] = true; // 방문표시
//        break;
//        }
//        }
//        }
//        }
//
//        for (boolean b : visited) {
//        if (!b) {
//        answer++;
//        }
//        }
//        return answer;