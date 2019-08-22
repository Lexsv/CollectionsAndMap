package ua.com.CollectionsAndMap.data.resors;

import java.util.HashMap;
import java.util.Map;


public class HashMapElements {

    private Map<Integer,Integer> hashMap = new HashMap<>();

    public HashMapElements(int amountElements) {
        for (int i = 0; i < amountElements - 1; i++) {
            hashMap.put(i,i);
        }
    }

    public  HashMap<Integer,Integer> getHashMap() {
        return (HashMap<Integer, Integer>) hashMap;
    }
}