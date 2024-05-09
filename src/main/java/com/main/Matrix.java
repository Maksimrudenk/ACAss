package com.main;

public class Matrix {

    static final int[][] MAP = {
            {1,0,2,1,0},
            {1,1,0,1,0},
            {0,1,1,1,1},
            {0,0,1,0,4},
            {1,1,3,1,1},
    };

    static final CircularList TRAFFIC_MAP =new CircularList(
            new int[][]{
                    {0,0,0,0,0},
                    {0,0,0,0,0},
                    {0,0,2,0,0},
                    {0,0,0,0,0},
                    {0,0,0,0,0},
            },
            new int[][]{
                    {0,0,0,0,0},
                    {0,0,0,0,0},
                    {0,0,0,0,0},
                    {0,0,0,0,0},
                    {0,0,0,0,0},
            }
    );

}
