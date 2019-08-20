package ua.com.CollectionsAndMap.Data.resors;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteListElements {

    private CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();


    public CopyOnWriteListElements(int amountElements) {
        for (int i = 0; i < amountElements - 1; i++) {
            copyOnWriteArrayList.add(i);
        }
    }

    public CopyOnWriteArrayList getCopyOnWriteArrayList() {
        return copyOnWriteArrayList;
    }
}
