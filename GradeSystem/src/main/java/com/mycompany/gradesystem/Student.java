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
public class Student extends Person {
    private int[] grades;
    
    public Student(String name, int[] grades) {
        super(name);
        this.grades = grades;
    }
    
    public int[] getGrades() {
        return grades;
    }
    
    //Calculate average using a loop
    public double calculateAverage() {
        int sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum+= grades[i];
        }
        return (double) sum / grades.length;
    }
}

//Reference list:
//Farrell, J. (2024). Java programming. Boston, MA: Cengage.
//OpenAI. 2025. ChatGPT (Mar 14 version) [Large language model]. https://chatgpt.com/share/68b9f1d8-1330-800f-b90f-48bb81c236e7