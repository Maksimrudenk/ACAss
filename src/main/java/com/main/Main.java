package com.main;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean flag;
        do {
            flag = run(new GraphMap(Matrix.MAP));
            Matrix.TRAFFIC_MAP.next(); //changing traffic condition after each request
        } while (flag);
        scanner.close();
    }

    /**Runs one request to the program.
     * consumes a graphMap on which request is processed.
     * returns true if user want to make another request.
     * */
    private static boolean run(GraphMap graphMap) {
        EmergencyHandler eh = new EmergencyHandler(graphMap);

        System.out.println("___ACAss___");
        boolean flag;
        do {
            flag = false;
            System.out.println("Enter the position of emergency: [x;y]");
            try {
                String input = scanner.next();
                scanner.nextLine();
                eh.setCoordinates(input);
            } catch (NoSuchElementException exception) {
                System.out.println("Invalid input");
                flag = true;
            } catch (RuntimeException exception) {
                System.out.println(exception.getMessage());
                flag = true;
            }
        } while (flag);
        System.out.println("Enter the emergency message: ");
        String message = scanner.nextLine();
        eh.setMessage(message);
        eh.run();

        System.out.println("Do you want to repeat?");
        System.out.println("1 - repeat , 0 - exit");
        int answer = scanner.nextInt();
        scanner.nextLine();

        return answer == 1;
    }

}
