package ua.com.CollectionsAndMap.ui.presentation;

import android.content.Context;

import androidx.viewpager.widget.ViewPager;


import java.util.ArrayList;
import java.util.List;


import javax.inject.Inject;

import ua.com.CollectionsAndMap.ui.MainActivity;
import ua.com.CollectionsAndMap.ui.fragment.PagerAdapt;
import ua.com.CollectionsAndMap.ui.fragment.TabCollection;
import ua.com.CollectionsAndMap.ui.fragment.TabMap;
import ua.com.CollectionsAndMap.ui.presentation.interfaceExpand.Presenter;

public final class MainPresent implements MainActivity.ClickCalculation {

    private MainActivity activity;
    static private List<Presenter> presenterList = new ArrayList<>();
    private ViewPager viewPager;


    @Inject
    public MainPresent(Context activity) {
        this.activity = (MainActivity)activity;
    }

    @Override
    public void onClickCalculation() {
        viewPager = activity.getViewPager();
        if (viewPager.getCurrentItem() == 0) {
            PagerAdapt pagerAdapt = (PagerAdapt) viewPager.getAdapter();
            TabCollection tabCollection = (TabCollection) pagerAdapt.getItem(viewPager.getCurrentItem());
            PresentForList presentForList = new PresentForList(activity.getAmoutElements(), tabCollection);
            presenterList.add(0,presentForList);
            presentForList.showDataView(activity.getAmoutElements());
        }
        if (viewPager.getCurrentItem() == 1) {
            PagerAdapt pagerAdapt = (PagerAdapt) viewPager.getAdapter();
            TabMap tabMap = (TabMap) pagerAdapt.getItem(viewPager.getCurrentItem());
            PresentForMap presentForMap = new PresentForMap(activity.getAmoutElements(), tabMap);
            presenterList.add(0,presentForMap);
            presentForMap.showDataView(activity.getAmoutElements());

        }
    }

    @Override
    public void upData() {
        presenterList.get(0).fillDataView();
        presenterList.get(1).fillDataView();
    }


    public void setViewPager(ViewPager viewPager) {
        this.viewPager = viewPager;
    }

    public void onDestroy() {
        activity = null;
    }

}
