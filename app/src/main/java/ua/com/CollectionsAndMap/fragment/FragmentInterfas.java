package ua.com.CollectionsAndMap.fragment;

import androidx.lifecycle.LifecycleOwner;

import ua.com.CollectionsAndMap.domain.TypeRow;


public interface FragmentInterfas {
    void fillResult(String s, TypeRow typeRow);
    LifecycleOwner getOwn ();
}
