package ua.com.CollectionsAndMap.domain.model.ListModel;

import android.os.AsyncTask;

import java.util.Collections;
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
        return new CopyOnWriteArrayList<>(Collections.nCopies(amountElements,1));
    }
    @Override
    protected void onPostExecute(CopyOnWriteArrayList<Integer> list) {
        super.onPostExecute(list);
        System.out.println("*******************CopyOnWritList Fill******************* ");
        present.callbackFromListModel(list);
        present.startNextList();
    }

}
