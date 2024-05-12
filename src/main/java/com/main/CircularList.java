package com.main;

import java.util.ArrayList;
import java.util.Arrays;

public class CircularList {

    private final ArrayList<int[][]> storage = new ArrayList<>();
    private int iterator=0;

    public CircularList(int[][]... matrices) {
        storage.addAll(Arrays.asList(matrices));
    }

    public int[][] next(){
        if (++iterator==storage.size()) iterator = 0;
        return storage.get(iterator);
    }

    public int[][] get(){
        return storage.get(iterator);
    }
}
