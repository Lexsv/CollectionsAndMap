package ua.com.CollectionsAndMap.domain.model.MapModels;

import android.os.AsyncTask;

import java.util.HashMap;
import java.util.Map;

import ua.com.CollectionsAndMap.ui.presentation.Present;

public class HashMapModel extends AsyncTask <Void,Void, HashMap<Byte,Byte>>{

    private int amountElements;
    private Present present;


    public HashMapModel(int amountElements, Present present) {
        this.amountElements = amountElements;
        this.present = present;
    }

    @Override
    protected HashMap<Byte, Byte> doInBackground(Void... voids) {
        Byte b = 0;
        Byte key = 1;
        HashMap<Byte,Byte> hashMap = new HashMap<>(amountElements);
        for (int i = 0; i < amountElements - 1; i++) {
            hashMap.put(key,b);
        }
        return hashMap;
    }

    @Override
    protected void onPostExecute(HashMap<Byte, Byte> list) {
        super.onPostExecute(list);
        System.out.println("*******************HashMap Fill******************* ");
        present.callbackFromListModel(list);
        present.startNextMap();
    }
}
