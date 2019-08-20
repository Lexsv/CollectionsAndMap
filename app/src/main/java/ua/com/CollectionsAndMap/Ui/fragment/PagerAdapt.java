package ua.com.CollectionsAndMap.Ui.fragment;

import android.util.SparseArray;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;


public class PagerAdapt extends FragmentStatePagerAdapter {

    private int tabNumb;


    public PagerAdapt(FragmentManager fm, int tabNumb) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.tabNumb = tabNumb;
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            TabCollection tabCollection = new TabCollection();
            return tabCollection;
        }

        if (position == 1) {
            TabMap tabMap = new TabMap();
            return tabMap;
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabNumb;
    }

}


