package algorithm.DSU;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1043_거짓말 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] parent;
    static boolean[] knowsTruth;

    public static void main(String[] args) throws IOException {
        StringTokenizer NM = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(NM.nextToken());
        int M = Integer.parseInt(NM.nextToken());
        knowsTruth = new boolean[N + 1];
        parent = new int[N + 1];
        int answer = 0;
        for (int i = 0; i < N + 1; i++) {
            parent[i] = i;
        }
        //-- 진실을 아는 자--//
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        if (input[0] == 0) {
            System.out.print(M);
            return;
        }
        for (int i = 1; i < input.length; i++) {
            knowsTruth[input[i]] = true;
        }
        for (int i = 1; i < input.length - 1; i++) {
            unionParent(input[i], input[i + 1]);
        }
        //-- 파티별 멤버 입력--//
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int[] party = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 1; j < party.length - 1; j++) {
                unionParent(party[j], party[j + 1]);
            }
            list.add(party);
            // 그 파티에 진실을 아는 자가 참석하였다면
            boolean flag = true;
            for (int j = 1; j < party.length; j++) {
                if (knowsTruth[party[j]]) {
                    flag = false;
                    break;
                }
            }
            if (!flag) { // 진실을 이야기해야 하는 파티이므로 파티의 참석자들을 knowsTruth에 체크
                for (int j = 1; j < party.length; j++) {
                    knowsTruth[party[j]] = true;
                }
            }
        }

        for (int[] party : list) {
            if (!knowsTruth[findParent(parent, party[1])]) {
                answer++;
            }
        }
        System.out.print(answer);
    }

    private static int findParent(int[] parent, int idx) {
        if (parent[idx] == idx) {
            return idx;
        }
        return findParent(parent, parent[idx]);
    }

    private static void unionParent(int a, int b) {
        int parentA = findParent(parent, a);
        int parentB = findParent(parent, b);

        if (knowsTruth[parentA]) {
            parent[parentB] = parentA;
            return;
        } else if (knowsTruth[parentB]) {
            parent[parentA] = parentB;
            return;
        }

        if (parentA > parentB) {
            parent[parentA] = parentB;
        } else {
            parent[parentB] = parentA;
        }
    }

}
