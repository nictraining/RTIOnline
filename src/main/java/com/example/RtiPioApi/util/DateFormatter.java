package com.example.RtiPioApi.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class DateFormatter {

    // DateTimeFormatter for date only (DD/MM/YYYY)
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // DateTimeFormatter for date and time (DD/MM/YYYY HH:MM:SS)
    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    // Private constructor to prevent instantiation of utility class
    private DateFormatter() {
        // Utility class
    }

    public static String format(LocalDate date) {
        if (date == null) {
            return null;
        }
        return date.format(DATE_FORMATTER);
    }

    public static String format(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return dateTime.format(DATETIME_FORMATTER);
    }

    public static LocalDate parseDate(String dateString) {
        if (dateString == null || dateString.trim().isEmpty()) {
            return null;
        }
        try {
            return LocalDate.parse(dateString, DATE_FORMATTER);
        } catch (java.time.format.DateTimeParseException e) {
            // Log error or throw a custom exception if strict parsing is needed
            System.err.println("Error parsing date string '" + dateString + "': " + e.getMessage());
            return null;
        }
    }


    public static LocalDateTime parseDateTime(String dateTimeString) {
        if (dateTimeString == null || dateTimeString.trim().isEmpty()) {
            return null;
        }
        try {
            return LocalDateTime.parse(dateTimeString, DATETIME_FORMATTER);
        } catch (java.time.format.DateTimeParseException e) {
            // Log error or throw a custom exception if strict parsing is needed
            System.err.println("Error parsing datetime string '" + dateTimeString + "': " + e.getMessage());
            return null;
        }
    }
}

