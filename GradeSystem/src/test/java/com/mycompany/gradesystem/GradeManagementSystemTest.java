/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.gradesystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lab_services_student
 */

//(Farrell, 2024)
public class GradeManagementSystemTest {

    public GradeManagementSystemTest() {
    }

    @Test
    public void testFindTopStudent() {
        Student st1 = new Student("Alice", new int[]{80, 90, 85});
        Student st2 = new Student("Bob", new int[]{50, 60, 70});
        Student[] students = {st1, st2};

        GradeManagementSystem gms = new GradeManagementSystem(students);

        assertEquals("Alice", gms.findTopStudent().getName());
    }

    @Test
    public void testSortingOrderInReport() {
        Student st1 = new Student("Alice", new int[]{80, 90, 85});
        Student st2 = new Student("Bob", new int[]{50, 60, 70});
        Student st3 = new Student("Charlie", new int[]{95, 92, 88});

        Student[] students = {st1, st2, st3};
        GradeManagementSystem gms = new GradeManagementSystem(students);

        String report = gms.generateReport();
        assertTrue(report.indexOf("Charlie") < report.indexOf("Alice"));
        assertTrue(report.indexOf("Alice") < report.indexOf("Bob"));
    }

    @Test
    public void testReportContainsAllStudents() {
        Student st1 = new Student("Alice", new int[]{80, 90, 85});
        Student st2 = new Student("Bob", new int[]{50, 60, 70});
        Student[] students = {st1, st2};

        GradeManagementSystem gms = new GradeManagementSystem(students);
        
        String report = gms.generateReport();
        assertTrue(report.contains("Alice"));
        assertTrue(report.contains("Bob"));
    }
}

//Reference list:
//Farrell, J. (2024). Java programming. Boston, MA: Cengage.
//OpenAI. 2025. ChatGPT (Mar 14 version) [Large language model]. https://chatgpt.com/share/68b9f1d8-1330-800f-b90f-48bb81c236e7