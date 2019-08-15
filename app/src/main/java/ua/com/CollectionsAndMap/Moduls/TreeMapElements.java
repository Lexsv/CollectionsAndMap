package ua.com.CollectionsAndMap.Moduls;

import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;

public class TreeMapElements implements Runnable {
    private int amountElements;
    private TreeMap treeMap;
    private CountDownLatch cd;

    public TreeMapElements(int amountElements, TreeMap treeMap, CountDownLatch cd) {
        this.amountElements = amountElements;
        this.treeMap = treeMap;
        this.cd = cd;
    }

    @Override
    public void run() {
        for (int i = 0; i < amountElements - 1; i++) {
           treeMap.put(i,i);
        }
        cd.countDown();


    }
}
