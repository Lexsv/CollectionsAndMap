package ua.com.CollectionsAndMap.ui.fragment.innterfasFragment;

import androidx.lifecycle.LifecycleOwner;

import ua.com.CollectionsAndMap.data.TypeRow;
import ua.com.CollectionsAndMap.domain.utils.FillView.ActionFill;
import ua.com.CollectionsAndMap.ui.presentation.flag.TypeCollectin;


public interface FillView {
    void fillResult(String s, TypeRow typeRow);
    LifecycleOwner getOwn ();
}
