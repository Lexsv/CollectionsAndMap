package ua.com.CollectionsAndMap.domain.model.ListModel;

import android.os.AsyncTask;

import java.util.concurrent.CopyOnWriteArrayList;

import ua.com.CollectionsAndMap.ui.presentation.Present;

public class CopyOnWriteModel extends AsyncTask<Void,Void, CopyOnWriteArrayList<Integer>> {

    private int amountElements;
    private Present present;


    public CopyOnWriteModel(int amountElements, Present present) {
        this.amountElements = amountElements;
        this.present = present;}

    @Override
    protected CopyOnWriteArrayList<Integer> doInBackground(Void... voids) {
        Integer[] integers = new Integer[amountElements];
        for (int i = 0; i < amountElements; i++) {
            integers[i] = i;
        }
        System.out.println("*******************CopyOnWritList Step1 Fill******************* ");
        return new CopyOnWriteArrayList<>(integers);
    }
    @Override
    protected void onPostExecute(CopyOnWriteArrayList<Integer> list) {
        super.onPostExecute(list);
        System.out.println("*******************CopyOnWritList Step2 Fill******************* ");
        present.callbackFromListModel(list);
        present.startNextList();
    }

}
