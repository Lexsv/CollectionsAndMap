package ua.com.CollectionsAndMap.utils;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class FillView {

    // List
    // ADD BEGIN
    public static long speedAddBeginToList(ArrayList<Integer> arrayList) {
        long startTim = System.nanoTime();
        arrayList.add(0, 1);
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    public static long speedAddBeginToList(LinkedList<Integer> linkedList) {
        long startTim = System.nanoTime();
        linkedList.addFirst(1);
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    public static long speedAddBeginToList(CopyOnWriteArrayList<Integer> copyOnWriteArrayList) {
        long startTim = System.nanoTime();
        copyOnWriteArrayList.add(0, 1);
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    // List
    // ADD MIDDLE

    public static long speedAddMiddleToList(ArrayList<Integer> arrayList) {
        long startTim = System.nanoTime();
        arrayList.add(arrayList.size() / 2, 1);
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    public static long speedAddMiddleToList(LinkedList<Integer> linkedList) {
        long startTim = System.nanoTime();
        linkedList.add(linkedList.size() / 2, 1);
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    public static long speedAddMiddleToList(CopyOnWriteArrayList<Integer> copyOnWriteArrayList) {
        long startTim = System.nanoTime();
        copyOnWriteArrayList.add(copyOnWriteArrayList.size() / 2, 1);
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    // List
    // ADD END

    public static long speedAddEndToList(ArrayList<Integer> arrayList) {
        long startTim = System.nanoTime();
        arrayList.add(arrayList.size() - 1, 1);
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    public static long speedAddEndToList(LinkedList<Integer> linkedList) {
        long startTim = System.nanoTime();
        linkedList.addLast(1);
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    public static long speedAddEndToList(CopyOnWriteArrayList<Integer> copyOnWriteArrayList) {
        long startTim = System.nanoTime();
        copyOnWriteArrayList.add(copyOnWriteArrayList.size() - 1, 1);
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    // List
    // Search
    public static long speedSearchInList(ArrayList<Integer> arrayList) {
        long startTim = System.nanoTime();
        arrayList.get(new Random().nextInt(arrayList.size()));
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    public static long speedSearchInList(LinkedList<Integer> linkedList) {
        long startTim = System.nanoTime();
        linkedList.get(new Random().nextInt(linkedList.size()));
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    public static long speedSearchInList(CopyOnWriteArrayList<Integer> copyOnWriteArrayList) {
        long startTim = System.nanoTime();
        copyOnWriteArrayList.get(new Random().nextInt(copyOnWriteArrayList.size()));
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    // List
    // Remove Begin
    public static long speedRemoveBeginToList(ArrayList<Integer> arrayList) {
        long startTim = System.nanoTime();
        arrayList.remove(0);
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    public static long speedRemoveBeginToList(LinkedList<Integer> linkedList) {
        long startTim = System.nanoTime();
        linkedList.removeFirst();
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    public static long speedRemoveBeginToList(CopyOnWriteArrayList<Integer> copyOnWriteArrayList) {
        long startTim = System.nanoTime();
        copyOnWriteArrayList.remove(0);
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    // List
    // Remove Middle
    public static long speedRemoveMiddleToList(ArrayList<Integer> arrayList) {
        long startTim = System.nanoTime();
        arrayList.remove(arrayList.size() / 2);
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    public static long speedRemoveMiddleToList(LinkedList<Integer> linkedList) {
        long startTim = System.nanoTime();
        linkedList.remove(linkedList.size() / 2);
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    public static long speedRemoveMiddleToList(CopyOnWriteArrayList<Integer> copyOnWriteArrayList) {
        long startTim = System.nanoTime();
        copyOnWriteArrayList.remove(copyOnWriteArrayList.size() / 2);
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    // List
    // Remove End
    public static long speedRemoveEndToList(ArrayList<Integer> arrayList) {
        long startTim = System.nanoTime();
        arrayList.remove(arrayList.size() - 1);
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    public static long speedRemoveEndToList(LinkedList<Integer> linkedList) {
        long startTim = System.nanoTime();
        linkedList.removeLast();
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    public static long speedRemoveEndToList(CopyOnWriteArrayList<Integer> copyOnWriteArrayList) {
        long startTim = System.nanoTime();
        copyOnWriteArrayList.remove(copyOnWriteArrayList.size() - 1);
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    //Map
    //ADD
    public static long speedAddToMap(TreeMap<Integer,Integer> treeMap) {
        long startTim = System.nanoTime();
        treeMap.put(1, 1);
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    public static long speedAddToMap(HashMap<Integer,Integer> hashMap) {
        long startTim = System.nanoTime();
        hashMap.put(1, 1);
        long result = System.nanoTime() - startTim;
        return result / 1000;

    }
    //Map
    //Search

    public static long speedSearchInMap(TreeMap<Integer,Integer> treeMap) {
        long startTim = System.nanoTime();
        treeMap.get(new Random().nextInt(treeMap.size()));
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    public static long speedSearchInMap(HashMap<Integer,Integer> hashMap) {
        long startTim = System.nanoTime();
        hashMap.get(new Random().nextInt(hashMap.size()));
        long result = System.nanoTime() - startTim;
        return result / 1000;

    }

    //Map
    //Remov
    public static long speedRemovInMap(TreeMap<Integer,Integer> treeMap) {
        long startTim = System.nanoTime();
        treeMap.remove(0);
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    public static long speedRemovInMap(HashMap<Integer,Integer> hashMap) {
        long startTim = System.nanoTime();
        hashMap.remove(0);
        long result = System.nanoTime() - startTim;
        return result / 1000;


    }
}