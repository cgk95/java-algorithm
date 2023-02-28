package algorithm.KRUSKAL;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//서로소 집합으로
// 쓰러지는 녀석들의 최소 불안정도 계산
public class 불안정도 {
    public int solution(int[] position, int[] height, int m) { // 기둥들의 위치, 높이, 제거할 기둥의 개수
        int[] parent = new int[position.length + 1];
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        int[] dangerRange = new int[position.length + 1];
        for (int i = 0; i < position.length; i++) {
            dangerRange[i + 1] = position[i] + height[i];
        }
        // parent 업데이트
        for (int i = 1; i < dangerRange.length; i++) { // i번째 기둥의 위험범위 안에
            for (int j = 0; j < position.length; j++) {
                if (position[i - 1] < position[j] && position[j] <= dangerRange[i]) { // j번째 기둥이 있다면
                    if (parent[j + 1] > i) {
                        parent[j + 1] = i;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(parent));

        // m번 만큼 반복
        while(m>0){
            List<Map.Entry<Integer, Integer>> entries = computMaxInstablity(parent);
            int maxInstablity=entries.get(0).getKey();

            for (int i = 1; i < parent.length; i++) { // 불안정도가 가장 높은 녀석 제거 :: 트리의 깊이가 가장 깊은 녀석을 제거해야
                if(parent[i]==maxInstablity){
                    parent[i]=i;
                }
            }
            m--;
        }

        return computMaxInstablity(parent).get(0).getKey();
    }

    private static List<Map.Entry<Integer, Integer>> computMaxInstablity(int[] parent) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < parent.length; i++) {
            map.computeIfPresent(parent[i], (k, v) -> v + 1);
            map.putIfAbsent(parent[i], 1);
        }

        return map.entrySet()
                .stream()
                .sorted(((o1, o2) -> {
                    if (o2.getValue() == o1.getValue()) {
                        return o1.getKey() - o2.getKey();
                    }
                    return o2.getValue() - o1.getValue();
                })).limit(1).collect(Collectors.toList());
    }

    private int findParent(int[] parent, int k) {
        if (parent[k] == k) return k;
        return findParent(parent, parent[k]);
    }

    private void unionParent(int[] parent, int a, int b) {
        int a_parent = findParent(parent, a);
        int b_parent = findParent(parent, b);
        if (a_parent > b_parent) {
            parent[a_parent] = b_parent;
        } else {
            parent[b_parent] = a_parent;
        }
    }
}
