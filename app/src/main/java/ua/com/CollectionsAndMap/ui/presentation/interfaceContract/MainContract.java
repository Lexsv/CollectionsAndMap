package ua.com.CollectionsAndMap.ui.presentation.interfaceContract;

public interface MainContract {
    interface MainPrisenter {
        void onCalculation(int position, int amauntElemant);
    }
    interface View{
        void shoeProgress();
        void hidProgress();
    }

    interface Presenter{
        void onCalculation(int amauntElemants);
    }
    
}
