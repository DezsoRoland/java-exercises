package com.amigoscode._4_datastructures._7_maps;

// Exercise: Word Frequency Counter using HashMap
// A practical exercise to count word occurrences in a sentence.

import java.util.*;

public class HashMapWordCount {

    public static void main(String[] args) {

        String sentence = "the cat sat on the mat and the cat ate the rat on the mat";

        // TODO: 1 - Split the sentence into an array of words using split(" ")
        String[] words = sentence.split(" ");
        System.out.println(Arrays.toString(words));
        // TODO: 2 - Create a HashMap<String, Integer> called 'wordCount'
        //           Iterate through the words array and count the frequency of each word
        //           Hint: use getOrDefault(word, 0) + 1 to increment the count
        HashMap<String, Integer> wordCount = new HashMap<>();
        for (String word : words){
            wordCount.put(word, wordCount.getOrDefault(word,0) +1);
        }

        // TODO: 3 - Print each word and its count by iterating over the map
        //           Format: "<word>: <count>"
        wordCount.entrySet().forEach(x -> System.out.println("word: " + x.getKey() + " - Count: " + x.getValue()));

        // TODO: 4 - Find and print the most frequent word
        //           Iterate through the entrySet and track the entry with the highest value
        Map.Entry<String, Integer> mostFrequent = null;
        for (Map.Entry<String, Integer> word : wordCount.entrySet()){
            if(mostFrequent == null || word.getValue() > mostFrequent.getValue()) {
                mostFrequent = word;
            }
        }
        System.out.println("Most frequent: " + mostFrequent.getKey() + " - " + mostFrequent.getValue() + "x");
        // TODO: 5 - Find and print all words that appear only once
        //           Iterate through the entrySet and collect entries where value == 1

        for (Map.Entry<String, Integer> word : wordCount.entrySet()){
            if(word.getValue() == 1){
                System.out.println("Word 1x: " + word.getKey());
            }
        }

        // TODO: 6 - Sort the map entries by value (frequency) in descending order and print
        //           Hint: create a List from entrySet(), then sort using a Comparator
        //           that compares entry values in reverse order
        List<Map.Entry<String, Integer>> sorted = new ArrayList<>(wordCount.entrySet());
        sorted.sort(Comparator.comparing((Map.Entry<String, Integer> entry) -> entry.getValue()).reversed());
        //sorted.sort(Map.Entry.<String, Integer>comparingByValue().reversed());
        //sorted.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        System.out.println("Sorted by frequency:");
        System.out.println(sorted);
    }
}
