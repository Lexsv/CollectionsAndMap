package ua.com.CollectionsAndMap.Moduls;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class ArrayListElements implements Runnable {

    private int amountElements;
    private ArrayList arrayList;
    private CountDownLatch cd;


    public ArrayListElements(int amountElements, ArrayList arrayList, CountDownLatch cd) {
        this.amountElements = amountElements;
        this.arrayList = arrayList;
        this.cd = cd;


    }

    @Override
    public void run() {
        for (int i = 0; i < amountElements - 1; i++) {
            arrayList.add(i);
        }
        cd.countDown();
    }
}
