package com.main;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        GraphMap graphMap = new GraphMap(Matrix.MAP);
        EmergencyHandler eh = new EmergencyHandler(graphMap);
        Scanner scanner = new Scanner(System.in);
        System.out.println("___ACAss___");

        boolean flag;
        do {
            flag = false;
            System.out.println("Enter the position of emergency: [x;y]");
            try{
                scanner.reset();
                String input = scanner.next();
                eh.setCoordinates(input);
            } catch (NoSuchElementException exception){
                System.out.println("Invalid input");
                flag=true;
            } catch (RuntimeException exception){
                System.out.println(exception.getMessage());
                flag=true;
            }
        }while (flag);
        System.out.println("Enter the emergency message: ");
        scanner.nextLine();
        String message = scanner.nextLine();
        eh.setMessage(message);
        eh.run();
        scanner.close();
    }

}
