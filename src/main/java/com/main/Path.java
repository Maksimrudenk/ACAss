package com.main;

import lombok.Data;

import java.util.List;

@Data
public class Path {
    private final int totalCost;
    private final List<String> nodePositions;

    public Path(int totalCost, List<String> nodePositions) {
        this.totalCost = totalCost;
        this.nodePositions = nodePositions;
    }
}
