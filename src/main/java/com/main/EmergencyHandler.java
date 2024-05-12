package com.main;

import lombok.Data;

import java.util.ArrayList;
import java.util.regex.PatternSyntaxException;

@Data
public class EmergencyHandler {
    private GraphMap graphMap;

    private Node start;
    private String message;

    public EmergencyHandler(GraphMap graphMap){
        this.graphMap = graphMap;
    }

    public void setCoordinates(String resource) throws NumberFormatException, IndexOutOfBoundsException, NullPointerException{
        try{
            int x,y;
            x = Integer.parseInt(resource.split(";")[0]);
            y = Integer.parseInt(resource.split(";")[1]);
            start = graphMap.nodes[y][x];
            if (start == null){
                throw new NullPointerException();
            }
        } catch (NumberFormatException | PatternSyntaxException exception){
            throw new NumberFormatException("Invalid Input");
        } catch (IndexOutOfBoundsException exception){
            throw new IndexOutOfBoundsException("Position not found");
        } catch (NullPointerException exception){
            throw new NullPointerException("Cannot resolve: path to building");
        }
    }

    public void run(){
        if (MessageHandler.needMedic(message)) {
            System.out.println("Sending medic: "+dispatch(graphMap.medic));
        }
        if (MessageHandler.needPolice(message)) {
            System.out.println("Sending police: "+dispatch(graphMap.police));
        }
        if (MessageHandler.needFirefighter(message)) {
            System.out.println("Sending firefighter: "+dispatch(graphMap.firefighter));
        }
    }

    private Path dispatch(ArrayList<Node> candidates){
        Path path = null;
        for (Node c:candidates) {
            Path current = ShortestPath.shortestPath(c, start);
            if (path == null||current.getTotalCost()< path.getTotalCost()){
                path = current;
            }
        }
        return path;
    }

}

