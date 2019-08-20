package ua.com.CollectionsAndMap.Data.resors;

import java.util.HashMap;


public class HashMapElements {

    private HashMap hashMap = new HashMap();

    public HashMapElements(int amountElements) {

        for (int i = 0; i < amountElements - 1; i++) {
            hashMap.put(i,i);
        }
    }

    public HashMap getHashMap() {
        return hashMap;
    }
}