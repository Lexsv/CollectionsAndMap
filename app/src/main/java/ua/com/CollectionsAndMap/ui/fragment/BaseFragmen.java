package ua.com.CollectionsAndMap.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import ua.com.CollectionsAndMap.ui.presentation.BasePresenter;
import ua.com.CollectionsAndMap.ui.presentation.interfaceContract.MainContract;


public abstract class BaseFragmen extends Fragment implements ua.com.CollectionsAndMap.ui.fragment.innterfasFragment.FillView{
    private Unbinder unbinder;

    MainContract.View viewMain;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        viewMain = (MainContract.View )context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    protected abstract int getLayout();

    public abstract MainContract.Presenter getPresent() ;
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
