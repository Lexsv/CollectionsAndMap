package ua.com.CollectionsAndMap.domain.model.ListModel;

import java.util.Collections;
import java.util.LinkedList;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import ua.com.CollectionsAndMap.ui.presentation.PresentForList;

public class LinkedListModel {

    private int amountElements;
    private PresentForList present;

    public LinkedListModel(int amountElements, PresentForList present) {
        this.amountElements = amountElements;
        this.present = present;
    }
    public void start() {
        Flowable.fromCallable(() -> new LinkedList<>(Collections.nCopies(amountElements,1))
        ).observeOn(AndroidSchedulers.mainThread()).subscribe((list) -> {
            System.out.println("*******************LinkedList Fill******************* ");
            present.callbackFromListModel(list);
            present.startNextList();
        });
    }
}
