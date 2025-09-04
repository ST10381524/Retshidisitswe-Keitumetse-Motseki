/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.prog6112pracassignment;

//(OpenAI, 2025)
import org.junit.jupiter.api.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lab_services_student
 */
public class SeriesTest {

    private Series series;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() throws Exception {
        series = new Series();
        System.setOut(new PrintStream(outContent));
        series.resetSeries();

        // Replace private scanner with a test scanner
        Field scannerField = Series.class.getDeclaredField("scanner");
        scannerField.setAccessible(true);
        scannerField.set(series, new Scanner(System.in));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    // Helper to set scanner input
    private void setScannerInput(String input) throws Exception {
        Scanner testScanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        Field scannerField = Series.class.getDeclaredField("scanner");
        scannerField.setAccessible(true);
        scannerField.set(series, testScanner);
    }

    @Test
    void testSearchSeries() throws Exception {
        setScannerInput("101\nExtreme Sports\n12\n10\n");
        series.captureSeries();

        outContent.reset();
        setScannerInput("101\n");
        series.searchSeries();

        String output = outContent.toString();
        assertTrue(output.contains("SERIES ID: 101"));
        assertTrue(output.contains("SERIES NAME: Extreme Sports"));
        assertTrue(output.contains("SERIES AGE RESTRICTION: 12"));
        assertTrue(output.contains("SERIES NUMBER OF EPISODES: 10"));
    }

    @Test
    void testSearchSeries_SeriesNotFound() throws Exception {
        setScannerInput("999\n");
        series.searchSeries();
        String output = outContent.toString();
        assertTrue(output.contains("Series with ID 999 was not found"));
    }

    @Test
    void testUpdateSeries() throws Exception {
        setScannerInput("101\nOld Name\n12\n10\n");
        series.captureSeries();

        setScannerInput("New Name\n14\n15\n");
        series.updateSeries();

        outContent.reset();
        setScannerInput("101\n");
        series.searchSeries();
        String output = outContent.toString();
        assertTrue(output.contains("SERIES NAME: New Name"));
        assertTrue(output.contains("SERIES AGE RESTRICTION: 14"));
        assertTrue(output.contains("SERIES NUMBER OF EPISODES: 15"));
    }

    @Test
    void testDeleteSeries() throws Exception {
        setScannerInput("101\nTest Series\n12\n10\n");
        series.captureSeries();

        setScannerInput("101\nYes\n");
        series.deleteSeries();

        outContent.reset();
        setScannerInput("101\n");
        series.searchSeries();
        String output = outContent.toString();
        assertTrue(output.contains("was not found"));
    }

    @Test
    void testDeleteSeries_SeriesNotFound() throws Exception {
        setScannerInput("999\nYes\n");
        series.deleteSeries();
        String output = outContent.toString();
        assertTrue(output.contains("No series found with the given ID"));
    }

    @Test
    void testSeriesAgeRestriction_AgeValid() {
        assertTrue(series.seriesAgeRestriction("2"));
        assertTrue(series.seriesAgeRestriction("10"));
        assertTrue(series.seriesAgeRestriction("18"));
    }

    @Test
    void testSeriesAgeRestriction_SeriesAgeInValid() {
        assertFalse(series.seriesAgeRestriction("1"));
        assertFalse(series.seriesAgeRestriction("19"));
        assertFalse(series.seriesAgeRestriction("Ten"));
        assertFalse(series.seriesAgeRestriction(""));
        assertFalse(series.seriesAgeRestriction(null));
    }
}

//Reference list:
//Farrell, J. (2024). Java programming. Boston, MA: Cengage.
//OpenAI. 2025. ChatGPT (Mar 14 version) [Large language model]. https://chatgpt.com/share/68b9f1d8-1330-800f-b90f-48bb81c236e7