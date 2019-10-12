package ua.com.CollectionsAndMap.ui.mainaactivity;

import androidx.lifecycle.ViewModel;

import ua.com.CollectionsAndMap.ui.presentation.MainPresent;
import ua.com.CollectionsAndMap.ui.presentation.PresentForList;
import ua.com.CollectionsAndMap.ui.presentation.PresentForMap;

public class MainViewModul extends ViewModel {
    private static MainViewModul mainViewModul;
    public boolean progress = false;
    private MainPresent mainPresent;
    private PresentForMap presentForMap;
    private PresentForList presentForList;

    public void setPresentForMap(PresentForMap presentForMap) {
        this.presentForMap = presentForMap;
    }

    public void setPresentForList(PresentForList presentForList) {
        this.presentForList = presentForList;
    }

    public PresentForMap getPresentForMap() {
        return presentForMap;
    }

    public PresentForList getPresentForList() {
        return presentForList;
    }

    public void setMainPresent(MainPresent mainPresent) {
        this.mainPresent = mainPresent;

    }

    public MainPresent getMainPresent() {
        return mainPresent;
    }

    private MainViewModul() {
    }

    public static MainViewModul getMainViewModul(){
        if(mainViewModul == null){mainViewModul = new MainViewModul();}
        return mainViewModul;
    }


}
