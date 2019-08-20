package ua.com.CollectionsAndMap.Data.resors;

import java.util.ArrayList;

public class ArrayListElements  {

    private int amountElements;
    private ArrayList arrayList = new ArrayList(amountElements);


    public ArrayListElements(int amountElements) {
        this.amountElements = amountElements;
        for (int i = 0; i < amountElements - 1; i++) {
            arrayList.add(i);
        }
    }

    public ArrayList getArrayList() {
        return arrayList;
    }
}
