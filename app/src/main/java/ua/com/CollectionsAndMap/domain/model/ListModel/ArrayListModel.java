package ua.com.CollectionsAndMap.domain.model.ListModel;

import android.os.AsyncTask;

import java.util.ArrayList;

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
        ArrayList<Integer> arrayList = new ArrayList<>(amountElements);
        for (int i = 0; i <amountElements - 1 ; i++) {
            arrayList.add(i);
        }
        return arrayList;
    }

    @Override
    protected void onPostExecute(ArrayList<Integer> list) {
        super.onPostExecute(list);
        System.out.println("*******************ArrayList Fill******************* ");
        present.callbackFromListModel(list);
        present.startNextList();
    }
}
