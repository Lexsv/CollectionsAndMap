package ua.com.CollectionsAndMap.domain.model.ListModel;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import ua.com.CollectionsAndMap.ui.presentation.Present;

public class ArrayListModel extends AsyncTask <Void,Void, ArrayList<Integer>> {

    private int amountElements;
    private Present present;

    public ArrayListModel(int amountElements, Present present) {
        this.amountElements = amountElements;
        this.present = present;
    }
    @Override
    protected ArrayList<Integer> doInBackground(Void... voids) {
        return new ArrayList<>(Collections.nCopies(amountElements,1));
    }

    @Override
    protected void onPostExecute(ArrayList<Integer> list) {
        super.onPostExecute(list);
        System.out.println("*******************ArrayList Fill******************* ");
        present.callbackFromListModel(list);
        present.startNextList();
    }
}
