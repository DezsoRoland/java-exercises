package com.amigoscode._1_beginners._1_thebasics;

import java.util.Arrays;
import java.util.Locale;

/**
 * Exercise: Strings
 *
 * Learn how to work with Strings in Java.
 * Strings are objects that represent sequences of characters and come with
 * many useful built-in methods.
 */
public class StringExercises {

    public static void main(String[] args) {

        String message = "Hello, Welcome to Amigoscode!";
        String padded = "   Hello World   ";
        String csv = "apple,banana,cherry,date,elderberry";

        // TODO: 1 - Get the length of the 'message' string and print it
        // Hint: Use the .length() method
        System.out.println(message.length());


        // TODO: 2 - Convert 'message' to uppercase and lowercase, and print both
        // Hint: Use .toUpperCase() and .toLowerCase()
        System.out.println(message.toUpperCase());
        System.out.println(message.toLowerCase());


        // TODO: 3 - Get a substring of 'message' containing the first 5 characters and print it
        // Hint: Use .substring(startIndex, endIndex)
        System.out.println(message.substring(0,5));


        // TODO: 4 - Check if 'message' contains the word "Amigoscode" and print the result
        // Hint: Use .contains()
        System.out.println(message.contains("Amigoscode"));

        // TODO: 5 - Replace "Amigoscode" with "Java" in 'message' and print the new string
        // Hint: Use .replace(oldValue, newValue)
        System.out.println(message.replace("Amigoscode", "Java"));


        // TODO: 6 - Trim the whitespace from the 'padded' string and print the result
        // Hint: Use .trim()
        System.out.println(padded.trim());


        // TODO: 7 - Split the 'csv' string by commas into a String array and print each element
        // Hint: Use .split(",") then loop through the resulting array

        String[] newCsv = csv.split(",");
        for(String item: newCsv) {
            System.out.println(item);
        }


        // TODO: 8 - Check if two strings are equal using .equals() (not ==)
        // Create two String variables with the same text content and compare them.
        // Print the result of .equals() and explain why == may not work for Strings.
        String content = "content";
        String content2 = "content";
        System.out.println(content.equals(content2));
        System.out.println(content == content2);

        String newContent = new String("content");
        String newContent2 = new String("content");
        System.out.println(newContent.equals(newContent2));
        System.out.println(newContent == newContent2);

        // "==" is checking if the variable is pointing to the same object/reference
        // .equals() checks if the content is the same

    }
}
