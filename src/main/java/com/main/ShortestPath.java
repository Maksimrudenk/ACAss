package com.main;

import java.util.*;

public class ShortestPath {
    public static Path shortestPath(Node start, Node goal) {
        Map<Node, Integer> distance = new HashMap<>();
        Map<Node, Node> previous = new HashMap<>();
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(distance::get));

        distance.put(start, 0);
        queue.offer(start);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current == goal) {
                return reconstructPath(previous, current);
            }
            for (Node neighbor : current.getPointers()) {
                int newCost = distance.get(current) + neighbor.getCost();
                if (!distance.containsKey(neighbor) || newCost < distance.get(neighbor)) {
                    distance.put(neighbor, newCost);
                    previous.put(neighbor, current);
                    queue.offer(neighbor);
                }
            }
        }
        return null; // No path found
    }

    private static Path reconstructPath(Map<Node, Node> previous, Node goal) {
        int totalCost = 0;
        List<String> nodePositions = new ArrayList<>();
        Node current = goal;
        while (current != null) {
            totalCost += current.getCost();
            nodePositions.add(current.getPosition());
            current = previous.get(current);
        }
        Collections.reverse(nodePositions);
        return new Path(totalCost, nodePositions);
    }
}

