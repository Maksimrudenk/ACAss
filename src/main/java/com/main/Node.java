package com.main;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Node {

    private final ArrayList<Node> pointers = new ArrayList<>();
    private int cost = 1;
    private final int status;

    public Node(int status){
        this.status = status;
    }

    public void add(Node node){
        pointers.add(node);
    }

    public void setCost(int cost){
        this.cost+=cost;
    }

//    @Override
//    public String toString() {
//        return String.valueOf(status);
//    }


    @Override
    public String toString() {
        return "Node{" +
                "cost=" + cost +
                ", status=" + status +
                '}';
    }
}
