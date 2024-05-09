package com.main;

public class Main {

    public static void main(String[] args){
        Map map = new Map(Matrix.MAP);

        for (Node[] row:map.nodes) {
            for (Node n:row) {
                System.out.print(n);
            }
            System.out.println();
        }
        System.out.println("-------");
        for (Node n :map.nodes[0][0].getPointers()) {
            System.out.println(n);
        }
        System.out.println("-------");
        for (Node n :map.nodes[2][2].getPointers()) {
            System.out.println(n);
        }

    }

}
