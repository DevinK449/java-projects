/*
 * Written by Devin King
 */
package lab3;

import java.util.Scanner;
public class Lab3 {
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] temperatures = new double[10];
        double sum = 0;
        for (int i = 0; i < 10; i++) {
            System.out.print("Please enter the temperature for day " + (i + 1) + ": ");
            temperatures[i] = scanner.nextDouble();
            sum += temperatures[i];
        }
        double averageTemp = sum / temperatures.length;
        System.out.printf("\nThe average temperature was %.1f\n", averageTemp);

        // Find and print the days and temperatures below average
        System.out.println("The days that were below average were:");
        boolean belowAvgTemps = false; // To check if there are any temperatures below average
        for (int i = 0; i < temperatures.length; i++) {
            if (temperatures[i] < averageTemp) {
                belowAvgTemps = true;
                System.out.printf("Day %d with %.1f\n", (i + 1), temperatures[i]);
            }
        }
        if (belowAvgTemps) {
            System.out.println("No temperatures were strictly below the average.");
        }
    }
}