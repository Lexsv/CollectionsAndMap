package ua.com.CollectionsAndMap.Data.resors;

import java.util.LinkedList;

public class LinkedListElements{

    private LinkedList linkedList = new LinkedList();

    public LinkedListElements(int amountElements) {
        for (int i = 0; i < amountElements - 1; i++) {
            linkedList.add(i);
        }
    }

    public LinkedList getLinkedList() {
        return linkedList;
    }
}
