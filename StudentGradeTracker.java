import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> grades = new ArrayList<>();
        boolean keepRunning = true;

        System.out.println("===================================");
        System.out.println("    Student Grade Tracker        ");
        System.out.println("===================================");

        while (keepRunning) {
            System.out.println("\n Menu:");
            System.out.println("1.Add a Student's Grade");
            System.out.println("2.View All Grades");
            System.out.println("3️.Calculate Average Grade");
            System.out.println("4.Find Highest Grade");
            System.out.println("5.Find Lowest Grade");
            System.out.println("6.Reset All Grades");
            System.out.println("7.Exit");
            System.out.print("\n Choose an option (1-7): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addGrade(scanner, grades);
                    break;

                case 2:
                    displayGrades(grades);
                    break;

                case 3:
                    calculateAndDisplayAverage(grades);
                    break;

                case 4:
                    findAndDisplayHighest(grades);
                    break;

                case 5:
                    findAndDisplayLowest(grades);
                    break;

                case 6:
                    resetGrades(grades);
                    break;

                case 7:
                    System.out.println("\nThank you for using Student Grade Tracker! Goodbye!");
                    keepRunning = false;
                    break;

                default:
                    System.out.println("❌ Invalid choice. Please select a valid option.");
            }
        }

        scanner.close();
    }

    // Method to add a grade
    public static void addGrade(Scanner scanner, ArrayList<Integer> grades) {
        System.out.print("\nEnter the student's grade (0-100): ");
        int grade = scanner.nextInt();
        if (grade >= 0 && grade <= 100) {
            grades.add(grade);
            System.out.println("✅ Grade " + grade + " added successfully!");
        } else {
            System.out.println("❌ Invalid grade. Please enter a value between 0 and 100.");
        }
    }

    // Method to display all grades
    public static void displayGrades(ArrayList<Integer> grades) {
        if (grades.isEmpty()) {
            System.out.println("\n📄 No grades recorded yet.");
        } else {
            System.out.println("\n📄 Recorded Grades: " + grades);
        }
    }

    // Method to calculate and display the average grade
    public static void calculateAndDisplayAverage(ArrayList<Integer> grades) {
        if (grades.isEmpty()) {
            System.out.println("\n❌ No grades available to calculate the average.");
        } else {
            double average = calculateAverage(grades);
            System.out.printf("\n📊 Average Grade: %.2f%n", average);
        }
    }

    // Method to find and display the highest grade
    public static void findAndDisplayHighest(ArrayList<Integer> grades) {
        if (grades.isEmpty()) {
            System.out.println("\n❌ No grades available to find the highest.");
        } else {
            int highest = Collections.max(grades);
            System.out.println("\n🏆 Highest Grade: " + highest);
        }
    }

    // Method to find and display the lowest grade
    public static void findAndDisplayLowest(ArrayList<Integer> grades) {
        if (grades.isEmpty()) {
            System.out.println("\n❌ No grades available to find the lowest.");
        } else {
            int lowest = Collections.min(grades);
            System.out.println("\n📉 Lowest Grade: " + lowest);
        }
    }

    // Method to reset all grades
    public static void resetGrades(ArrayList<Integer> grades) {
        grades.clear();
        System.out.println("\n🔄 All grades have been reset.");
    }

    // Helper method to calculate the average of grades
    public static double calculateAverage(ArrayList<Integer> grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }
}
