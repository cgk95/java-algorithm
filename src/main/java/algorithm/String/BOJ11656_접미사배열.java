package algorithm.String;

import algorithm.Application;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ11656_접미사배열 implements Application {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> suffix = new ArrayList<>();

    public static void main(String[] args) {
        String input = sc.nextLine();
        for (int i = 0; i < input.length(); i++) {
            suffix.add(input.substring(i));
        }
        suffix.sort(String::compareTo);
        for (String s : suffix) {
            System.out.println(s);
        }
    }
}
