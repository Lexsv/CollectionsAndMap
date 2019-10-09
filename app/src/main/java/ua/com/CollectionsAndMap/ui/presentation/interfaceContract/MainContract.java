package ua.com.CollectionsAndMap.ui.presentation.interfaceContract;

import ua.com.CollectionsAndMap.ui.presentation.BasePresenter;

public interface MainContract {
    interface MainPrisenter {
        void onCalculation(int amauntElemant);
        void onDestroy();
        void destroyCalcuiation();
    }
    interface View{
        void showProgress();
        void hidProgress();
        MainContract.Presenter getPressentr();
    }

    interface Presenter{
        void dispose();
        void onCalculation(int amauntElemants);

    }
    
}
