package algorithm.HASH;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Programmers_철수영희술래잡기 {

    public int solution(int x1, int y1, int x2, int y2) {
        Set<List<Integer>> setA = new HashSet<>();
        Set<List<Integer>> setB = new HashSet<>();
        setA.add(List.of(x1, y1));
        setB.add(List.of(x2, y2));

        Set<List<Integer>> histA = new HashSet<>(Set.copyOf(setA));
        Set<List<Integer>> histB = new HashSet<>(Set.copyOf(setB));

        if (x1 == x2 && y1 == y2) {
            return 0;
        }

        int time = 1;
        while (true) {
            Set<List<Integer>> newSetA = new HashSet<>();
            Set<List<Integer>> newSetB = new HashSet<>();

            setA.forEach(posA -> {
                newSetA.add(List.of(posA.get(0) + 1, posA.get(1)));
                newSetA.add(List.of(posA.get(0), posA.get(1) + 1));
                newSetA.add(List.of(posA.get(0) - 1, posA.get(1)));
                newSetA.add(List.of(posA.get(0), posA.get(1) - 1));
            });
            setB.forEach(posB -> {
                newSetB.add(List.of(posB.get(0) + 1, posB.get(1) + 1));
                newSetB.add(List.of(posB.get(0) + 1, posB.get(1) - 1));
                newSetB.add(List.of(posB.get(0) - 1, posB.get(1) + 1));
                newSetB.add(List.of(posB.get(0) - 1, posB.get(1) - 1));
            });

            newSetA.removeAll(histA);
            newSetB.removeAll(histB);

            for (List<Integer> posA : newSetA) {
                if (newSetB.contains(posA)) {
                    return time;
                }
            }

            histA.addAll(newSetA);
            histB.addAll(newSetB);

            setA = newSetA;
            setB = newSetB;
            time++;
        }
    }
//

    public static void main(String[] args) {
        Programmers_철수영희술래잡기 sol = new Programmers_철수영희술래잡기();
//        System.out.println(sol.solution(2, 4, 5, -3));
        System.out.println(sol.solution(-2, 5, 4, 2));
    }
//    public int solution(int x1, int y1, int x2, int y2) {
//        myBfs(x1, y1,visitedC);
//        myBfs(x2,y2,visitedY);
//        ArrayList<Integer> answer = new ArrayList<>();
//        for (int i = 0; i < visitedC.length; i++) {
//            for (int j = 0; j < visitedC[0].length; j++) {
//                if (visitedC[i][j] == visitedY[i][j]) {
//                    answer.add(visitedC[i][j]);
//                }
//            }
//        }
//        answer.sort((Comparator.comparingInt(o -> o)));
//        return answer.get(0)-1;
//    }
//
//    private void myBfs(int x, int y,int[][] visited) {
//        Queue<int[]> q1 = new LinkedList<>();
//        q1.offer(new int[]{x +1000, y +1000});
//
//        while (!q1.isEmpty()) {
//            int[] curr = q1.poll();
//            for (int k = 0; k < 4; k++) {
//                int nx = curr[0] + cx[k];
//                int ny = curr[1] + cy[k];
//                if (0 <= nx && nx <= 2000 && 0 <= ny && ny <= 2000 && visited[nx][ny]==0) {
//                    q1.offer(new int[]{nx, ny});
//                    visited[nx][ny]=visited[curr[0]][curr[1]]+1;
//                }
//            }
//        }
//    }
}
