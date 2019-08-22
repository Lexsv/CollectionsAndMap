package ua.com.CollectionsAndMap.data.resors;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapElements {

    private Map<Integer,Integer> treeMap = new TreeMap<>();


    public TreeMapElements(int amountElements) {
        for (int i = 0; i < amountElements - 1; i++) {
            treeMap.put(i,i);
        }
    }
    public TreeMap<Integer,Integer>getTreeMap() {
        return (TreeMap<Integer,Integer> )treeMap;
    }
}
