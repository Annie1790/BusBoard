/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package busboard;

import java.util.Scanner;

import busboard.BusStopFinder.BusStopFinder;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BusStopFinder busStopFinder = new BusStopFinder();

        // System.out.print("Please enter a postcode: ");
        // String userInput = scanner.nextLine().replaceAll("\\s", "");
        System.out.println("The nearest bus station is: ");
        busStopFinder.doThis("se167tn");
    }
}
