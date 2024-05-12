package com.main;

import lombok.Data;

import java.util.List;

/**Contains data about path
 * totalCost - cost of passing through all nodes of the path
 * nodePositions - contains ordered sequence of all nodes' identifiers of the path
 * */
@Data
public class Path {
    private final int totalCost;
    private final List<String> nodePositions;

    public Path(int totalCost, List<String> nodePositions) {
        this.totalCost = totalCost;
        this.nodePositions = nodePositions;
    }
}
