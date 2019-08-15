package ua.com.CollectionsAndMap.Utils;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class FillView {

    // List
    // ADD BEGIN
    public static long speedAddBeginToList(ArrayList arrayList) {
        long startTim = System.nanoTime();
        arrayList.add(0, 1);
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    public static long speedAddBeginToList(LinkedList linkedList) {
        long startTim = System.nanoTime();
        linkedList.addFirst(1);
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    public static long speedAddBeginToList(CopyOnWriteArrayList copyOnWriteArrayList) {
        long startTim = System.nanoTime();
        copyOnWriteArrayList.add(0, 1);
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    // List
    // ADD MIDDLE

    public static long speedAddMiddleToList(ArrayList arrayList) {
        long startTim = System.nanoTime();
        arrayList.add(arrayList.size() / 2, 1);
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    public static long speedAddMiddleToList(LinkedList linkedList) {
        long startTim = System.nanoTime();
        linkedList.add(linkedList.size() / 2, 1);
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    public static long speedAddMiddleToList(CopyOnWriteArrayList copyOnWriteArrayList) {
        long startTim = System.nanoTime();
        copyOnWriteArrayList.add(copyOnWriteArrayList.size() / 2, 1);
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    // List
    // ADD END

    public static long speedAddEndToList(ArrayList arrayList) {
        long startTim = System.nanoTime();
        arrayList.add(arrayList.size() - 1, 1);
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    public static long speedAddEndToList(LinkedList linkedList) {
        long startTim = System.nanoTime();
        linkedList.addLast(1);
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    public static long speedAddEndToList(CopyOnWriteArrayList copyOnWriteArrayList) {
        long startTim = System.nanoTime();
        copyOnWriteArrayList.add(copyOnWriteArrayList.size() - 1, 1);
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    // List
    // Search
    public static long speedSearchInList(ArrayList arrayList) {
        long startTim = System.nanoTime();
        arrayList.get(new Random().nextInt(arrayList.size()));
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    public static long speedSearchInList(LinkedList linkedList) {
        long startTim = System.nanoTime();
        linkedList.get(new Random().nextInt(linkedList.size()));
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    public static long speedSearchInList(CopyOnWriteArrayList copyOnWriteArrayList) {
        long startTim = System.nanoTime();
        copyOnWriteArrayList.get(new Random().nextInt(copyOnWriteArrayList.size()));
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    // List
    // Remove Begin
    public static long speedRemoveBeginToList(ArrayList arrayList) {
        long startTim = System.nanoTime();
        arrayList.remove(0);
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    public static long speedRemoveBeginToList(LinkedList linkedList) {
        long startTim = System.nanoTime();
        linkedList.removeFirst();
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    public static long speedRemoveBeginToList(CopyOnWriteArrayList copyOnWriteArrayList) {
        long startTim = System.nanoTime();
        copyOnWriteArrayList.remove(0);
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    // List
    // Remove Middle
    public static long speedRemoveMiddleToList(ArrayList arrayList) {
        long startTim = System.nanoTime();
        arrayList.remove(arrayList.size() / 2);
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    public static long speedRemoveMiddleToList(LinkedList linkedList) {
        long startTim = System.nanoTime();
        linkedList.remove(linkedList.size() / 2);
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    public static long speedRemoveMiddleToList(CopyOnWriteArrayList copyOnWriteArrayList) {
        long startTim = System.nanoTime();
        copyOnWriteArrayList.remove(copyOnWriteArrayList.size() / 2);
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    // List
    // Remove End
    public static long speedRemoveEndToList(ArrayList arrayList) {
        long startTim = System.nanoTime();
        arrayList.remove(arrayList.size() - 1);
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    public static long speedRemoveEndToList(LinkedList linkedList) {
        long startTim = System.nanoTime();
        linkedList.removeLast();
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    public static long speedRemoveEndToList(CopyOnWriteArrayList copyOnWriteArrayList) {
        long startTim = System.nanoTime();
        copyOnWriteArrayList.remove(copyOnWriteArrayList.size() - 1);
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    //Map
    //ADD
    public static long speedAddToMap(TreeMap treeMap) {
        long startTim = System.nanoTime();
        treeMap.put(1, 1);
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    public static long speedAddToMap(HashMap hashMap) {
        long startTim = System.nanoTime();
        hashMap.put(1, 1);
        long result = System.nanoTime() - startTim;
        return result / 1000;

    }
    //Map
    //Search

    public static long speedSearchInMap(TreeMap treeMap) {
        long startTim = System.nanoTime();
        treeMap.get(1);
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    public static long speedSearchInMap(HashMap hashMap) {
        long startTim = System.nanoTime();
        hashMap.get(1);
        long result = System.nanoTime() - startTim;
        return result / 1000;

    }

    //Map
    //Remov
    public static long speedRemovInMap(TreeMap treeMap) {
        long startTim = System.nanoTime();
        treeMap.remove(0);
        long result = System.nanoTime() - startTim;
        return result / 1000;
    }

    public static long speedRemovInMap(HashMap hashMap) {
        long startTim = System.nanoTime();
        hashMap.remove(0);
        long result = System.nanoTime() - startTim;
        return result / 1000;


    }
}