package ua.com.CollectionsAndMap.Moduls;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

public class CopyOnWriteListElements implements Runnable {
    private int amountElements;
    private CopyOnWriteArrayList copyOnWriteArrayList;
    private CountDownLatch cd;


    public CopyOnWriteListElements(int amountElements, CopyOnWriteArrayList copyOnWriteArrayList,CountDownLatch cd) {
        this.amountElements = amountElements;
        this.copyOnWriteArrayList = copyOnWriteArrayList;
        this.cd = cd;

    }

    @Override
    public void run() {
        for (int i = 0; i < amountElements - 1 ; i++) {
            copyOnWriteArrayList.add(i);
        }
        cd.countDown();
    }
}
