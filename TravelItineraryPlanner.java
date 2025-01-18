import java.util.ArrayList;
import java.util.Scanner;

public class TravelItineraryPlanner {

    // Step 1: Destination Class - Holds destination data
    static class Destination {
        private String name;
        private String date;
        private String preference; // e.g. Adventure, Relax, etc.

        public Destination(String name, String date, String preference) {
            this.name = name;
            this.date = date;
            this.preference = preference;
        }

        public String getName() {
            return name;
        }

        public String getDate() {
            return date;
        }

        public String getPreference() {
            return preference;
        }

        @Override
        public String toString() {
            return name + " on " + date + " (Preference: " + preference + ")";
        }
    }

    // Step 2: WeatherService Class - Simulates fetching weather information for destinations
    static class WeatherService {
        public static String getWeather(String destination) {
            // Simulated weather data based on destination
            switch (destination.toLowerCase()) {
                case "paris":
                    return "Sunny, 22°C";
                case "tokyo":
                    return "Cloudy, 18°C";
                case "new york":
                    return "Rainy, 15°C";
                default:
                    return "Weather data not available";
            }
        }
    }

    // Step 3: BudgetCalculator Class - Simulates budget calculation based on user preferences
    static class BudgetCalculator {
        public static double calculateBudget(String preference) {
            double budget = 0;
            switch (preference.toLowerCase()) {
                case "adventure":
                    budget = 1000;
                    break;
                case "relax":
                    budget = 1500;
                    break;
                case "luxury":
                    budget = 3000;
                    break;
                default:
                    budget = 2000;
                    break;
            }
            return budget;
        }
    }

    // Step 4: ItineraryPlanner Class - Manages itinerary generation and display
    static class ItineraryPlanner {
        private ArrayList<Destination> itinerary;

        public ItineraryPlanner() {
            itinerary = new ArrayList<>();
        }

        public void addDestination(String name, String date, String preference) {
            itinerary.add(new Destination(name, date, preference));
        }

        public void displayItinerary() {
            System.out.println("\nYour Travel Itinerary:");
            for (Destination dest : itinerary) {
                System.out.println(dest);
                System.out.println("Weather: " + WeatherService.getWeather(dest.getName()));
                System.out.println("Estimated Budget: $" + BudgetCalculator.calculateBudget(dest.getPreference()));
                System.out.println("-------------------------------");
            }
        }
    }

    // Main method in TravelItineraryPlanner class
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ItineraryPlanner planner = new ItineraryPlanner();

        System.out.println("Welcome to the Travel Itinerary Planner!");

        // User input loop for multiple destinations
        while (true) {
            System.out.print("\nEnter destination (or type 'done' to finish): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter date of visit (e.g., 2025-01-30): ");
            String date = scanner.nextLine();

            System.out.print("Enter preference (Adventure, Relax, Luxury): ");
            String preference = scanner.nextLine();

            planner.addDestination(name, date, preference);
        }

        // Display the complete itinerary
        planner.displayItinerary();
        scanner.close();
    }
}
