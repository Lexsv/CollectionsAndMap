package ua.com.CollectionsAndMap.domain.model.MapModels;

import java.util.TreeMap;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import ua.com.CollectionsAndMap.ui.presentation.PresentForMap;

public class TreeMapModel {

    private int amountElements;
    private PresentForMap present;


    public TreeMapModel(int amountElements, PresentForMap present) {
        this.amountElements = amountElements;
        this.present = present;
    }

    public void start() {
        Flowable.fromCallable(() -> {
            Byte b = 0;
            Byte key = 1;
            TreeMap<Byte,Byte> treeMap = new TreeMap<>();
            for (int i = 0; i < amountElements - 1; i++) {
                treeMap.put(key,b);
            }
            return  treeMap;
                }
        ).observeOn(AndroidSchedulers.mainThread()).subscribe((list) -> {
            System.out.println("*******************HashMap Fill******************* ");
            present.callbackFromMapModel(list);
            present.startNextMap();
        });
    }

}
