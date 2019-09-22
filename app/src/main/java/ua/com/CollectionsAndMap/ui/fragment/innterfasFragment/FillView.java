package ua.com.CollectionsAndMap.ui.fragment.innterfasFragment;

import ua.com.CollectionsAndMap.domain.utils.FillView.ActionFill;
import ua.com.CollectionsAndMap.ui.presentation.flag.TypeCollectin;


public interface FillView {
    void fillResult(String s, TypeCollectin flagList, ActionFill flagAction);
}
