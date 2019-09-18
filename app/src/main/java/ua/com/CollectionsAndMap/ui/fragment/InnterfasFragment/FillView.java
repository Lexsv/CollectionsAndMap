package ua.com.CollectionsAndMap.ui.fragment.InnterfasFragment;

import java.util.List;
import java.util.Map;

import ua.com.CollectionsAndMap.ui.presentation.flag.FlagList;
import ua.com.CollectionsAndMap.ui.presentation.flag.FlagMap;

public interface FillView {
    default void fillResult(List<Integer> list, FlagList flag){}
    default void fillResult(Map<Byte, Byte> map, FlagMap flag){}
}
