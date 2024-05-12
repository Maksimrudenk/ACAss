package com.main;

import lombok.Data;

import java.util.ArrayList;
import java.util.Objects;

 /**Node of graphMap
 * pointers - neighbour nodes
 * cost - cost of passing through in time units
 * position - position in graphMap (indeed is identifier of node)
  * status - determines status of the node:
  * [1 - simple road, 2 - police, 3 - medic, 4 - firefighter]
 * */
@Data
public class Node {

    private final ArrayList<Node> pointers = new ArrayList<>();
    private int cost = 1;
    final int status;
    private final String position;

    public Node(int status, String coordinates) {
        this.status = status;
        this.position = coordinates;
    }

    public void add(Node node) {
        pointers.add(node);
    }

    public void setCost(int cost) {
        this.cost += cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return getStatus() == node.getStatus() && Objects.equals(getPosition(), node.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStatus(), getPosition());
    }

    @Override
    public String toString() {
        return "Node{" +
                "cost=" + cost +
                ", status=" + status +
                '}';
    }
}
