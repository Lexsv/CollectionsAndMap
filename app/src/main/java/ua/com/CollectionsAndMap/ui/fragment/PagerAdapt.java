package ua.com.CollectionsAndMap.ui.fragment;


import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.HashMap;
import java.util.Map;

import butterknife.internal.Utils;


public class PagerAdapt extends FragmentStatePagerAdapter {

    private int tabNumb;
    private int amountElement ;

    public PagerAdapt(FragmentManager fm, int tabNumb) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.tabNumb = tabNumb;
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            TabCollection tabCollection = new TabCollection(amountElement);
            return tabCollection;
        }

        if (position == 1) {
            TabMap tabMap = new TabMap(amountElement);
            return tabMap;
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabNumb;
    }

    public void setAmountElement(int amountElement) {
        this.amountElement = amountElement;
    }




}


