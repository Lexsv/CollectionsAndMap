package ua.com.CollectionsAndMap.domain.model.ListModel;



import java.util.ArrayList;
import java.util.Collections;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import ua.com.CollectionsAndMap.ui.presentation.PresentForList;

public class ArrayListModel {

    private int amountElements;
    private PresentForList present;

    public ArrayListModel(int amountElements, PresentForList present) {
        this.amountElements = amountElements;
        this.present = present;
    }
    public void start() {
        Flowable.fromCallable(() -> new ArrayList<>(Collections.nCopies(amountElements, 1))
        ).observeOn(AndroidSchedulers.mainThread()).subscribe((list) -> {
            System.out.println("*******************ArrayList Fill******************* ");
            present.callbackFromListModel(list);
            present.startNextList();
        });
    }

}
