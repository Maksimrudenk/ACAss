package com.main;

import java.util.*;

/**is used to find the shortest path between two nodes of graphMap.
 * uses Dijkstra's algorithm.
 * */
public class ShortestPath {
    /** returns object of Path that corresponds to the shortest path between two provided Nodes
     * */
    public static Path shortestPath(Node start, Node goal) {
        Map<Node, Integer> distance = new HashMap<>();
        Map<Node, Node> previous = new HashMap<>();
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(distance::get));//priority queue that automatically sort all nodes considering distances to them from start-node

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

    /**Constructs and returns Path object after the shortest path was found.
     * consumes Map of nodes that contains information of the most efficient path to each node
     * consumes Node that is marked to be goal-Node.
     * */
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

