package ua.com.CollectionsAndMap.fragment;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;

import javax.inject.Inject;

import butterknife.BindView;
import ua.com.CollectionsAndMap.R;

import ua.com.CollectionsAndMap.dagger.component.DaggerPresentList;
import ua.com.CollectionsAndMap.dagger.component.PresentList;
import ua.com.CollectionsAndMap.dagger.provid.ProvidFragmentInterfas;
import ua.com.CollectionsAndMap.domain.TypeRow;
import ua.com.CollectionsAndMap.dagger.modules.PresentListModul;
import ua.com.CollectionsAndMap.dagger.provid.ProvidMainContractView;
import ua.com.CollectionsAndMap.MainContract;


public class TabCollection extends BaseFragmen {

   @Inject
    MainContract.Presenter mPresentor;

    @BindView(R.id.arrayList_addBagin)
    TextView arrayListAddBegin;
    @BindView(R.id.arrayList_addMiddle)
    TextView arrayListAddMiddle;
    @BindView(R.id.arrayList_addEnd)
    TextView arrayListAddEnd;
    @BindView(R.id.arrayList_search)
    TextView arrayListSearch;
    @BindView(R.id.arrayList_removeBagin)
    TextView arrayListRemoveBegin;
    @BindView(R.id.arrayList_ramoveMidlle)
    TextView arrayListRemoveMiddle;
    @BindView(R.id.arrayList_removeEnd)
    TextView arrayListRemoveEnd;
    @BindView(R.id.linkedList_addBagin)
    TextView linkedListAddBegin;
    @BindView(R.id.linkedList_addMiddle)
    TextView linkedListAddMiddle;
    @BindView(R.id.linkedList_addEnd)
    TextView linkedListAddEnd;
    @BindView(R.id.linkedList_search)
    TextView linkedListSearch;
    @BindView(R.id.linkedList_removeBagin)
    TextView linkedListRemoveBegin;
    @BindView(R.id.linkedList_ramoveMidlle)
    TextView linkedListRemoveMiddle;
    @BindView(R.id.linkedList_removeEnd)
    TextView linkedListRemoveEnd;
    @BindView(R.id.copyOn_write_addBagin)
    TextView copyOnWriteAddBegin;
    @BindView(R.id.copyOn_write_addMiddle)
    TextView copyOnWriteAddMiddle;
    @BindView(R.id.copyOn_write_addEnd)
    TextView copyOnWriteAddEnd;
    @BindView(R.id.copyOn_write_search)
    TextView copyOnWriteSearch;
    @BindView(R.id.copyOn_write_removeBagin)
    TextView copyOnWriteRemoveBegin;
    @BindView(R.id.copyOn_write_ramoveMidlle)
    TextView copyOnWriteRemoveMiddle;
    @BindView(R.id.copyOn_write_removeEnd)
    TextView copyOnWriteRemoveEnd;



    @Override
    protected int getLayout() {
        return R.layout.collection;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       addDaggerDepend();
        mPresentor.fillView();
    }
    @Override
     public LifecycleOwner getOwn (){return this;}


    @Override
    public void fillResult(String s, TypeRow typeRow) {
        if (typeRow == TypeRow.ARRAYLISTADDBEGIN) {
            arrayListAddBegin.setText(s);
        }

        if (typeRow == TypeRow.ARRAYLISTADDMIDDLE) {
            arrayListAddMiddle.setText(s);
        }
        if (typeRow == TypeRow.ARRAYLISTADDEND) {
            arrayListAddEnd.setText(s);
        }

        if (typeRow == TypeRow.ARRAYLISTSEARCH) {
            arrayListSearch.setText(s);
        }

        if (typeRow == TypeRow.ARRAYLISTREMOVEBEGIN) {
            arrayListRemoveBegin.setText(s);
        }

        if (typeRow == TypeRow.ARRAYLISTREMOVEMIDDLE) {
            arrayListRemoveMiddle.setText(s);
        }

        if (typeRow == TypeRow.ARRAYLISTREMOVEEND) {
            arrayListRemoveEnd.setText(s);
        }
        if (typeRow == TypeRow.LINKEDLISTADDBEGIN) {
            linkedListAddBegin.setText(s);
        }

        if (typeRow == TypeRow.LINKEDLISTADDMIDDLE) {
            linkedListAddMiddle.setText(s);
        }
        if (typeRow == TypeRow.LINKEDLISTADDEND) {
            linkedListAddEnd.setText(s);
        }

        if (typeRow == TypeRow.LINKEDLISTSEARCH) {
            linkedListSearch.setText(s);
        }

        if (typeRow == TypeRow.LINKEDLISTREMOVEBEGIN) {
            linkedListRemoveBegin.setText(s);
        }

        if (typeRow == TypeRow.LINKEDLISTREMOVEMIDDLE) {
            linkedListRemoveMiddle.setText(s);
        }

        if (typeRow == TypeRow.LINKEDLISTREMOVEEND) {
            linkedListRemoveEnd.setText(s);
        }
        if (typeRow == TypeRow.COPYONWRITEADDBEGIN) {
            copyOnWriteAddBegin.setText(s);
        }
        if (typeRow == TypeRow.COPYONWRITEADDMIDDLE) {
            copyOnWriteAddMiddle.setText(s);
        }
        if (typeRow == TypeRow.COPYONWRITEADDEND) {
            copyOnWriteAddEnd.setText(s);
        }
        if (typeRow == TypeRow.COPYONWRITESEARCH) {
            copyOnWriteSearch.setText(s);
        }
        if (typeRow == TypeRow.COPYONWRITEREMOVEBEGIN) {
            copyOnWriteRemoveBegin.setText(s);
        }
        if (typeRow == TypeRow.COPYONWRITEREMOVEMIDDLE) {
            copyOnWriteRemoveMiddle.setText(s);
        }
        if (typeRow == TypeRow.COPYONWRITEREMOVEEND) {
            copyOnWriteRemoveEnd.setText(s);
        }
    }


    private void addDaggerDepend() {
        PresentList presentList = DaggerPresentList.builder()
                .providMainContractView(new ProvidMainContractView((MainContract.View) getContext()))
                .providFragmentInterfas(new ProvidFragmentInterfas(this))
                .presentListModul(new PresentListModul())
                .build();
        presentList.inject(this);
    }

}



