package ua.com.CollectionsAndMap.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.HashMap;
import java.util.Map;

import ua.com.CollectionsAndMap.domain.utils.FillView;
import ua.com.CollectionsAndMap.domain.utils.FillView.ActionFill;
import ua.com.CollectionsAndMap.ui.presentation.flag.TypeCollectin;


public  class StatData extends ViewModel {
    private static StatData statData;
    private  boolean statusProgr = false;

    private Map<ActionFill, String> arreyMap = new HashMap<>();
    private Map<ActionFill, String> lincMap = new HashMap<>();
    private Map<ActionFill, String> copyMap = new HashMap<>();
    private Map<ActionFill, String> treeMap = new HashMap<>();
    private Map<ActionFill, String> hashMap = new HashMap<>();

    public void setStatData (Map<ActionFill, String> map, TypeCollectin t){
        if (t == TypeCollectin.ARREY){}
        if (t == TypeCollectin.LINKED){}
        if (t == TypeCollectin.COPYONWRITE){}
        if (t == TypeCollectin.HASH){}
        if (t == TypeCollectin.TREE){}
    }


    private StatData() {
    }


    public static StatData getLiveData() {
        if (statData == null){
            statData =new StatData();
            return statData; }
        return statData;

    }

    public boolean isStatusProgr() {
        return statusProgr;
    }

    public void setStatusProgr(boolean statusProgr) {
        this.statusProgr = statusProgr;
    }
}
