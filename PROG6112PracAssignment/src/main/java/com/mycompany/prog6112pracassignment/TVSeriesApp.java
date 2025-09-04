/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prog6112pracassignment;

import java.util.Scanner;
/**
 *
 * @author lab_services_student
 */

//(Farrell, 2024)
public class TVSeriesApp {

    public static void main(String[] args) {
        //Declaration
        Scanner scanner = new Scanner(System.in);
        Series seriesManager = new Series();
        
        System.out.println("LATEST SERIES - 2025"
                + "\n*****************"
                + "\nEnter (1) to launch menu or any other key to exit: ");
        String select = scanner.nextLine();

        if (!select.equals("1")) {
            System.out.println("Application exited.");
            return;
        }

        boolean option = true;

        while (option) {
            System.out.println("\nPlease select one of the following menu items:");
            System.out.println("\n1. Capture a new series");
            System.out.println("\n2. Search for a new series");
            System.out.println("\n3. Update series age restriction");
            System.out.println("\n4. Delete a series");
            System.out.println("\n5. Print series report - 2025");
            System.out.println("\n6. Exit Application");
            System.out.println("Enter your choice: ");
            String menuChoice = scanner.nextLine();
            
            switch (menuChoice) {
                case "1":
                    seriesManager.captureSeries();
                    break;
                case "2":
                    seriesManager.searchSeries();
                    break;
                case "3":
                    seriesManager.updateSeries();
                    break;
                case "4":
                    seriesManager.deleteSeries();
                    break;
                case "5":
                    seriesManager.displayReport(scanner);
                    break;
                case "6":
                    seriesManager.exitSeriesApplication();
                    break;
            }
        }
    }
}

//Reference list:
//Farrell, J. (2024). Java programming. Boston, MA: Cengage.
//OpenAI. 2025. ChatGPT (Mar 14 version) [Large language model]. https://chatgpt.com/share/68b9f1d8-1330-800f-b90f-48bb81c236e7