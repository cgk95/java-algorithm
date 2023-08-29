package algorithm.IMPLEMENT;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;

public class Programmers_1차캐시 {
    int hit = 0;
    int miss = 0;

    public int solution(int cacheSize, String[] cities) {
        //-- cache size == 0 --//
        if (cacheSize == 0) {
            return 5 * cities.length;
        }

        cities = Arrays.stream(cities)
                .map(String::toLowerCase)
                .toArray(String[]::new);

        Hashtable<String, Integer> cache = new Hashtable<>(cacheSize);

        for (String city : cities) {

            if (!cache.isEmpty()) {
                for (String key : cache.keySet()) {
                    cache.computeIfPresent(key, (k, v) -> v + 1);
                }
            }
            //-- cache hit --//
            if (cache.containsKey(city)) {
                cache.put(city, 0);
                hit++;
                continue;
            }
            //-- cache miss --//
            miss++;

            if (cache.size() < cacheSize) { // 캐시 사이즈 확인 :: 캐시 용량이 남는다면
                cache.put(city, 0);
                continue;
            }
            // 용량이 부족하다면 최근에 가장 적게 사용된 데이터를 제거
            String maxKey = "";
            int maxCount = -1;
            for (Map.Entry<String, Integer> entry : cache.entrySet()) {
                if (maxCount < entry.getValue()) {
                    maxKey = entry.getKey();
                    maxCount = entry.getValue();
                }
            }
            cache.remove(maxKey);
            // 이후 현재 도시를 캐시에 추가
            cache.put(city, 0);
        }

        return miss * 5 + hit;
    }
}
