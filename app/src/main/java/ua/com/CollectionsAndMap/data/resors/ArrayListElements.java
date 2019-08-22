package ua.com.CollectionsAndMap.data.resors;

import java.util.ArrayList;
import java.util.List;

public class ArrayListElements  {

    private int amountElements;
    private List<Integer> arrayList = new ArrayList<>(amountElements);


    public ArrayListElements(int amountElements) {
        this.amountElements = amountElements;
        for (int i = 0; i < amountElements - 1; i++) {
            arrayList.add(i);
        }
    }

    public ArrayList<Integer> getArrayList() {
        return (ArrayList<Integer>) arrayList;
    }
}
