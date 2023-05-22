package algorithm.HASH;

import java.util.*;

public class Programmers_할인행사 {
    static int answer;
    public int solution(String[] want, int[] number, String[] discount) {
        final int windowSize = Arrays.stream(number).sum();
        answer = 0;

        List<String> discountList = new ArrayList<>(List.of(discount));

        for (int i = 0; i < discountList.size() - windowSize + 1; i++) {
            List<String> subList = discountList.subList(i, i + windowSize);
            if(checkShoppingBag(subList,makeShoppingList(want, number))){
                answer++;
            }
        }
        return answer;
    }
    private boolean checkShoppingBag(List<String> subList, HashMap<String,Integer> shoppingBag){
        HashMap<String, Integer> checkMap = new HashMap<>();
        for (String item : subList) {
            checkMap.computeIfPresent(item, (k, v) -> v + 1);
            checkMap.putIfAbsent(item, 1);
        }
        return checkMap.equals(shoppingBag);
    }
    private HashMap<String, Integer> makeShoppingList(String[] want, int[] number) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            hashMap.put(want[i], number[i]);
        }
        return hashMap;
    }
}
