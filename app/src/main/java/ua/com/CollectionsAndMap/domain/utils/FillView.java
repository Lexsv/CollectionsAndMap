package ua.com.CollectionsAndMap.domain.utils;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public final class FillView {

    public enum ActionFill {
        ADDBEGIN,
        ADDMIDDL,
        ADDMAP,
        ADDEND,
        SEARCHLIST,
        SEARCHMAP,
        REMOVEBEGIN,
        REMOVEMIDDL,
        REMOVEND,
        REMOVEMAP

    }

    public static Map<ActionFill, String> speedList(List<Integer> list, ActionFill flag) {

        long result;
        ActionFill keyMap = null;
        Map<ActionFill, String> resultMap = new HashMap<>();
        long startTim = System.nanoTime();
        // List
        // ADD
        if (flag == ActionFill.ADDBEGIN) {
            keyMap = ActionFill.ADDBEGIN;
            list.add(0, 1);
        }
        if (flag == ActionFill.ADDMIDDL) {
            keyMap = ActionFill.ADDMIDDL;
            list.add(list.size() / 2, 1);
        }
        if (flag == ActionFill.ADDEND) {
            keyMap = ActionFill.ADDEND;
            list.add(1);
        }

        // List
        // Search
        if (flag == ActionFill.SEARCHLIST) {
            keyMap = ActionFill.SEARCHLIST;
            list.get(new Random().nextInt(list.size()));
        }

        // List
        // Remove Begin
        if (flag == ActionFill.REMOVEBEGIN) {
            keyMap = ActionFill.REMOVEBEGIN;
            list.remove(0);
        }
        if (flag == ActionFill.REMOVEMIDDL) {
            keyMap = ActionFill.REMOVEMIDDL;
            list.remove(list.size() / 2);
        }
        if (flag == ActionFill.REMOVEND) {
            keyMap = ActionFill.REMOVEND;
            list.remove(list.size() - 1);
        }

        result = (System.nanoTime() - startTim) / 1000;
        if (keyMap != null){
            resultMap.put(keyMap,String.valueOf(result));
            return resultMap;
        }

        return null;
    }

    public static Map<ActionFill, String> speedMap(Map<Byte, Byte> map, ActionFill flag) {

        ActionFill keyMap = null;
        Map<ActionFill, String> resultMap = new HashMap<>();

        long startTim = System.nanoTime();

        long result;

        Byte b = 0;
        Byte key = 1;

        //Map
        //ADD
        if (flag == ActionFill.ADDMAP) {
            map.put(key, b);
            keyMap = ActionFill.ADDMAP;
        }
        //Map
        //Search
        if (flag == ActionFill.SEARCHMAP) {
            map.get(key);
            keyMap = ActionFill.SEARCHMAP;
        }
        //Map
        //Remov
        if (flag == ActionFill.REMOVEMAP) {
            map.remove(key);
            keyMap = ActionFill.REMOVEMAP;
        }

        result = (System.nanoTime() - startTim) / 1000;
        if (keyMap != null){
            resultMap.put(keyMap,String.valueOf(result));
            return resultMap;
        }

        return null;
    }

}