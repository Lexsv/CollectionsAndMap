package ua.com.CollectionsAndMap.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ua.com.CollectionsAndMap.CollOrMap;


public class FillCollection {
    private FillCollection() {
    }

    public static Flowable getFlowableCollection(int amountElements, CollOrMap typeCollectin) {


        if (typeCollectin == CollOrMap.ARREY) {
            return Flowable.fromCallable(() -> new ArrayList<>(Collections.nCopies(amountElements, 1)))
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread());
        }

        if (typeCollectin == CollOrMap.COPYONWRITE) {
            return Flowable.fromCallable(() -> new CopyOnWriteArrayList<>(Collections.nCopies(amountElements, 1)))
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread());
        }

        if (typeCollectin == CollOrMap.LINKED) {
            return Flowable.fromCallable(() -> new LinkedList<>(Collections.nCopies(amountElements, 1)))
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread());
        }

        if (typeCollectin == CollOrMap.HASH) {
            return Flowable.fromCallable(() -> {
                Byte b = 0;
                Byte key = 1;
                HashMap<Byte, Byte> hashMap = new HashMap<>(amountElements);
                for (int i = 0; i < amountElements - 1; i++) {
                    hashMap.put(key, b);
                }
                return hashMap;
            })
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread());
        }

        if (typeCollectin == CollOrMap.TREE) {
            return Flowable.fromCallable(() -> {
                        Byte b = 0;
                        Byte key = 1;
                        TreeMap<Byte, Byte> treeMap = new TreeMap<>();
                        for (int i = 0; i < amountElements - 1; i++) {
                            treeMap.put(key, b);
                        }
                        return treeMap;
                    }
            )
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread());
        }


        return null;
    }

}

