package ua.com.CollectionsAndMap.ui.presentation;


import java.util.HashMap;
import java.util.TreeMap;
import ua.com.CollectionsAndMap.domain.model.MapModels.HashMapModel;
import ua.com.CollectionsAndMap.domain.model.MapModels.TreeMapModel;
import ua.com.CollectionsAndMap.ui.fragment.TabMap;
import ua.com.CollectionsAndMap.ui.presentation.interfaceExpand.Presenter;
import ua.com.CollectionsAndMap.ui.presentation.interfaceExpand.ProgressBar;

public class PresentForMap implements Presenter {
    private TabMap tabMap;
    private int queue = 0;
    private int amountElements;
    ProgressBar progressBar;

    public PresentForMap (int amountElements, TabMap tabMap) {
        this.tabMap = tabMap;
        this.amountElements = amountElements;
        this.progressBar = tabMap;

    }

    @Override
    public void showDataView(int amountElements) {
        this.amountElements = amountElements;
        progressBar.shoeProgress();
            queue = 1;
            startNext();
    }


    @Override
    public void startNext() {
        if (queue == 0) {

            new TreeMapModel(amountElements, this).start();
        }
        if (queue == 1) {
            new HashMapModel(amountElements, this).start();
        }
        if (queue < 0) {
            progressBar.hidProgress();
        }
        queue--;
    }



    public void callbackFromMapModel(HashMap<Byte, Byte> list) {
        tabMap.fillResult(list);
    }

    public void callbackFromMapModel(TreeMap<Byte, Byte> list) {
        tabMap.fillResult(list);
    }

    @Override
    public void fillDataView (){
        //dataView.onRecycleView(saveView);
    }
}
