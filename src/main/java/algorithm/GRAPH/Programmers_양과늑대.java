package algorithm.GRAPH;

import java.util.ArrayList;
import java.util.List;

public class Programmers_양과늑대 {
    List<Leaf>[] tree;
    boolean[] visited;
    int answer = 0;

    int sheep = 1;
    int Wolf = 0;

    public int solution(int[] info, int[][] edges) {
        // given
        tree = new List[info.length];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            tree[e[0]].add(new Leaf(e[1], info[e[1]]));
        }
        // calculate
        visited = new boolean[tree.length];
        visited[0] = true;
        myDFS(0, 0);
        // 마지막으로 한번 더 탐색
        for (int i = 0; i < tree.length; i++) {
            myDFS(0, Wolf);
        }
        return answer;
    }

    public void myDFS(int index, int wolf) {
        if (sheep - wolf <= 0) {
            return;
        }
        if (answer < sheep) {
            answer = sheep;
            Wolf = wolf;
        }

        for (Leaf l : tree[index]) {
            visited[l.ends] = true;
            if (l.isWolf == 0) {
                sheep++;
                l.isWolf = -1; // 양도 없고 늑대도 없음
            }
            myDFS(l.ends, l.isWolf == 1 ? wolf + 1 : wolf);
            visited[l.ends] = false;
        }
    }


    public static class Leaf {
        int ends;
        int isWolf;

        public Leaf(int index, int isWolf) {
            this.ends = index;
            this.isWolf = isWolf;
        }
    }


}
