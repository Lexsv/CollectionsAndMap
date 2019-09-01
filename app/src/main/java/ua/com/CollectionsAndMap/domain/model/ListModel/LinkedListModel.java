package ua.com.CollectionsAndMap.domain.model.ListModel;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;


import ua.com.CollectionsAndMap.ui.presentation.Present;

public class LinkedListModel extends AsyncTask<Void,Void, LinkedList<Byte>> {

    private int amountElements;
    private Present present;

    public LinkedListModel(int amountElements, Present present) {
        this.amountElements = amountElements;
        this.present = present;
    }
    @Override
    protected LinkedList<Byte> doInBackground(Void... voids) {
        byte b = 1;
        return new LinkedList<>(Collections.nCopies(amountElements,b));
    }

    @Override
    protected void onPostExecute(LinkedList<Byte> list) {
        super.onPostExecute(list);
        System.out.println("*******************LinkedList Fill******************* ");
        present.callbackFromListModel(list);
        present.startNextList();
    }
}
