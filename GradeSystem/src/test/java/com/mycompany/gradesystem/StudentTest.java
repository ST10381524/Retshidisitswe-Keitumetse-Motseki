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
public class StudentTest {

    public StudentTest() {
    }

    @Test
    public void testCalculateAverage() {
        Student st = new Student("Test", new int[]{80, 90, 100});
        assertEquals(90.0, st.calculateAverage(), 0.01);
    }

    @Test
    public void testCalculateAverageWithSingleGrade() {
        Student st = new Student("Single", new int[]{75});
        assertEquals(75.0, st.calculateAverage(), 0.01);
    }

    @Test
    public void testGradesStoredCorrectly() {
        int[] grades = {60, 70, 80};
        Student st = new Student("Bob", grades);
        assertArrayEquals(grades, st.getGrades());
    }
    
    @Test
    public void testNameStoredCorrectly() {
        Student st = new Student("Alice", new int[]{50, 60});
        assertEquals("Alice", st.getName());
    }
}

//Reference list:
//Farrell, J. (2024). Java programming. Boston, MA: Cengage.
//OpenAI. 2025. ChatGPT (Mar 14 version) [Large language model]. https://chatgpt.com/share/68b9f1d8-1330-800f-b90f-48bb81c236e7