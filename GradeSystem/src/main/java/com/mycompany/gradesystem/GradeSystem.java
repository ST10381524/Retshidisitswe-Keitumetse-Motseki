/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gradesystem;

import java.util.Scanner;
/**
 *
 * @author lab_services_student
 */

//(Farrell, 2024)
public class GradeSystem {

    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       
       System.out.print("Enter the number of students: ");
       int numStudents = input.nextInt();
       input.nextLine();
       
       Student[] students = new Student[numStudents];
       
       for (int i = 0; i < numStudents; i++) {
           System.out.print("Enter name of student " + (i + 1) + ": ");
           String firstName = input.nextLine();
           
           System.out.print("Enter surname of student " + (i + 1) + ": ");
           String lastName = input.nextLine();
           
           System.out.print("Enter number of marks for " + firstName + " " + lastName + ": ");
           int numGrades = input.nextInt();
           int[] grades = new int[numGrades];
           
           for (int j = 0; j < numGrades; j++) {
               System.out.print("Enter mark " + (j + 1) + ": ");
               grades[j] = input.nextInt();
           }
           input.nextLine();
           
           students[i] = new Student(firstName, grades);
       }
       
       GradeManagementSystem gms = new GradeManagementSystem(students);
       
       //Display report (sorted by average)
       System.out.println(gms.generateReport());
       
       //Show top student
       System.out.println("Top Student: " + gms.findTopStudent().getName());
    }
}

//Reference list:
//Farrell, J. (2024). Java programming. Boston, MA: Cengage.
//OpenAI. 2025. ChatGPT (Mar 14 version) [Large language model]. https://chatgpt.com/share/68b9f1d8-1330-800f-b90f-48bb81c236e7