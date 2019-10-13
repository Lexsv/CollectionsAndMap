package ua.com.CollectionsAndMap.ui.presentation.interfaceContract;

import ua.com.CollectionsAndMap.ui.presentation.BasePresenter;

public interface MainContract {
    interface MainPrisenter {
        void onCalculation(int amauntElemant);
        void onDestroy();
    }
    interface View{
        void showProgress();
        void hidProgress();
        int getItom();
    }

    interface Presenter{
        void fillView();
        void onCalculation(int amauntElemants);

    }
    
}
