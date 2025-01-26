import java.util.ArrayList;
import java.util.Scanner;

class Destination {
    String name;
    String startDate;
    String endDate;
    double budget;

    Destination(String name, String startDate, String endDate, double budget) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Destination: " + name + "\nStart Date: " + startDate + "\nEnd Date: " + endDate + "\nBudget: $" + budget;
    }
}

public class TravelItineraryPlanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Destination> itinerary = new ArrayList<>();
        boolean running = true;

        System.out.println("Welcome to the Travel Itinerary Planner!");

        while (running) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add a Destination");
            System.out.println("2. View Itinerary");
            System.out.println("3. Calculate Total Budget");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter destination name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter start date (YYYY-MM-DD): ");
                    String startDate = scanner.nextLine();
                    System.out.print("Enter end date (YYYY-MM-DD): ");
                    String endDate = scanner.nextLine();
                    System.out.print("Enter budget for this destination: ");
                    double budget = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    itinerary.add(new Destination(name, startDate, endDate, budget));
                    System.out.println("Destination added successfully!");
                    break;

                case 2:
                    System.out.println("\nYour Itinerary:");
                    if (itinerary.isEmpty()) {
                        System.out.println("No destinations added yet.");
                    } else {
                        for (Destination destination : itinerary) {
                            System.out.println(destination);
                            System.out.println("--------------------");
                        }
                    }
                    break;

                case 3:
                    double totalBudget = 0;
                    for (Destination destination : itinerary) {
                        totalBudget += destination.budget;
                    }
                    System.out.println("Total Budget for your trip: $" + totalBudget);
                    break;

                case 4:
                    running = false;
                    System.out.println("Thank you for using the Travel Itinerary Planner. Have a great trip!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}

