package ua.com.CollectionsAndMap.ui.presentation;

import androidx.viewpager.widget.ViewPager;

public class Present {

    private ViewPager viewPager;

    public Present(ViewPager viewPager) {
        this.viewPager = viewPager;
    }

    public void showDataView(int amountElements) {
        new AsyncFill(viewPager,amountElements).execute();
    }

}
