package ua.com.CollectionsAndMap.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;


import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import ua.com.CollectionsAndMap.R;


import ua.com.CollectionsAndMap.domain.dagger.component.DaggerPresentListComponent;
import ua.com.CollectionsAndMap.domain.dagger.component.PresentListComponent;
import ua.com.CollectionsAndMap.domain.dagger.provid.AppModul;
import ua.com.CollectionsAndMap.domain.dagger.modules.PresentListModul;
import ua.com.CollectionsAndMap.domain.dagger.provid.ProvidTabCollection;
import ua.com.CollectionsAndMap.ui.presentation.flag.TypeCollectin;
import ua.com.CollectionsAndMap.ui.presentation.PresentForList;


import static ua.com.CollectionsAndMap.domain.utils.FillView.*;

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
    protected int getLayout() {
        return R.layout.collection;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        addDaggerDepend();
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
        PresentListComponent presentListComponent = DaggerPresentListComponent.builder()
                .appModul(new AppModul(getContext()))
                .providTabCollection(new ProvidTabCollection(this))
                .presentListModul(new PresentListModul())
                .build();
        presentListComponent.inject(this);
    }


    public void onRecycle(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            Map<ActionFill, String> arreyMap = present.getData(TypeCollectin.ARREY);
            Map<ActionFill, String> lincMap = present.getData(TypeCollectin.LINKED);
            Map<ActionFill, String> copyMap = present.getData(TypeCollectin.COPYONWRITE);
            for (ActionFill actionFill : arreyMap.keySet()) {
                if (ActionFill.ADDBEGIN == actionFill) {
                    arrayListAddBegin.setText(arreyMap.get(actionFill));
                }
                if (ActionFill.ADDMIDDL == actionFill) {
                    arrayListAddMiddle.setText(arreyMap.get(actionFill));
                }
                if (ActionFill.ADDEND == actionFill) {
                    arrayListAddEnd.setText(arreyMap.get(actionFill));
                }
                if (ActionFill.SEARCHLIST == actionFill) {
                    arrayListSearch.setText(arreyMap.get(actionFill));
                }
                if (ActionFill.REMOVEBEGIN == actionFill) {
                    arrayListRemoveBegin.setText(arreyMap.get(actionFill));
                }
                if (ActionFill.REMOVEMIDDL == actionFill) {
                    arrayListRemoveMiddle.setText(arreyMap.get(actionFill));
                }
                if (ActionFill.REMOVEND == actionFill) {
                    arrayListRemoveEnd.setText(arreyMap.get(actionFill));
                }

            }

            for (ActionFill actionFill : lincMap.keySet()) {
                if (ActionFill.ADDBEGIN == actionFill) {
                    linkedListAddBegin.setText(lincMap.get(actionFill));
                }
                if (ActionFill.ADDMIDDL == actionFill) {
                    linkedListAddMiddle.setText(lincMap.get(actionFill));
                }
                if (ActionFill.ADDEND == actionFill) {
                    linkedListAddEnd.setText(lincMap.get(actionFill));
                }
                if (ActionFill.SEARCHLIST == actionFill) {
                    linkedListSearch.setText(lincMap.get(actionFill));
                }
                if (ActionFill.REMOVEBEGIN == actionFill) {
                    linkedListRemoveBegin.setText(lincMap.get(actionFill));
                }
                if (ActionFill.REMOVEMIDDL == actionFill) {
                    linkedListRemoveMiddle.setText(lincMap.get(actionFill));
                }
                if (ActionFill.REMOVEND == actionFill) {
                    linkedListRemoveEnd.setText(lincMap.get(actionFill));
                }
            }

            for (ActionFill actionFill : copyMap.keySet()) {
                if (ActionFill.ADDBEGIN == actionFill) {
                    copyOnWriteAddBegin.setText(copyMap.get(actionFill));
                }
                if (ActionFill.ADDMIDDL == actionFill) {
                    copyOnWriteAddMiddle.setText(copyMap.get(actionFill));
                }
                if (ActionFill.ADDEND == actionFill) {
                    copyOnWriteAddEnd.setText(copyMap.get(actionFill));
                }
                if (ActionFill.SEARCHLIST == actionFill) {
                    copyOnWriteSearch.setText(copyMap.get(actionFill));
                }
                if (ActionFill.REMOVEBEGIN == actionFill) {
                    copyOnWriteRemoveBegin.setText(copyMap.get(actionFill));
                }
                if (ActionFill.REMOVEMIDDL == actionFill) {
                    copyOnWriteRemoveMiddle.setText(copyMap.get(actionFill));
                }
                if (ActionFill.REMOVEND == actionFill) {
                    copyOnWriteRemoveEnd.setText(copyMap.get(actionFill));
                }
            }

        }
    }


}
