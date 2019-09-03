package ua.com.CollectionsAndMap.domain.model.ListModel;

import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import ua.com.CollectionsAndMap.ui.presentation.PresentForList;

public class CopyOnWriteModel{

    private int amountElements;
    private PresentForList present;


    public CopyOnWriteModel(int amountElements, PresentForList present) {
        this.amountElements = amountElements;
        this.present = present;}

    public void start() {
        Flowable.fromCallable(() -> new CopyOnWriteArrayList<>(Collections.nCopies(amountElements,1))
        ).observeOn(AndroidSchedulers.mainThread()).subscribe((list) -> {
            System.out.println("*******************CopyOnWritList Fill******************* ");
            present.callbackFromListModel(list);
            present.startNextList();
        });
    }
}
