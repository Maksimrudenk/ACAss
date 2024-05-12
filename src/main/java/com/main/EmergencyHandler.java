package com.main;

import lombok.Data;

import java.util.ArrayList;
import java.util.regex.PatternSyntaxException;

/**
 * Handles emergency massages on provided graphMap;
 */
@Data
public class EmergencyHandler {
    private GraphMap graphMap;

    private Node start;
    private String message;

    public EmergencyHandler(GraphMap graphMap) {
        this.graphMap = graphMap;
    }

    /**
     * sets the position of emergency
     * consumes coordinates in x;y format
     * throws NumberFormatException if format of param is wrong
     * throws IndexOutOfBoundsException if coordinates do not exist on provided map
     * throws NullPointerException if coordinates do not point on road-Node
     */
    public void setCoordinates(String resource) throws NumberFormatException, IndexOutOfBoundsException, NullPointerException {
        try {
            int x, y;
            x = Integer.parseInt(resource.split(";")[0]);
            y = Integer.parseInt(resource.split(";")[1]);
            start = graphMap.nodes[y][x];
            if (start == null) {
                throw new NullPointerException();
            }
        } catch (NumberFormatException | PatternSyntaxException exception) {
            throw new NumberFormatException("Invalid Input");
        } catch (IndexOutOfBoundsException exception) {
            throw new IndexOutOfBoundsException("Position not found");
        } catch (NullPointerException exception) {
            throw new NullPointerException("Cannot resolve: path to building");
        }
    }

    /**
     * handles one emergency according to preset position and message
     */
    public void run() {
        if (MessageHandler.needMedic(message)) {
            System.out.println("Sending medic: " + dispatch(graphMap.medic));
        }
        if (MessageHandler.needPolice(message)) {
            System.out.println("Sending police: " + dispatch(graphMap.police));
        }
        if (MessageHandler.needFirefighter(message)) {
            System.out.println("Sending firefighter: " + dispatch(graphMap.firefighter));
        }
    }

    /**
     * returns the shortest path to emergency position for the closest node of provided list
     */
    private Path dispatch(ArrayList<Node> candidates) {
        Path path = null;
        for (Node c : candidates) {
            Path current = ShortestPath.shortestPath(c, start);
            if (path == null || current.getTotalCost() < path.getTotalCost()) {
                path = current;
            }
        }
        return path;
    }

}

