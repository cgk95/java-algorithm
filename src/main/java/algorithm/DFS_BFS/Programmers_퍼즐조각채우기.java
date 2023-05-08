package algorithm.DFS_BFS;

import java.util.*;

public class Programmers_퍼즐조각채우기 {
    class Point implements Comparable<Point> {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }

    int[] dx = {-1, 0, 1, 0}; // 상하
    int[] dy = {0, -1, 0, 1}; // 좌우
    int boardSize;
    ArrayList<ArrayList<Point>> empty = new ArrayList<>();
    ArrayList<ArrayList<Point>> block = new ArrayList<>();
    boolean[][] visited;

    public int solution(int[][] game_board, int[][] table) {
        boardSize = game_board.length;
        visited = new boolean[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (game_board[i][j] == 0 && !visited[i][j]) {
                    empty.add(check(game_board, i, j, 0));
                }
            }
        }
        for (int i = 0; i < boardSize; i++) {
            Arrays.fill(visited[i], false);
        }
        // 테이블의 블록 체크
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (table[i][j] == 1 && !visited[i][j])
                    block.add(check(table, i, j, 1));
            }
        }
        boolean[] visitedBoard = new boolean[empty.size()];
        int answer = 0;
        for (int i = 0; i < block.size(); i++) {
            ArrayList<Point> blockCheck = block.get(i);
            for (int j = 0; j < empty.size(); j++) {
                ArrayList<Point> emptyCheck = empty.get(j);
                // 빈 공간과 블록의 개수가 같고 방문한 적이 없는 곳일 경우
                if (emptyCheck.size() == blockCheck.size() && !visitedBoard[j]) {
                    // 빈 공간에 블록이 들어가는지 확인
                    if (isRotate(emptyCheck, blockCheck)) {
                        // 빈 공간에 블록이 들어간다면 answer에 블록 개수를 더함
                        answer += blockCheck.size();
                        visitedBoard[j] = true;
                        break;
                    }
                }
            }
        }
        return answer;
    }

    private boolean isRotate(ArrayList<Point> empty, ArrayList<Point> block) {
        // 90도씩 회전 시키기
        for (int i = 0; i < 4; i++) {
            int zeroX = block.get(0).x;
            int zeroY = block.get(0).y;

            // 회전시키면서 좌표가 달라지기 때문에 다시 (0, 0)을 기준으로 블록 좌표를 변경
            for (int j = 0; j < block.size(); j++) {
                block.get(j).x -= zeroX;
                block.get(j).y -= zeroY;
            }
            boolean isCollect = true;

            for (int j = 0; j < empty.size(); j++) {
                Point emptyPoint = empty.get(j);
                Point blockPoint = block.get(j);

                // 블록 좌표가 빈 공간의 좌표와 하나라도 다르면 중단
                if (emptyPoint.x != blockPoint.x || emptyPoint.y != blockPoint.y) {
                    isCollect = false;
                    break;
                }
            }
            if (isCollect) {
                return true;
            } else {
                // 90도 회전 : (x, y) -> (y, -x)
                for (int j = 0; j < block.size(); j++) {
                    int temp = block.get(j).x;

                    block.get(j).x = block.get(j).y;
                    block.get(j).y = -temp;
                }

                Collections.sort(block);
            }

        }

        return false;
    }

    private ArrayList<Point> check(int[][] gameBoard, int x, int y, int type) {
        Queue<Point> q = new LinkedList<>();
        ArrayList<Point> result = new ArrayList<>();
        q.add(new Point(x, y));
        visited[x][y] = true;
        // 빈 공간이나 블록의 첫 번째 좌표를 (0, 0)으로 함
        result.add(new Point(0, 0));
        while (!q.isEmpty()) {
            Point curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (nx >= 0 && nx < boardSize && ny >= 0 && ny < boardSize) {
                    if (!visited[nx][ny] && gameBoard[nx][ny] == type) {
                        q.add(new Point(nx, ny));
                        visited[nx][ny] = true;

                        // 기준이 (0, 0)이기 때문에 (nx - x, ny - y)를 리스트에 넣음
                        result.add(new Point(nx - x, ny - y));
                    }
                }

            }
        }
        Collections.sort(result);
        return result;
    }
}