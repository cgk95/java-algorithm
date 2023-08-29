package algorithm.IMPLEMENT;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Programmers_1차캐시 {
    int hit = 0;
    int miss = 0;

    public int solution(int cacheSize, String[] cities) {
        cities = Arrays.stream(cities).map(String::toLowerCase)
                .toArray(String[]::new);

        LRU<String, String> cache = LRU.newInstance(cacheSize);
        for (String city : cities) {
            if (cache.containsKey(city)) {
                cache.get(city);
                hit++;
                continue;
            }
            miss++;
            cache.put(city, city);
        }
        return hit + miss * 5;
    }
}


class LRU<K, V> extends LinkedHashMap<K, V> {
    private final int cacheSize;

    private LRU(int cacheSize) {
        super(cacheSize, 0.75f, true);
        this.cacheSize = cacheSize;
    }

    protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
        return size() > cacheSize;
    }

    public static <K, V> LRU<K, V> newInstance(int cacheSize) {
        return new LRU<>(cacheSize);
    }

}
