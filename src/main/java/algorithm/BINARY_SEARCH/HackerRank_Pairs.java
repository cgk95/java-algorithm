package algorithm.BINARY_SEARCH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class HackerRank_Pairs {
    public static int pairs(int k, List<Integer> arr) {
        Collections.sort(arr);
        int[] target = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            target[i] = arr.get(i);
        }
        int answer = 0;
        for (int i = 0; i < arr.size(); i++) {
            int find = target[i] - k;
            int idx = Arrays.binarySearch(target, find); // 원하는 값이 배열 안에 없을 경우 -1이 아니라 배열에서 자기 차리를 찾아서 음수로 반환
            if (idx >= 0 && idx <= target.length - 1) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = HackerRank_Pairs.pairs(k, arr);

        bufferedReader.close();
    }
}


