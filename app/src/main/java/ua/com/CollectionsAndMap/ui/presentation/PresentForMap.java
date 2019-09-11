package ua.com.CollectionsAndMap.ui.presentation;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import ua.com.CollectionsAndMap.domain.model.MapModels.HashMapModel;
import ua.com.CollectionsAndMap.domain.model.MapModels.TreeMapModel;
import ua.com.CollectionsAndMap.ui.MainActivity;
import ua.com.CollectionsAndMap.ui.fragment.TabMap;
import ua.com.CollectionsAndMap.ui.presentation.interfaceExpand.Presenter;

public class PresentForMap implements Presenter {

    private TabMap tabMap;
    private int queue = 0;
    private int amountElements;
    private MainPresent mainPresent;

    public PresentForMap(MainPresent mainPresent) {
        this.mainPresent = mainPresent;
    }

    private static Map<Integer,String> saveView = new HashMap<>();

    public static Map<Integer, String> getSaveView() {
        return saveView;
    }


    public void showDataView(int amountElements) {
        this.amountElements = amountElements;
            queue = 1;
            startNext();
    }



    public void startNext() {
        if (queue == 0) {

            new TreeMapModel(amountElements, this).start();
        }
        if (queue == 1) {
            new HashMapModel(amountElements, this).start();
        }
        if (queue < 0) {
            mainPresent.hidProgress();
            saveView = tabMap.getSaveData();
        }
        queue--;
    }



    public void callbackFromMapModel(HashMap<Byte, Byte> list) {
        tabMap.fillResult(list);
    }

    public void callbackFromMapModel(TreeMap<Byte, Byte> list) {
        tabMap.fillResult(list);
    }



    public void setTabMap(TabMap tabMap) {
        this.tabMap = tabMap;
    }
}
