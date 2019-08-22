package ua.com.CollectionsAndMap.data.resors;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteListElements {

    private List<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();


    public CopyOnWriteListElements(int amountElements) {
        for (int i = 0; i < amountElements - 1; i++) {
            copyOnWriteArrayList.add(i);
        }
    }

    public CopyOnWriteArrayList<Integer> getCopyOnWriteArrayList() {
        return (CopyOnWriteArrayList<Integer>)copyOnWriteArrayList;
    }
}
