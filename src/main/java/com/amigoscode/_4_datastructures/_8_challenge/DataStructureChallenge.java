package com.amigoscode._4_datastructures._8_challenge;

// Exercise: Data Structure Challenge
// Combine multiple data structures to solve a real-world problem.
// Manage a collection of students, group them, track recently viewed, and generate reports.

import java.util.*;

public class DataStructureChallenge {

    // TODO: 1 - Create a Student record (or class) with three fields:
    //           String name, int grade, String subject
    //           If using a record: record Student(String name, int grade, String subject) {}
    //           If using a class: include constructor, getters, and a toString() method
    static class Student {
        String name;
        int grade;
        String subject;

        public Student(String name, int grade, String subject) {
            this.name = name;
            this.grade = grade;
            this.subject = subject;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getGrade() {
            return grade;
        }

        public void setGrade(int grade) {
            this.grade = grade;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", grade=" + grade +
                    ", subject='" + subject + '\'' +
                    '}';
        }
    }


    public static void main(String[] args) {

        // TODO: 2 - Create a List of 10 students with various names, grades, and subjects
        //           Use at least 3 different subjects (e.g., "Math", "Science", "English")
        //           Example: new Student("Alice", 92, "Math")
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 92, "Math"));
        students.add(new Student("John", 80, "Science"));
        students.add(new Student("Jean", 50, "English"));
        students.add(new Student("Juan", 55, "English"));
        students.add(new Student("Josef", 62, "English"));
        students.add(new Student("Alex", 37, "History"));
        students.add(new Student("Alexis", 48, "History"));
        students.add(new Student("Evelin", 100, "Math"));
        students.add(new Student("Elizabeth", 5, "Science"));
        students.add(new Student("Mary", 88, "Science"));
        students.add(new Student("Cassandra", 12, "Math"));
        // TODO: 3 - Use a Map<String, List<Student>> to group students by subject
        //           Iterate through the student list
        //           For each student, use computeIfAbsent() to get or create the list for their subject
        //           Then add the student to that list
        //           Print each subject and its students
        Map<String, List<Student>> studentsBySubject = new TreeMap<>();
        for(Student student : students){
            studentsBySubject.computeIfAbsent(student.subject, k -> new ArrayList<>()).add(student);
        }

        for (Map.Entry<String, List<Student>> entry : studentsBySubject.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // TODO: 4 - Use a Set<String> to find all unique subjects
        //           Iterate through the students and add each subject to the set
        //           Print the unique subjects
        Set<String> subjects = new HashSet<>();
        for (Map.Entry<String, List<Student>> entry : studentsBySubject.entrySet()){
            subjects.add(entry.getKey());
        }
        System.out.println("Unique subjects: " + subjects);
        // TODO: 5 - Use a Stack<Student> to track the last 3 students "viewed"
        //           Push any 3 students from the list onto the stack
        //           Then pop and print them to show the viewing history (most recent first)
        Stack<Student> viewed = new Stack<>();
        viewed.push(students.get(3));
        viewed.push(students.get(6));
        viewed.push(students.get(9));

        while (!viewed.empty()){
            System.out.println("Viewed: ");
            System.out.println(viewed);

            System.out.println("Viewed poped: ");
            System.out.println(viewed.pop());
        }

        // TODO: 6 - Sort the student list by grade in descending order using a Comparator
        //           Use list.sort() with Comparator.comparingInt() and .reversed()
        //           Print the sorted list
        students.sort(Comparator.comparingInt(Student::getGrade).reversed());
        System.out.println(students);
        // TODO: 7 - Print a summary report:
        //           - Total number of students
        //           - Number of unique subjects (from the Set)
        //           - Highest grade student (first in sorted list)
        //           - Number of students per subject (from the Map)
        System.out.println("Total number of students: " + students.size());
        System.out.println("Number of unique subjects: " + subjects.size());
        System.out.println("Highest grade student: " + students.get(0));

        for (Map.Entry<String, List<Student>> entry : studentsBySubject.entrySet()){
            System.out.println("Subject: " + entry.getKey() + " Number of students: " + entry.getValue().size() );
        }
    }
}
