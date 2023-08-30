package algorithm.GRAPH;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Programmers_방문길이 {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, -1, 0, 1};
    List<List<Point>> graph;
    int answer = 0;
    int sx = 5;
    int sy = 5;

    public int solution(String dirs) {
        graph = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            graph.add(new ArrayList<>());
            for (int j = 0; j < 11; j++) {
                graph.get(i).add(new Point(i, j));
            }
        }

        for (Character d : dirs.toCharArray()) {
            List<Integer> currOrg = new ArrayList<>(List.of(sx, sy));
            switch (d) {
                case 'U' -> {
                    int nx = sx + dx[0];
                    int ny = sy + dy[0];
                    move(nx, ny, currOrg);
                }
                case 'D' -> {
                    int nx = sx + dx[2];
                    int ny = sy + dy[2];
                    move(nx, ny, currOrg);
                }
                case 'L' -> {
                    int nx = sx + dx[3];
                    int ny = sy + dy[3];
                    move(nx, ny, currOrg);
                }
                case 'R' -> {
                    int nx = sx + dx[1];
                    int ny = sy + dy[1];
                    move(nx, ny, currOrg);
                }
                default -> throw new IllegalStateException("Unexpected value: " + d);
            }
        }

        return answer;
    }

    private void move(int nx, int ny, List<Integer> currOrg) {
        if (checkBoundary(nx, ny)) {
            Point next = graph.get(nx).get(ny);
            Point prev = graph.get(sx).get(sy);
            List<Integer> prevOrg = new ArrayList<>(List.of(nx, ny));
            if (next.visited.containsKey(currOrg) && !next.visited.get(currOrg) && prev.visited.containsKey(prevOrg) && !prev.visited.get(prevOrg)) {
                next.visited.put(currOrg, true);
                prev.visited.put(prevOrg, true);
                answer++;
            }
            sx = nx;
            sy = ny;
        }
    }

    private static boolean checkBoundary(int nx, int ny) {
        return 0 <= nx && 0 <= ny && nx < 11 && ny < 11;
    }

    public static class Point {
        int x, y;
        HashMap<List<Integer>, Boolean> visited = new HashMap<>();

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            makeEdge(x, y);
        }

        public void makeEdge(int x, int y) {
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (checkBoundary(nx, ny)) {
                    visited.put(new ArrayList<>(List.of(nx, ny)), false);
                }
            }
        }
    }

}
