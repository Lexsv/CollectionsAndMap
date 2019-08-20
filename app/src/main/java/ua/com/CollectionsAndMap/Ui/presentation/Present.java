package ua.com.CollectionsAndMap.Ui.presentation;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import ua.com.CollectionsAndMap.Ui.fragment.PagerAdapt;
import ua.com.CollectionsAndMap.Ui.fragment.TabCollection;
import ua.com.CollectionsAndMap.Ui.fragment.TabMap;

public class Present {
    PagerAdapt pagerAdapt;

    public Present() {
    }


    public void setPagerAdapt(PagerAdapt pagerAdapt) {
        this.pagerAdapt = pagerAdapt;
    }

}
