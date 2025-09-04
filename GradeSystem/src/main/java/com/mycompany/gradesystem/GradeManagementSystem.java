/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gradesystem;

/**
 *
 * @author lab_services_student
 */

//(Farrell, 2024)
public class GradeManagementSystem {
    //Declaration
    private Student[] students;
    
    //Constructor
    public GradeManagementSystem(Student[] students) {
        this.students = students;
    }
    
    //Bubble Sort students by average (descending order)
    private void sortStudentsByAverage() {
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length - i - 1; j++) {
                if (students[j].calculateAverage() < students[j + 1].calculateAverage()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }
    
    //Generate a full report of all students
    public String generateReport() {
        String report = "=== Grade Report ===\n";
        for (int i = 0; i < students.length; i++) {
            report += "Student: " +  students[i].getName() + "\nGrades: ";
            int[] grades = students[i].getGrades();
            int highest = grades[0];
            int lowest = grades[0];
            int sum = 0;
            
            for (int j = 0; j < grades.length; j++) {
                report += grades[j] + " ";
                sum += grades[j];
                if (grades[j] > highest) highest = grades[j];
                if (grades[j] < lowest) lowest = grades[j];
            }
            
            double average = (double) sum / grades.length;
            
            System.out.println("Average: " + average);
            System.out.println("Highest: " + highest);
            System.out.println("Lowest: " + lowest);
            System.out.println("\n\n");
        }
        return report;
    }
    
    //Find the student with the highest average
    public Student findTopStudent() {
        Student top = students[0];
        for (int i = 1; i < students.length; i++) {
            if (students[i].calculateAverage() > top.calculateAverage()) {
                top = students[i];
            }
        }
        return top;
    }
}

//Reference list:
//Farrell, J. (2024). Java programming. Boston, MA: Cengage.
//OpenAI. 2025. ChatGPT (Mar 14 version) [Large language model]. https://chatgpt.com/share/68b9f1d8-1330-800f-b90f-48bb81c236e7