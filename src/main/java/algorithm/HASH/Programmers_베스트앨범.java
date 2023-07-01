package algorithm.HASH;

import java.util.*;

public class Programmers_베스트앨범 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500})));
    }

    public static int[] solution(String[] genres, int[] plays) {
        // 장르를 키값으로, 플레이수와 고유번호수를 매칭시킨 배열을 값으로 하는 리스트 생성
        HashMap<String, LinkedList<int[]>> genreNumber = new HashMap<>();
        ArrayList<Integer> topMusingList = new ArrayList<>();
        for (int i = 0; i < genres.length; i++) {
            if (genreNumber.containsKey(genres[i])) {
                genreNumber.get(genres[i]).add(new int[]{plays[i], i});
            } else {
                LinkedList<int[]> arr = new LinkedList<>();
                arr.add(new int[]{plays[i], i});
                genreNumber.put(genres[i], arr);
            }
        }
        // 속한 노래가 많이 재생된 장르를 우선으로 정렬
        LinkedList<Map.Entry<String, LinkedList<int[]>>> entries = new LinkedList<>(genreNumber.entrySet());
        entries.sort((o1, o2) -> {
            int sum1 = 0;
            int sum2 = 0;
            for (int[] arr : o1.getValue()) {
                sum1 += arr[0];
            }
            for (int[] arr : o2.getValue()) {
                sum2 += arr[0];
            }
            return sum2 - sum1;
        });

        // 정렬된 엔트리의 순서대로 두 개씩 뽑아서 정답 배열에 추가
        while (!entries.isEmpty()) {
            Map.Entry<String, LinkedList<int[]>> entry = entries.poll(); // 장르 하나를 뽑고
            LinkedList<int[]> playAndSong = entry.getValue(); // 장르 하나의 수록곡 리스트
            // 장르 내부의 수록곡을 재생수로 정렬
            playAndSong.sort((o1, o2) -> o2[0] - o1[0]);
            // 정렬이 되었으면
            int count = 0;
            while (!playAndSong.isEmpty()) {
                if (count >= 2) break;
                topMusingList.add(playAndSong.poll()[1]);
                count++;
            }
        }
        // 배열에 옮기기
        int[] answer = new int[topMusingList.size()];
        for (int i = 0; i < topMusingList.size(); i++) {
            answer[i] = topMusingList.get(i);
        }
        return answer;
    }
}
