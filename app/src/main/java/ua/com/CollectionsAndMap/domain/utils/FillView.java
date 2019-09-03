package ua.com.CollectionsAndMap.domain.utils;


import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;


public final class FillView {

    public enum ActionFill{
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
public static   long speedList (List<Integer> list, ActionFill flag){
    long  startTim = System.nanoTime();
     long  result;
    // List
    // ADD
    if (flag == ActionFill.ADDBEGIN){list.add(0, 1);}
    if (flag == ActionFill.ADDMIDDL){list.add(list.size() / 2, 1);}
    if (flag == ActionFill.ADDEND){list.add(1);}

    // List
    // Search
    if (flag == ActionFill.SEARCHLIST){list.get(new Random().nextInt(list.size()));}

     // List
    // Remove Begin
    if (flag == ActionFill.REMOVEBEGIN){list.remove(0);}
    if (flag == ActionFill.REMOVEMIDDL){list.remove(list.size() / 2);}
    if (flag == ActionFill.REMOVEND){list.remove(list.size() - 1);}

    result = (System.nanoTime() - startTim)/1000;
    return result;
}

    public static   long speedMap (Map<Byte,Byte> map, ActionFill flag){
        long  startTim = System.nanoTime();
        long  result;
        Byte b = 0;
        Byte key = 1;

        //Map
        //ADD
        if (flag == ActionFill.ADDMAP){map.put(key, b);}
        //Map
        //Search
        if (flag == ActionFill.SEARCHMAP){map.get(key);}
        //Map
        //Remov
        if (flag == ActionFill.REMOVEMAP){map.remove(key);}

        result = (System.nanoTime() - startTim)/1000;
        return result;
    }

}