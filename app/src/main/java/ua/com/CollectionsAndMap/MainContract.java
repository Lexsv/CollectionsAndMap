package ua.com.CollectionsAndMap;

import ua.com.CollectionsAndMap.presentation.BasePresenter;

public interface MainContract {
    interface MainPrisenter {
        void onCalculation(int amauntElemant);
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
