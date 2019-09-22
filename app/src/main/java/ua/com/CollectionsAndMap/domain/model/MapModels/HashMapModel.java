package ua.com.CollectionsAndMap.domain.model.MapModels;

import android.annotation.SuppressLint;

import java.util.HashMap;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ua.com.CollectionsAndMap.ui.presentation.PresentForMap;
import ua.com.CollectionsAndMap.ui.presentation.flag.TypeCollectin;

public class HashMapModel {

    private int amountElements;
    private PresentForMap present;


    public HashMapModel(int amountElements, PresentForMap present) {
        this.amountElements = amountElements;
        this.present = present;
    }
    @SuppressLint("CheckResult")
    public void start() {
        Flowable.fromCallable(() -> {
                    Byte b = 0;
                    Byte key = 1;
                    HashMap<Byte, Byte> hashMap = new HashMap<>(amountElements);
                    for (int i = 0; i < amountElements - 1; i++) {
                        hashMap.put(key, b);
                    }
                    return hashMap;
                })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe((list) -> {
            System.out.println("*******************HashMap Fill******************* ");
            present.callbackFromMapModel(list, TypeCollectin.HASH);
            present.startNext();
        });
    }


}
