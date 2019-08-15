package ua.com.CollectionsAndMap.Moduls;

import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;

public class LinkedListElements implements Runnable {

    private int amountElements;
    private LinkedList linkedList;
    private CountDownLatch cd;


    public LinkedListElements(int amountElements, LinkedList linkedList,CountDownLatch cd) {
        this.amountElements = amountElements;
        this.linkedList = linkedList;
        this.cd = cd;

    }

    @Override
    public void run() {
        for (int i = 0; i < amountElements - 1; i++) {
            linkedList.add(i);
        }
        cd.countDown();
    }
}
