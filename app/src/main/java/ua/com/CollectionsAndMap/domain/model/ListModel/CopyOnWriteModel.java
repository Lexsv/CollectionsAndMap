package ua.com.CollectionsAndMap.domain.model.ListModel;

import android.annotation.SuppressLint;

import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ua.com.CollectionsAndMap.ui.presentation.FlagList;
import ua.com.CollectionsAndMap.ui.presentation.PresentForList;

public class CopyOnWriteModel{

    private int amountElements;
    private PresentForList present;


    public CopyOnWriteModel(int amountElements, PresentForList present) {
        this.amountElements = amountElements;
        this.present = present;}

    @SuppressLint("CheckResult")
    public void start() {
        Flowable.fromCallable(() -> new CopyOnWriteArrayList<>(Collections.nCopies(amountElements,1)))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe((list) -> {
            System.out.println("*******************CopyOnWritList Fill******************* ");
            present.callbackFromListModel(list, FlagList.COPYONWRITE);
            present.startNext();
        });
    }
}
