package ua.com.CollectionsAndMap.ui.presentation;

import android.content.Context;

import androidx.viewpager.widget.ViewPager;

import javax.inject.Inject;

import ua.com.CollectionsAndMap.ui.MainActivity;
import ua.com.CollectionsAndMap.ui.fragment.PagerAdapt;
import ua.com.CollectionsAndMap.ui.fragment.TabCollection;
import ua.com.CollectionsAndMap.ui.fragment.TabMap;


public  class MainPresent implements MainActivity.DataCalculation {

    private MainActivity activity;
    private  PresentForList presentForList;
    private  PresentForMap presentForMap;


    @Inject
    public MainPresent(Context activity) {
        this.activity = (MainActivity) activity;
    }

    public void build() {
        presentForList = new PresentForList(this);
        presentForList.setTabCollection((TabCollection) activity.getFragment(0));
        presentForMap = new PresentForMap(this);
        presentForMap.setTabMap((TabMap) activity.getFragment(1));

    }

    @Override
    public void onClickCalculation(int position) {
        activity.shoeProgress();
        if (position == 0) {
            presentForList.showDataView(activity.getAmoutElements());

        }
        if (position == 1) {
            presentForMap.showDataView(activity.getAmoutElements());
        }
    }

    public  void hidProgress(){
      activity.hidProgress();
    }

    public void onDestroy() {
        activity = null;
    }

}
