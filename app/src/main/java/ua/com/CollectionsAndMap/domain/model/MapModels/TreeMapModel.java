package ua.com.CollectionsAndMap.domain.model.MapModels;

import android.os.AsyncTask;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import ua.com.CollectionsAndMap.ui.presentation.Present;


public class TreeMapModel extends AsyncTask<Void,Void, TreeMap<Byte,Byte>> {

    private int amountElements;
    private Present present;


    public TreeMapModel(int amountElements, Present present) {
        this.amountElements = amountElements;
        this.present = present;
    }

    @Override
    protected TreeMap<Byte, Byte> doInBackground(Void... voids) {
        Byte b = 0;
        Byte key = 1;
        TreeMap<Byte,Byte> treeMap = new TreeMap<>();
        for (int i = 0; i < amountElements - 1; i++) {
            treeMap.put(key,b);
        }
        return  treeMap;
    }

    @Override
    protected void onPostExecute(TreeMap<Byte,Byte> list) {
        super.onPostExecute(list);
        System.out.println("*******************TreeMap Fill******************* ");
        present.callbackFromListModel(list);
        present.startNextMap();
    }
}
