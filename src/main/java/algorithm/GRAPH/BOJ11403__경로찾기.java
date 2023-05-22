package algorithm.GRAPH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BOJ11403__경로찾기 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>(Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).boxed()
                    .collect(Collectors.toList())));
        }

        System.out.println("1");
    }
}
