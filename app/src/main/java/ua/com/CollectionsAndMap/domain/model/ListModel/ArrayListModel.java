package ua.com.CollectionsAndMap.domain.model.ListModel;



import android.annotation.SuppressLint;

import java.util.ArrayList;
import java.util.Collections;
import io.reactivex.Flowable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ua.com.CollectionsAndMap.ui.presentation.flag.TypeCollectin;
import ua.com.CollectionsAndMap.ui.presentation.PresentForList;

public class ArrayListModel {

    private int amountElements;
    private PresentForList present;

    public ArrayListModel(int amountElements, PresentForList present) {
        this.amountElements = amountElements;
        this.present = present;
    }
    @SuppressLint("CheckResult")
    public void start() {
         Flowable.fromCallable(() -> new ArrayList<>(Collections.nCopies(amountElements, 1)))
                 .subscribeOn(Schedulers.newThread())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe((list) -> {
            System.out.println("*******************ArrayList Fill******************* ");
            present.callbackFromListModel(list, TypeCollectin.ARREY);
            present.startNext();
        });
    }

}
