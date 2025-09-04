/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog6112pracassignment;

import java.util.Scanner;

/**
 *
 * @author lab_services_student
 */
//(Farrell, 2024)
public class Series {

    //Declaration
    Scanner scanner = new Scanner(System.in);
    private Series[] seriesArray = new Series[100];
    private String seriesID;
    private String seriesName;
    private String seriesAge;
    private int seriesNumberOfEpisodes;


    private int seriesCount = 0;

    //Reset series collection
    public void resetSeries() {
        seriesCount = 0;
        for (int i = 0; i < seriesArray.length; i++) {
            seriesArray[i] = null;
        }
    }

    //Capture a new series
    public void captureSeries() {
        if (seriesCount >= seriesArray.length) {
            System.out.println("Storage full! Cannot capture more series.");
            return;
        }

        System.out.println("Enter the series ID: ");
        String seriesID = scanner.nextLine();

        System.out.println("Enter the series name: ");
        String seriesName = scanner.nextLine();

        System.out.println("Enter the series age restriction: ");
        String seriesAge = scanner.nextLine();
        while (!seriesAgeRestriction(seriesAge)) {
            System.out.println("Invalid age! Age must be between 2 and 18.");
            System.out.print("Re-enter the series age restriction: ");
            seriesAge = scanner.nextLine();
        }

        System.out.print("Enter the number of episodes: ");
        int seriesNumberOfEpisodes = Integer.parseInt(scanner.nextLine());

        Series s = new Series();
        s.seriesID = seriesID;
        s.seriesName = seriesName;
        s.seriesAge = seriesAge;
        s.seriesNumberOfEpisodes = seriesNumberOfEpisodes;

        seriesArray[seriesCount] = s;
        seriesCount++;

        System.out.println("Series captured successfully!");
    }

    //Search for a series
    public void searchSeries() {
        System.out.println("Enter the series ID to search: ");
        String searchID = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < seriesCount; i++) {
            if (seriesArray[i].seriesID.equals(searchID)) {
                System.out.println("\nSERIES FOUND!");
                System.out.println("\n*****************");
                System.out.println("\nSERIES ID: " + seriesArray[i].seriesID);
                System.out.println("\nSERIES NAME: " + seriesArray[i].seriesName);
                System.out.println("\nSERIES AGE RESTRICTION: " + seriesArray[i].seriesAge);
                System.out.println("\nSERIES NUMBER OF EPISODES: " + seriesArray[i].seriesNumberOfEpisodes);
                System.out.println("\n*****************");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Series with ID " + searchID + " was not found!");
        }
    }

    //Update a series
    public void updateSeries() {
        System.out.println("Enter the series ID to update:");
        String updateID = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < seriesCount; i++) {
            if (seriesArray[i].seriesID.equals(updateID)) {
                System.out.println("Series found! Enter new details.");

                System.out.print("Enter new series name: ");
                seriesArray[i].seriesName = scanner.nextLine();

                System.out.print("Enter new age restriction: ");
                String seriesAge = scanner.nextLine();
                while (!seriesAgeRestriction(seriesAge)) {
                    System.out.println("Invalid age! Age must be between 2 and 18.");
                    System.out.print("Re-enter the series age restriction: ");
                    seriesAge = scanner.nextLine();
                }
                seriesArray[i].seriesAge = seriesAge;
                
                System.out.print("Enter new number of episodes: ");
                seriesArray[i].seriesNumberOfEpisodes = Integer.parseInt(scanner.nextLine());
                
                System.out.println("Series updated successfully!");
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("No series found with the given ID!");
        }
    }

    //Delete a series
    public void deleteSeries() {
        System.out.println("Enter the series ID to delete:");
        String deleteID = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < seriesCount; i++) {
            if (seriesArray[i].seriesID.equals(deleteID)) {
                String confirm = scanner.nextLine();

                if (confirm.equalsIgnoreCase("Yes")) {
                    for (int j = i; j < seriesCount - 1; j++) {
                        seriesArray[j] = seriesArray[j + 1];
                    }
                    seriesArray[seriesCount - 1] = null;
                    seriesCount--;
                    System.out.println("Series deleted successfully!");
                } else {
                    System.out.println("Deletion cancelled.");
                }
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("No series found with the given ID!");
        }
    }

    //Display series report
    public void displayReport(Scanner scanner) {
        System.out.println("\nSERIES REPORT - 2025");
        System.out.println("*****************");

        if (seriesCount == 0) {
            System.out.println("No series captured yet.");
            return;
        }

        for (int i = 0; i < seriesCount; i++) {
            System.out.println("Series " + (i + 1));
            System.out.println("SERIES ID: " + seriesArray[i].seriesID);
            System.out.println("\nSERIES NAME: " + seriesArray[i].seriesName);
            System.out.println("\nSERIES AGE RESTRICTION: " + seriesArray[i].seriesAge);
            System.out.println("\nSERIES NUMBER OF EPISODES: " + seriesArray[i].seriesNumberOfEpisodes);
            System.out.println("-----------------");
        }
    }

    //Validate age restriction
    public boolean seriesAgeRestriction(String input) {
        if (input == null && input.isEmpty()) {
            return false;
        }
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        int age = Integer.parseInt(input);
        return age >= 2 && age <= 18;
    }

    public void exitSeriesApplication() {
        System.out.println("Exiting... Goodbye!");
        System.exit(0);
    }
}

//Reference list:
//Farrell, J. (2024). Java programming. Boston, MA: Cengage.
//OpenAI. 2025. ChatGPT (Mar 14 version) [Large language model]. https://chatgpt.com/share/68b9f1d8-1330-800f-b90f-48bb81c236e7
