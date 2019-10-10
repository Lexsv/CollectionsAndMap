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

    private MutableLiveData<String> arrayListAddBegin = new MutableLiveData<>();
    private MutableLiveData<String> arrayListAddMiddle = new MutableLiveData<>();
    private MutableLiveData<String> arrayListAddEnd = new MutableLiveData<>();
    private MutableLiveData<String> arrayListSearch = new MutableLiveData<>();
    private MutableLiveData<String> arrayListRemoveBegin = new MutableLiveData<>();
    private MutableLiveData<String> arrayListRemoveMiddle = new MutableLiveData<>();
    private MutableLiveData<String> arrayListRemoveEnd = new MutableLiveData<>();
    private MutableLiveData<String> linkedListAddBegin = new MutableLiveData<>();
    private MutableLiveData<String> linkedListAddMiddle = new MutableLiveData<>();
    private MutableLiveData<String> linkedListAddEnd = new MutableLiveData<>();
    private MutableLiveData<String> linkedListSearch = new MutableLiveData<>();
    private MutableLiveData<String> linkedListRemoveBegin = new MutableLiveData<>();
    private MutableLiveData<String> linkedListRemoveMiddle = new MutableLiveData<>();
    private MutableLiveData<String> linkedListRemoveEnd = new MutableLiveData<>();
    private MutableLiveData<String> copyOnWriteAddBegin = new MutableLiveData<>();
    private MutableLiveData<String> copyOnWriteAddMiddle = new MutableLiveData<>();
    private MutableLiveData<String> copyOnWriteAddEnd = new MutableLiveData<>();
    private MutableLiveData<String> copyOnWriteSearch = new MutableLiveData<>();
    private MutableLiveData<String> copyOnWriteRemoveBegin = new MutableLiveData<>();
    private MutableLiveData<String> copyOnWriteRemoveMiddle = new MutableLiveData<>();
    private MutableLiveData<String> copyOnWriteRemoveEnd = new MutableLiveData<>();
    private MutableLiveData<String> treeMapAdd = new MutableLiveData<>();
    private MutableLiveData<String> treeMapSearchKey = new MutableLiveData<>();
    private MutableLiveData<String> treeMapRemov = new MutableLiveData<>();
    private MutableLiveData<String> hashMapAdd = new MutableLiveData<>();
    private MutableLiveData<String> hashMapSearchKey = new MutableLiveData<>();
    private MutableLiveData<String> hashMapRemove = new MutableLiveData<>();



    public static StatData getLiveData() {
        if (statData == null){
            statData =new StatData();
            return statData; }
        return statData;

    }
    public LiveData<String> getData(TypeRow typeRow){
        if (typeRow == TypeRow.ARRAYLISTADDBEGIN){return  arrayListAddBegin;}
        if (typeRow == TypeRow.ARRAYLISTADDMIDDLE){return  arrayListAddMiddle;}
        if (typeRow == TypeRow.ARRAYLISTADDEND){return  arrayListAddEnd;}
        if (typeRow == TypeRow.ARRAYLISTSEARCH){return  arrayListSearch;}
        if (typeRow == TypeRow.ARRAYLISTREMOVEBEGIN){return  arrayListRemoveBegin;}
        if (typeRow == TypeRow.ARRAYLISTREMOVEMIDDLE){return  arrayListRemoveMiddle;}
        if (typeRow == TypeRow.ARRAYLISTREMOVEEND){return  arrayListRemoveEnd;}
        if (typeRow == TypeRow.LINKEDLISTADDBEGIN){return  linkedListAddBegin;}
        if (typeRow == TypeRow.LINKEDLISTADDMIDDLE){return  linkedListAddMiddle;}
        if (typeRow == TypeRow.LINKEDLISTADDEND){return  linkedListAddEnd;}
        if (typeRow == TypeRow.LINKEDLISTSEARCH){return  linkedListSearch;}
        if (typeRow == TypeRow.LINKEDLISTREMOVEBEGIN){return  linkedListRemoveBegin;}
        if (typeRow == TypeRow.LINKEDLISTREMOVEMIDDLE){return  linkedListRemoveMiddle;}
        if (typeRow == TypeRow.LINKEDLISTREMOVEEND){return  linkedListRemoveEnd;}
        if (typeRow == TypeRow.COPYONWRITEADDBEGIN){return  copyOnWriteAddBegin;}
        if (typeRow == TypeRow.COPYONWRITEADDMIDDLE){return  copyOnWriteAddMiddle;}
        if (typeRow == TypeRow.COPYONWRITEADDEND){return  copyOnWriteAddEnd;}
        if (typeRow == TypeRow.COPYONWRITESEARCH){return  copyOnWriteSearch;}
        if (typeRow == TypeRow.COPYONWRITEREMOVEBEGIN){return  copyOnWriteRemoveBegin;}
        if (typeRow == TypeRow.COPYONWRITEREMOVEMIDDLE){return  copyOnWriteRemoveMiddle;}
        if (typeRow == TypeRow.COPYONWRITEREMOVEEND){return  copyOnWriteRemoveEnd;}
        if (typeRow == TypeRow.TREEMAPADD){return  treeMapAdd;}
        if (typeRow == TypeRow.TREEMAPSEARCHKEY){return  treeMapSearchKey;}
        if (typeRow == TypeRow.TREEMAPREMOV){return  treeMapRemov;}
        if (typeRow == TypeRow.HASHMAPADD){return  hashMapAdd;}
        if (typeRow == TypeRow.HASHMAPSEARCHKEY){return  hashMapSearchKey;}
        if (typeRow == TypeRow.HASHMAPREMOVE){return  hashMapRemove;}
        return null;
    }

    public synchronized void setStatData (String timeCalk, TypeRow typeRow){
        if (typeRow == TypeRow.ARRAYLISTADDBEGIN){arrayListAddBegin.postValue(timeCalk);}
        if (typeRow == TypeRow.ARRAYLISTADDMIDDLE){arrayListAddMiddle.postValue(timeCalk);}
        if (typeRow == TypeRow.ARRAYLISTADDEND){arrayListAddEnd.postValue(timeCalk);}
        if (typeRow == TypeRow.ARRAYLISTSEARCH){arrayListSearch.postValue(timeCalk);}
        if (typeRow == TypeRow.ARRAYLISTREMOVEBEGIN){arrayListRemoveBegin.postValue(timeCalk);}
        if (typeRow == TypeRow.ARRAYLISTREMOVEMIDDLE){arrayListRemoveMiddle.postValue(timeCalk);}
        if (typeRow == TypeRow.ARRAYLISTREMOVEEND){arrayListRemoveEnd.postValue(timeCalk);}
        if (typeRow == TypeRow.LINKEDLISTADDBEGIN){linkedListAddBegin.postValue(timeCalk);}
        if (typeRow == TypeRow.LINKEDLISTADDMIDDLE){linkedListAddMiddle.postValue(timeCalk);}
        if (typeRow == TypeRow.LINKEDLISTADDEND){linkedListAddEnd.postValue(timeCalk);}
        if (typeRow == TypeRow.LINKEDLISTSEARCH){linkedListSearch.postValue(timeCalk);}
        if (typeRow == TypeRow.LINKEDLISTREMOVEBEGIN){linkedListRemoveBegin.postValue(timeCalk);}
        if (typeRow == TypeRow.LINKEDLISTREMOVEMIDDLE){linkedListRemoveMiddle.postValue(timeCalk);}
        if (typeRow == TypeRow.LINKEDLISTREMOVEEND){linkedListRemoveEnd.postValue(timeCalk);}
        if (typeRow == TypeRow.COPYONWRITEADDBEGIN){copyOnWriteAddBegin.postValue(timeCalk);}
        if (typeRow == TypeRow.COPYONWRITEADDMIDDLE){copyOnWriteAddMiddle.postValue(timeCalk);}
        if (typeRow == TypeRow.COPYONWRITEADDEND){copyOnWriteAddEnd.postValue(timeCalk);}
        if (typeRow == TypeRow.COPYONWRITESEARCH){copyOnWriteSearch.postValue(timeCalk);}
        if (typeRow == TypeRow.COPYONWRITEREMOVEBEGIN){copyOnWriteRemoveBegin.postValue(timeCalk);}
        if (typeRow == TypeRow.COPYONWRITEREMOVEMIDDLE){copyOnWriteRemoveMiddle.postValue(timeCalk);}
        if (typeRow == TypeRow.COPYONWRITEREMOVEEND){copyOnWriteRemoveEnd.postValue(timeCalk);}
        if (typeRow == TypeRow.TREEMAPADD){treeMapAdd.postValue(timeCalk);}
        if (typeRow == TypeRow.TREEMAPSEARCHKEY){treeMapSearchKey.postValue(timeCalk);}
        if (typeRow == TypeRow.TREEMAPREMOV){treeMapRemov.postValue(timeCalk);}
        if (typeRow == TypeRow.HASHMAPADD){hashMapAdd.postValue(timeCalk);}
        if (typeRow == TypeRow.HASHMAPSEARCHKEY){hashMapSearchKey.postValue(timeCalk);}
        if (typeRow == TypeRow.HASHMAPREMOVE){hashMapRemove.postValue(timeCalk);}

    }


    private StatData() {
    }


    public boolean isStatusProgr() {
        return statusProgr;
    }

    public void setStatusProgr(boolean statusProgr) {
        this.statusProgr = statusProgr;
    }
}
