package ua.com.CollectionsAndMap.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import ua.com.CollectionsAndMap.R;
import ua.com.CollectionsAndMap.data.StatData;
import ua.com.CollectionsAndMap.data.TypeRow;
import ua.com.CollectionsAndMap.domain.dagger.component.DaggerPresentComponent;
import ua.com.CollectionsAndMap.domain.dagger.component.PresentComponent;
import ua.com.CollectionsAndMap.domain.dagger.modules.PresentListModul;
import ua.com.CollectionsAndMap.domain.dagger.provid.ProvidFillView;
import ua.com.CollectionsAndMap.domain.dagger.provid.ProvidMainContractView;
import ua.com.CollectionsAndMap.ui.mainaactivity.MainViewModul;
import ua.com.CollectionsAndMap.ui.presentation.PresentForList;
import ua.com.CollectionsAndMap.ui.presentation.flag.TypeCollectin;
import ua.com.CollectionsAndMap.ui.presentation.interfaceContract.MainContract;

import static ua.com.CollectionsAndMap.domain.utils.FillView.ActionFill;

public class TabCollection extends BaseFragmen {
    @Inject
    PresentForList present;

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
    public MainContract.Presenter getPresent() {
        return present;
    }

    @Override
    protected int getLayout() {
        return R.layout.collection;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (MainViewModul.getMainViewModul().getPresentForList() == null) {
            addDaggerDepend();
        } else {
            present = MainViewModul.getMainViewModul().getPresentForList();
            present.setPresentor((MainContract.View) getContext());
            present.setFillView(this);
        }
        getLifecycle().addObserver(present);
        onRecycle(savedInstanceState);
    }

    @SuppressLint("CheckResult")
    @Override
    public void fillResult(String s, TypeCollectin flagList, ActionFill flagAction) {

        if (flagList == TypeCollectin.ARREY) {

            if (flagAction == ActionFill.ADDBEGIN) {
                arrayListAddBegin.setText(s);
            }

            if (flagAction == ActionFill.ADDMIDDL) {
                arrayListAddMiddle.setText(s);
            }
            if (flagAction == ActionFill.ADDEND) {
                arrayListAddEnd.setText(s);
            }

            if (flagAction == ActionFill.SEARCHLIST) {
                arrayListSearch.setText(s);
            }

            if (flagAction == ActionFill.REMOVEBEGIN) {
                arrayListRemoveBegin.setText(s);
            }

            if (flagAction == ActionFill.REMOVEMIDDL) {
                arrayListRemoveMiddle.setText(s);
            }

            if (flagAction == ActionFill.REMOVEND) {
                arrayListRemoveEnd.setText(s);
            }
        }

        if (flagList == TypeCollectin.LINKED) {

            if (flagAction == ActionFill.ADDBEGIN) {
                linkedListAddBegin.setText(s);
            }

            if (flagAction == ActionFill.ADDMIDDL) {
                linkedListAddMiddle.setText(s);
            }
            if (flagAction == ActionFill.ADDEND) {
                linkedListAddEnd.setText(s);
            }

            if (flagAction == ActionFill.SEARCHLIST) {
                linkedListSearch.setText(s);
            }

            if (flagAction == ActionFill.REMOVEBEGIN) {
                linkedListRemoveBegin.setText(s);
            }

            if (flagAction == ActionFill.REMOVEMIDDL) {
                linkedListRemoveMiddle.setText(s);
            }

            if (flagAction == ActionFill.REMOVEND) {
                linkedListRemoveEnd.setText(s);
            }
        }

        if (flagList == TypeCollectin.COPYONWRITE) {

            if (flagAction == ActionFill.ADDBEGIN) {
                copyOnWriteAddBegin.setText(s);
            }


            if (flagAction == ActionFill.ADDMIDDL) {
                copyOnWriteAddMiddle.setText(s);
            }
            if (flagAction == ActionFill.ADDEND) {
                copyOnWriteAddEnd.setText(s);
            }


            if (flagAction == ActionFill.SEARCHLIST) {
                copyOnWriteSearch.setText(s);
            }

            if (flagAction == ActionFill.REMOVEBEGIN) {
                copyOnWriteRemoveBegin.setText(s);
            }


            if (flagAction == ActionFill.REMOVEMIDDL) {
                copyOnWriteRemoveMiddle.setText(s);
            }


            if (flagAction == ActionFill.REMOVEND) {
                copyOnWriteRemoveEnd.setText(s);
            }

        }


    }


    private void addDaggerDepend() {
        PresentComponent presentComponent = DaggerPresentComponent.builder()
                .providMainContractView(new ProvidMainContractView((MainContract.View) getContext()))
                .providFillView(new ProvidFillView(this))
                .presentListModul(new PresentListModul())
                .build();
        presentComponent.inject(this);

    }


    public void onRecycle(Bundle savedInstanceState) {
//        if (savedInstanceState != null) {
            StatData.getLiveData().getData(TypeRow.ARRAYLISTADDBEGIN).observe(this,(s -> {arrayListAddBegin.setText(s);}));
            StatData.getLiveData().getData(TypeRow.ARRAYLISTADDMIDDLE).observe(this,(s -> {arrayListAddMiddle.setText(s);}));
            StatData.getLiveData().getData(TypeRow.ARRAYLISTADDEND).observe(this,(s -> {arrayListAddEnd.setText(s);}));
            StatData.getLiveData().getData(TypeRow.ARRAYLISTSEARCH).observe(this,(s -> {arrayListSearch.setText(s);}));
            StatData.getLiveData().getData(TypeRow.ARRAYLISTREMOVEBEGIN).observe(this,(s -> {arrayListRemoveBegin.setText(s);}));
            StatData.getLiveData().getData(TypeRow.ARRAYLISTREMOVEMIDDLE).observe(this,(s -> {arrayListRemoveMiddle.setText(s);}));
            StatData.getLiveData().getData(TypeRow.ARRAYLISTREMOVEEND).observe(this,(s -> {arrayListRemoveEnd.setText(s);}));
            StatData.getLiveData().getData(TypeRow.LINKEDLISTADDBEGIN).observe(this,(s -> {linkedListAddBegin.setText(s);}));
            StatData.getLiveData().getData(TypeRow.LINKEDLISTADDMIDDLE).observe(this,(s -> {linkedListAddMiddle.setText(s);}));
            StatData.getLiveData().getData(TypeRow.LINKEDLISTADDEND).observe(this,(s -> {linkedListAddEnd.setText(s);}));
            StatData.getLiveData().getData(TypeRow.LINKEDLISTSEARCH).observe(this,(s -> {linkedListSearch.setText(s);}));
            StatData.getLiveData().getData(TypeRow.LINKEDLISTREMOVEBEGIN).observe(this,(s -> {linkedListRemoveBegin.setText(s);}));
            StatData.getLiveData().getData(TypeRow.LINKEDLISTREMOVEMIDDLE).observe(this,(s -> {linkedListRemoveMiddle.setText(s);}));
            StatData.getLiveData().getData(TypeRow.LINKEDLISTREMOVEEND).observe(this,(s -> {linkedListRemoveEnd.setText(s);}));
            StatData.getLiveData().getData(TypeRow.COPYONWRITEADDBEGIN).observe(this,(s -> {copyOnWriteAddBegin.setText(s);}));
            StatData.getLiveData().getData(TypeRow.COPYONWRITEADDMIDDLE).observe(this,(s -> {copyOnWriteAddMiddle.setText(s);}));
            StatData.getLiveData().getData(TypeRow.COPYONWRITEADDEND).observe(this,(s -> {copyOnWriteAddEnd.setText(s);}));
            StatData.getLiveData().getData(TypeRow.COPYONWRITESEARCH).observe(this,(s -> {copyOnWriteSearch.setText(s);}));
            StatData.getLiveData().getData(TypeRow.COPYONWRITEREMOVEBEGIN).observe(this,(s -> {copyOnWriteRemoveBegin.setText(s);}));
            StatData.getLiveData().getData(TypeRow.COPYONWRITEREMOVEMIDDLE).observe(this,(s -> {copyOnWriteRemoveMiddle.setText(s);}));
            StatData.getLiveData().getData(TypeRow.COPYONWRITEREMOVEEND).observe(this,(s -> {copyOnWriteRemoveEnd.setText(s);}));
//        }

  }
}



