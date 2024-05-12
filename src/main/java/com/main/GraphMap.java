package com.main;

import java.util.ArrayList;

/**Graph of Nodes. Plays role of the city map.
 * Also contains Lists of references to Nodes where emergency departments are located
 * */
public class GraphMap {

    public Node[][] nodes;
    public ArrayList<Node> medic = new ArrayList<>();
    public ArrayList<Node> police = new ArrayList<>();
    public ArrayList<Node> firefighter = new ArrayList<>();

    /**Creates and connect Nodes into graph. places Nodes of emergency departments into separate lists
     * consumes 2-d int Array to be converted to the graph*/
    public GraphMap(int[][] matrix) {
        int depth = matrix.length;
        int width = matrix[0].length;
        nodes = new Node[depth][width];
        for (int r = 0; r < depth; r++) {
            for (int i = 0; i < width; i++) {
                if (matrix[r][i] > 0) {
                    nodes[r][i] = new Node(matrix[r][i], i + ";" + r);
                }
            }
        }
        for (int r = 0; r < depth; r++) {
            for (int i = 0; i < width; i++) {
                Node current = nodes[r][i];
                if (current != null) {
                    if (i - 1 >= 0 && nodes[r][i - 1] != null) {
                        current.add(nodes[r][i - 1]);
                    }
                    if (r - 1 >= 0 && nodes[r - 1][i] != null) {
                        current.add(nodes[r - 1][i]);
                    }
                    if (i + 1 < width && nodes[r][i + 1] != null) {
                        current.add(nodes[r][i + 1]);
                    }
                    if (r + 1 < depth && nodes[r + 1][i] != null) {
                        current.add(nodes[r + 1][i]);
                    }
                    switch (current.status) {
                        case 2 -> police.add(current);
                        case 3 -> medic.add(current);
                        case 4 -> firefighter.add(current);
                    }
                    current.setCost(Matrix.TRAFFIC_MAP.get()[r][i]); // use Traffic Map to set the cost of passing through each node
                }
            }
        }
    }

}
