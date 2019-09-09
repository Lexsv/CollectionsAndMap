package ua.com.CollectionsAndMap.ui.presentation;

import android.content.Context;
import androidx.viewpager.widget.ViewPager;
import javax.inject.Inject;
import ua.com.CollectionsAndMap.ui.MainActivity;
import ua.com.CollectionsAndMap.ui.fragment.PagerAdapt;
import ua.com.CollectionsAndMap.ui.fragment.TabCollection;
import ua.com.CollectionsAndMap.ui.fragment.TabMap;


public final class MainPresent implements MainActivity.DataCalculation {

    private MainActivity activity;
    private static PresentForList presentForList;
    private static PresentForMap presentForMap;


    @Inject
    public MainPresent(Context activity) {
        this.activity = (MainActivity)activity;
    }
    public void build (){
        if (presentForList == null){presentForList = new PresentForList();}
        if (presentForMap == null) {presentForMap = new PresentForMap();}
        presentForList.setTabCollection((TabCollection) activity.getFragment(0));
        presentForMap.setTabMap((TabMap) activity.getFragment(1));
    }

    @Override
    public void onClickCalculation(int position) {
        if (position == 0) {presentForList.showDataView(activity.getAmoutElements());}
        if (position == 1) {presentForMap.showDataView(activity.getAmoutElements());}
    }

    @Override
    public void upData() {
        presentForList.fillDataView();
        presentForMap.fillDataView();
    }


    public void onDestroy() {
        activity = null;
    }

}
