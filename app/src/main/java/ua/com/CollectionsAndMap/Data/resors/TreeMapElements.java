package ua.com.CollectionsAndMap.Data.resors;

import java.util.TreeMap;

public class TreeMapElements {

    private TreeMap treeMap = new TreeMap();


    public TreeMapElements(int amountElements) {
        for (int i = 0; i < amountElements - 1; i++) {
            treeMap.put(i,i);
        }
    }
    public TreeMap getTreeMap() {
        return treeMap;
    }
}
