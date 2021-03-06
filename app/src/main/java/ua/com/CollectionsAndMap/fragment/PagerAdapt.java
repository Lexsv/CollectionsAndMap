package ua.com.CollectionsAndMap.fragment;


import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;


public class PagerAdapt extends FragmentStatePagerAdapter {

    private int tabNumb;
    private BaseFragmen[] fragments = new BaseFragmen[2];

    public PagerAdapt(FragmentManager fm, int tabNumb) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.tabNumb = tabNumb;
    }

    @Override
    public BaseFragmen getItem(int position) {

        if (position == 0) {
           if (fragments[position] != null){return fragments[position];}
            TabCollection tabCollection = new TabCollection();
            fragments[position] = tabCollection;
            return tabCollection;
        }

        if (position == 1) {
            if (fragments[position] != null){return fragments[position];}
            TabMap tabMap = new TabMap();
            fragments[position] = tabMap;
            return tabMap;
        }
        return null;
    }
    @Override
    public int getCount() {
        return tabNumb;
    }

}


