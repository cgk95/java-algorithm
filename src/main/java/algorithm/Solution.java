package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
public class Solution {
    public int numberOfCouplesSample(int n) {
        return (int)IntStream.rangeClosed(1,n).filter(i->n%i==0).boxed().count();
    }
    public int[] sortSample(int[] emergency) {
        ArrayList<int[]> arr = new ArrayList<>();
        int[] answer = new int[emergency.length];
        for (int i=0;i<emergency.length;i++) {
            arr.add(new int[] {emergency[i],i});
        }
        arr.sort((o1,o2)->o2[0]-o1[0]);
        for (int i=0;i<arr.size();i++) {
            answer[arr.get(i)[1]]=i+1;
        }
        return answer;
    }
    public int[] IntStreamSample01(int[] num_list) {
        return IntStream.rangeClosed(0, num_list.length - 1) // IntStream.rangeClosed 메서드를 사용하여 0부터 num_list.length-1 까지의 int 범위를 표현하는 Stream을 생성
                .map(i -> num_list[num_list.length - 1 - i]) // .map 메서드를 사용하여 Stream의 각 요소에 대해 num_list.length-1-i 인덱스의 값을 가져와서 새로운 Stream을 생성
                .toArray(); // .toArray 메서드를 사용하여 생성된 Stream을 int 배열로 변환하여 answer 변수에 저장
        // 최종적으로 생성된 int 배열은 주어진 num_list 배열의 순서가 뒤집어져 저장되어 있을 것
    }
    public String asciiToNumberSample(int age) {
        StringBuilder answer= new StringBuilder();
        for(char c:Integer.toString(age).toCharArray()){
            answer.append((char) ((int) c + 97));
        }
        return answer.toString();
    }
    public int[] streamSample(int[] numbers, int num1, int num2) {
        return Arrays.stream(numbers,num1,num2)
                .toArray();
    }
    public int IntStreamSample02(int n) {
        return IntStream.rangeClosed(0, n)
                .filter(e -> e % 2 == 0)
                .sum();
    }

}
