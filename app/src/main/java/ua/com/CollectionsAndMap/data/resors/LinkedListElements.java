package ua.com.CollectionsAndMap.data.resors;

import java.util.LinkedList;
import java.util.List;

public class LinkedListElements{

    private List<Integer> linkedList = new LinkedList<>();

    public LinkedListElements(int amountElements) {
        for (int i = 0; i < amountElements - 1; i++) {
            linkedList.add(i);
        }
    }

    public  LinkedList<Integer> getLinkedList() {
        return (LinkedList<Integer>) linkedList;
    }
}
