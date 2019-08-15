package ua.com.CollectionsAndMap.Moduls;

import java.util.HashMap;

import java.util.concurrent.CountDownLatch;

public class HashMapElements implements Runnable {
    private int amountElements;
    private HashMap hashMap;
    private CountDownLatch cd;

    public HashMapElements(int amountElements, HashMap hashMap, CountDownLatch cd) {
        this.amountElements = amountElements;
        this.hashMap = hashMap;
        this.cd = cd;
    }

    @Override
    public void run() {
        for (int i = 0; i < amountElements - 1; i++) {
            hashMap.put(i,i);
        }
        cd.countDown();

    }
}