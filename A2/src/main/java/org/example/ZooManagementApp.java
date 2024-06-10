package org.example;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class ZooManagementApp {
    static List<Visitor> visitorsList = new ArrayList<>();
    private static List<SpecialDeal> specialDealsList = new ArrayList<>();


    public static boolean adminLogin(String username, String password) {
        // Check if the provided username and password match the predefined admin credentials.
        if (username.equals("admin") && password.equals("admin123")) {
            return true; // Successful login
        }
        return false; // Invalid credentials
    }

    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        Scanner scanner = new Scanner(System.in);
        initializeAttractions();
        initializeAnimals();



        // Add initial data to the zoo (animals, attractions, discounts, special deals)

        while (true) {
            System.out.println("Welcome to ZOOtopia!");
            System.out.println("1. Enter as Admin");
            System.out.println("2. Enter as a Visitor");
            System.out.println("3. View Special Deals");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();


            if (choice == 1) {
                System.out.print("Enter Admin Username: ");
                String adminUsername = scanner.next();
                System.out.print("Enter Admin Password: ");
                String adminPassword = scanner.next();

                if (adminLogin(adminUsername, adminPassword)) {
                    System.out.println("Logged in as Admin.");
                    // Admin menu
                    while (true) {
                        zoo.printAdminMenu(); // Display the admin menu
                        int adminChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character

                        switch (adminChoice) {
                            case 1:
                                // Manage Attractions
                                System.out.println("Manage Attractions:");
                                System.out.println("1. Add Attraction");
                                System.out.println("2. View Attractions");
                                System.out.println("3. Modify Attraction");
                                System.out.println("4. Remove Attraction");
                                System.out.println("5. Exit");

                                System.out.print("Enter your choice: ");
                                int manageAttractionsChoice = scanner.nextInt();
                                scanner.nextLine(); // Consume the newline character

                                switch (manageAttractionsChoice) {
                                    case 1:
                                        // Add Attraction
                                        System.out.print("Enter Attraction Name: ");
                                        String attractionName = scanner.nextLine();
                                        System.out.print("Enter Attraction Description: ");
                                        String attractionDescription = scanner.nextLine();
                                        Attraction newAttraction = new Attraction(attractionName, attractionDescription);
                                        zoo.addAttraction(newAttraction);
                                        System.out.println("Attraction added successfully.");
                                        break;
                                    case 2:
                                        // View Attractions
                                        zoo.viewAttractions();
                                        break;
                                    case 3:
                                        // Modify Attraction
                                        System.out.print("Enter Attraction ID to modify: ");
                                        int attractionId = scanner.nextInt();
                                        scanner.nextLine(); // Consume the newline character
                                        System.out.print("Enter New Name: ");
                                        String newName = scanner.nextLine();
                                        System.out.print("Enter New Description: ");
                                        String newDescription = scanner.nextLine();
                                        zoo.modifyAttraction(attractionId, newName, newDescription);
                                        break;
                                    case 4:
                                        // Remove Attraction
                                        System.out.print("Enter Attraction ID to remove: ");
                                        int removeAttractionId = scanner.nextInt();
                                        scanner.nextLine(); // Consume the newline character
                                        zoo.removeAttraction(removeAttractionId);
                                        break;
                                    case 5:
                                        // Exit
                                        break;
                                    default:
                                        System.out.println("Invalid choice. Please try again.");
                                }
                                break;

                            case 2:
                                // Manage Animals
                                System.out.println("Manage Animals:");
                                System.out.println("1. Add Animal");
                                System.out.println("2. Update Animal Details");
                                System.out.println("3. Remove Animal");
                                System.out.println("4. Exit");

                                System.out.print("Enter your choice: ");
                                int manageAnimalsChoice = scanner.nextInt();
                                scanner.nextLine(); // Consume the newline character

                                switch (manageAnimalsChoice) {
                                    case 1:
                                        // Add Animal
                                        System.out.print("Enter Animal Name: ");
                                        String animalName = scanner.nextLine();
                                        System.out.print("Enter Animal Type (Mammal, Amphibian, or Reptile): ");
                                        String animalType = scanner.nextLine();
                                        Animal newAnimal = new Animal(1, animalName, animalType);
                                        zoo.addAnimal(newAnimal);
                                        System.out.println("Animal added to the zoo.");
                                        break;
                                    case 2:
                                        // Update Animal Details
                                        System.out.print("Enter Animal ID to update: ");
                                        int animalId = scanner.nextInt();
                                        scanner.nextLine(); // Consume the newline character
                                        System.out.print("Enter New Name: ");
                                        String newAnimalName = scanner.nextLine();
                                        System.out.print("Enter New Type (Mammal, Amphibian, or Reptile): ");
                                        String newAnimalType = scanner.nextLine();
                                        zoo.updateAnimalDetails(animalId, newAnimalName, newAnimalType);
                                        break;
                                    case 3:
                                        // Remove Animal
                                        System.out.print("Enter Animal ID to remove: ");
                                        int removeAnimalId = scanner.nextInt();
                                        scanner.nextLine(); // Consume the newline character
                                        zoo.removeAnimal(removeAnimalId);
                                        break;
                                    case 4:
                                        // Exit
                                        break;
                                    default:
                                        System.out.println("Invalid choice. Please try again.");
                                }
                                break;
                            case 3:
                                // Schedule Events
                                System.out.println("Schedule Events:");
                                System.out.println("1. Add Event");
                                System.out.println("2. Update Event Details");
                                System.out.println("3. Remove Event");
                                System.out.println("4. Exit");

                                System.out.print("Enter your choice: ");
                                int scheduleEventsChoice = scanner.nextInt();
                                scanner.nextLine(); // Consume the newline character

                                switch (scheduleEventsChoice) {
                                    case 1:
                                        // Add Event
                                        System.out.print("Enter Event Name: ");
                                        String eventName = scanner.nextLine();
                                        System.out.print("Enter Event Description: ");
                                        String eventDescription = scanner.nextLine();
                                        System.out.print("Enter Event Date: ");
                                        String eventDate = scanner.nextLine();
                                        Event newEvent = new Event(eventName, eventDescription, eventDate);
                                        zoo.addEvent(newEvent);
                                        System.out.println("Event added successfully.");
                                        break;
                                    case 2:
                                        // Update Event Details
                                        System.out.print("Enter Event ID to update: ");
                                        int eventId = scanner.nextInt();
                                        scanner.nextLine(); // Consume the newline character
                                        System.out.print("Enter New Name: ");
                                        String newEventName = scanner.nextLine();
                                        System.out.print("Enter New Description: ");
                                        String newEventDescription = scanner.nextLine();
                                        System.out.print("Enter New Date: ");
                                        String newEventDate = scanner.nextLine();
                                        zoo.updateEventDetails(eventId, newEventName, newEventDescription, newEventDate);
                                        break;
                                    case 3:
                                        // Remove Event
                                        System.out.print("Enter Event ID to remove: ");
                                        int removeEventId = scanner.nextInt();
                                        scanner.nextLine(); // Consume the newline character
                                        zoo.removeEvent(removeEventId);
                                        break;
                                    case 4:
                                        // Exit
                                        break;
                                    default:
                                        System.out.println("Invalid choice. Please try again.");
                                }
                                break;
                            case 4:
                                // Set Discounts
                                System.out.println("Set Discounts:");
                                System.out.println("1. Add Discount");
                                System.out.println("2. Modify Discount");
                                System.out.println("3. Remove Discount");
                                System.out.println("4. Exit");

                                System.out.print("Enter your choice: ");
                                int setDiscountsChoice = scanner.nextInt();
                                scanner.nextLine(); // Consume the newline character

                                switch (setDiscountsChoice) {
                                    case 1:
                                        // Add Discount
                                        System.out.print("Enter Discount Category: ");
                                        String discountCategory = scanner.nextLine();
                                        System.out.print("Enter Discount Percentage (e.g., 20 for 20%): ");
                                        int discountPercentage = scanner.nextInt();
                                        zoo.addDiscount(discountCategory, discountPercentage);
                                        System.out.println("Discount added successfully.");
                                        break;
                                    case 2:
                                        // Modify Discount
                                        System.out.print("Enter Discount Category to modify: ");
                                        String modifyDiscountCategory = scanner.nextLine();
                                        System.out.print("Enter New Percentage (e.g., 20 for 20%): ");
                                        int newDiscountPercentage = scanner.nextInt();
                                        zoo.modifyDiscount(modifyDiscountCategory, newDiscountPercentage);
                                        break;
                                    case 3:
                                        // Remove Discount
                                        System.out.print("Enter Discount Category to remove: ");
                                        String removeDiscountCategory = scanner.nextLine();
                                        zoo.removeDiscount(removeDiscountCategory);
                                        break;
                                    case 4:
                                        // Exit
                                        break;
                                    default:
                                        System.out.println("Invalid choice. Please try again.");
                                }
                                break;
                            case 5:
                                // Set Special Deal
                                System.out.println("Set Special Deals:");
                                System.out.println("1. Add Special Deal");
                                System.out.println("2. Remove Special Deal");
                                System.out.println("3. Exit");

                                System.out.print("Enter your choice: ");
                                int setSpecialDealChoice = scanner.nextInt();
                                scanner.nextLine(); // Consume the newline character

                                switch (setSpecialDealChoice) {
                                    case 1:
                                        // Add Special Deal
                                        System.out.print("Enter Deal Name: ");
                                        String dealName = scanner.nextLine();
                                        System.out.print("Enter Minimum Attractions for the Deal: ");
                                        int minAttractions = scanner.nextInt();
                                        System.out.print("Enter Discount Percentage (e.g., 15 for 15%): ");
                                        int discountPercentage = scanner.nextInt();
                                        zoo.addSpecialDeal(dealName, minAttractions, discountPercentage);
                                        System.out.println("Special Deal added successfully.");
                                        break;
                                    case 2:
                                        // Remove Special Deal
                                        System.out.print("Enter Deal Name to remove: ");
                                        String removeDealName = scanner.nextLine();
                                        zoo.removeSpecialDeal(removeDealName);
                                        break;
                                    case 3:
                                        // Exit
                                        break;
                                    default:
                                        System.out.println("Invalid choice. Please try again.");
                                }
                                break;
                            case 6:
                                // View Visitor Stats
                                System.out.println("Visitor Statistics:");

                                // Retrieve statistics from your Zoo object or data structures.
                                int totalVisitors = zoo.getTotalVisitors();
                                double totalRevenue = zoo.getTotalRevenue();
                                String mostPopularAttraction = zoo.getMostPopularAttraction();

                                System.out.println("- Total Visitors: " + totalVisitors);
                                System.out.println("- Total Revenue: $" + totalRevenue);
                                System.out.println("- Most Popular Attraction: " + mostPopularAttraction);

                                System.out.println("Press Enter to continue...");
                                scanner.nextLine(); // Wait for user input to continue
                                break;

                            case 7:
                                // View Feedback
                                System.out.println("Visitor Feedback:");

                                // Retrieve and display visitor feedback
                                List<String> feedbackList = zoo.getFeedbackList(); // Replace with your actual method to retrieve feedback.

                                if (feedbackList.isEmpty()) {
                                    System.out.println("No feedback available.");
                                } else {
                                    for (String feedback : feedbackList) {
                                        System.out.println(feedback);
                                    }
                                }

                                System.out.println("Press Enter to continue...");
                                scanner.nextLine(); // Wait for user input to continue
                                break;

                            case 8:
                                System.out.println("Logged out.");
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }

                        if (adminChoice == 8) {
                            break; // Exit the admin menu
                        }
                    }
                } else {
                    System.out.println("Invalid Admin credentials. Please try again.");
                }
            } else if (choice == 2) {
                // Visitor functionalities

                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.print("Enter your choice: ");
                int visitorChoice = scanner.nextInt();

                if (visitorChoice == 1) {
                    // Visitor Registration
                    System.out.print("Enter Visitor Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Visitor Age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter Visitor Phone Number: ");
                    String phoneNumber = scanner.next();
                    System.out.print("Enter Visitor Balance: ");
                    double balance = scanner.nextDouble();
                    System.out.print("Enter Visitor Email: ");
                    String email = scanner.next();
                    System.out.print("Enter Visitor Password: ");
                    String password = scanner.next();

                    // Create a new visitor and add them to the list of visitors (you should have a visitorsList).
                    Visitor newVisitor = new Visitor(name, age, phoneNumber, balance, email, password);
                    visitorsList.add(newVisitor);

                    System.out.println("Registration is successful.");
                } else if (visitorChoice == 2) {
                    // Visitor Login
                    System.out.print("Enter Visitor Email: ");
                    String loginEmail = scanner.next();
                    System.out.print("Enter Visitor Password: ");
                    String loginPassword = scanner.next();
                    loginEmail = loginEmail.trim();
                    loginPassword = loginPassword.trim();
                    // Check if a visitor with the provided email and password exists.
                    Visitor loggedInVisitor = findVisitorByEmailAndPassword(loginEmail, loginPassword, visitorsList);

                    if (loggedInVisitor != null) {
                        if (loggedInVisitor.getEmail().equalsIgnoreCase(loginEmail.trim()) && loggedInVisitor.getPassword().equals(loginPassword.trim())) {
                            System.out.println("Login Successful.");
                        }

                        while (true) {
                            System.out.println("Visitor Menu:");
                            System.out.println("1. Explore the Zoo");
                            System.out.println("2. Buy Membership");
                            System.out.println("3. Buy Tickets");
                            System.out.println("4. View Discounts");
                            System.out.println("5. View Special Deals");
                            System.out.println("6. Visit Animals");
                            System.out.println("7. Visit Attractions");
                            System.out.println("8. Leave Feedback");
                            System.out.println("9. Log Out");
                            System.out.print("Enter your choice: ");
                            int visitorMenuChoice = scanner.nextInt();

                            switch (visitorMenuChoice) {
                                case 1:
                                    // Explore the Zoo
                                    System.out.println("Explore the Zoo:");
                                    System.out.println("1. View Attractions");
                                    System.out.println("2. View Animals");
                                    System.out.println("3. Exit");
                                    System.out.print("Enter your choice: ");
                                    int exploreChoice = scanner.nextInt();

                                    switch (exploreChoice) {
                                        case 1:
                                            // View Attractions
                                            System.out.println("Attractions in the Zoo:");
                                            List<Attraction> attractions = getAttractions(); // Replace with your actual method to get attractions.
                                            for (int i = 0; i < attractions.size(); i++) {
                                                Attraction attraction = attractions.get(i);
                                                System.out.println((i + 1) + ". " + attraction.getName());
                                            }

                                            System.out.println(attractions.size() + 1 + ". Exit");
                                            System.out.print("Enter the attraction number to explore or " + (attractions.size() + 1) + " to Exit: ");
                                            int attractionChoice = scanner.nextInt();

                                            if (attractionChoice >= 1 && attractionChoice <= attractions.size()) {
                                                // Visitor wants to visit an attraction.
                                                Attraction selectedAttraction = attractions.get(attractionChoice - 1);

                                                System.out.println("Welcome to " + selectedAttraction.getName());
                                                System.out.println(selectedAttraction.getDescription());

                                                // Implement logic for the visitor's experience at the attraction.
                                                // You can call appropriate methods on the selectedAttraction object.

                                                System.out.println("Thank you for visiting " + selectedAttraction.getName());
                                            } else if (attractionChoice == attractions.size() + 1) {
                                                // Exit
                                                System.out.println("Exiting Explore the Zoo.");
                                            } else {
                                                System.out.println("Invalid choice. Please try again.");
                                            }
                                            break;

                                        case 2:
                                            // View Animals
                                            System.out.println("Animals in the Zoo:");
                                            List<Animal> animals = getAnimals(); // Replace with your actual method to get animals.
                                            for (Animal animal : animals) {
                                                System.out.println(animal.getName());
                                            }
                                            break;

                                        case 3:
                                            // Exit
                                            System.out.println("Exiting Explore the Zoo.");
                                            break;

                                        default:
                                            System.out.println("Invalid choice. Please try again.");
                                    }
                                    break;

                                case 2:
                                    // Buy Membership
                                    System.out.println("Buy Membership:");
                                    System.out.println("1. Basic Membership (₹20)");
                                    System.out.println("2. Premium Membership (₹50)");
                                    System.out.print("Enter your choice: ");
                                    int membershipChoice = scanner.nextInt();

// Prompt the visitor for a discount code
                                    System.out.print("Apply Discount Code (if any, or enter 'None' to skip): ");
                                    String discountCode = scanner.next();

                                    switch (membershipChoice) {
                                        case 1:
                                            // Basic Membership
                                            double basicMembershipPrice = 20.0;

                                            // Pass the discount code when purchasing the membership.
                                            loggedInVisitor.buyMembership("Basic", basicMembershipPrice, discountCode);

                                            break;
                                        case 2:
                                            // Premium Membership
                                            double premiumMembershipPrice = 50.0;

                                            // Pass the discount code when purchasing the membership.
                                            loggedInVisitor.buyMembership("Premium", premiumMembershipPrice, discountCode);

                                            break;
                                        case 3:
                                            // Exit
                                            System.out.println("Exiting Buy Membership.");
                                            break;
                                        default:
                                            System.out.println("Invalid choice. Please try again.");
                                    }

                                    break;
                                case 3:
                                    // Buy Tickets
                                    System.out.println("Buy Tickets:");

                                    // Display a list of available attractions with their prices.
                                    List<Attraction> attractions = getAttractions(); // Replace with your actual method to get attractions.
                                    System.out.println("1. Jungle Safari (₹10)");
                                    System.out.println("2. Botanical Garden (₹15)");
                                    System.out.println("3. Dinosaur Show (₹12)");

                                    System.out.println(attractions.size() + 1 + ". Exit");
                                    System.out.print("Enter the attraction number to buy a ticket or " + (attractions.size() + 1) + " to Exit: ");
                                    int ticketChoice = scanner.nextInt();

                                    if (ticketChoice >= 1 && ticketChoice <= attractions.size()) {
                                        // Visitor wants to buy a ticket.
                                        Attraction selectedAttraction = attractions.get(ticketChoice - 1);

                                        if (loggedInVisitor.getMembershipType().equals("Basic")) {
                                            // Basic members need to buy a ticket for each attraction.
                                            double ticketPrice = selectedAttraction.getTicketPrice();
                                            if (loggedInVisitor.getBalance() >= ticketPrice) {
                                                loggedInVisitor.buyTicket(selectedAttraction);
                                                System.out.println("The ticket for " + selectedAttraction.getName() + " was purchased successfully. Your balance is now ₹" + loggedInVisitor.getBalance());
                                            } else {
                                                System.out.println("Insufficient balance to purchase a ticket for " + selectedAttraction.getName() + ".");
                                            }
                                        } else {
                                            // Premium members have free access to attractions.
                                            System.out.println("Premium members have free access to " + selectedAttraction.getName() + ".");
                                        }
                                    } else if (ticketChoice == attractions.size() + 1) {
                                        // Exit
                                        System.out.println("Exiting Buy Tickets.");
                                    } else {
                                        System.out.println("Invalid choice. Please try again.");
                                    }
                                    break;
                                case 4:
                                    // View Discounts
                                    System.out.println("View Discounts:");

                                    // Display a list of available discounts.
                                    List<Discount> discounts = getDiscounts(); // Replace with your actual method to get discounts.
                                    for (Discount discount : discounts) {
                                        System.out.println(discount.getCategory() + " (" + discount.getPercentage() + "% discount) - " + discount.getCode());
                                    }

                                    System.out.println(discounts.size() + 1 + ". Exit");
                                    System.out.print("Enter the discount number to view details or " + (discounts.size() + 1) + " to Exit: ");
                                    int discountChoice = scanner.nextInt();

                                    if (discountChoice >= 1 && discountChoice <= discounts.size()) {
                                        // Visitor wants to view details of a discount.
                                        Discount selectedDiscount = discounts.get(discountChoice - 1);
                                        System.out.println("Discount Category: " + selectedDiscount.getCategory());
                                        System.out.println("Discount Percentage: " + selectedDiscount.getPercentage() + "%");
                                        System.out.println("Discount Code: " + selectedDiscount.getCode());
                                    } else if (discountChoice == discounts.size() + 1) {
                                        // Exit
                                        System.out.println("Exiting View Discounts.");
                                    } else {
                                        System.out.println("Invalid choice. Please try again.");
                                    }
                                    break;
                                case 5:
                                    // View Special Deals
                                    System.out.println("View Special Deals:");
                                    System.out.println("1. Buy 2 tickets and get 15% off");
                                    System.out.println("1. Buy 3 tickets and get 30% off");

                                    // Display a list of available special deals.
                                    List<SpecialDeal> specialDeals = getSpecialDeals(); // Retrieve the list of special deals
                                    for (int i = 0; i < specialDeals.size(); i++) {
                                        SpecialDeal specialDeal = specialDeals.get(i);
                                        System.out.println((i + 1) + ". " + specialDeal.getDescription());
                                        System.out.println("Invalid choice. Please try again.");

                                    }
                                    break;
                                case 6:
                                    // Visit Animals
                                    System.out.println("Visit Animals:");

                                    // Display a list of available animals.
                                    List<Animal> animals = getAnimals(); // Replace with your actual method to get animals.
                                    for (int i = 0; i < animals.size(); i++) {
                                        Animal animal = animals.get(i);
                                        System.out.println((i + 1) + ". " + animal.getName());
                                    }

                                    System.out.println(animals.size() + 1 + ". Exit");
                                    System.out.print("Enter the animal number to visit or " + (animals.size() + 1) + " to Exit: ");
                                    int animalChoice = scanner.nextInt();

                                    if (animalChoice >= 1 && animalChoice <= animals.size()) {
                                        // Visitor wants to visit an animal.
                                        Animal selectedAnimal = animals.get(animalChoice - 1);

                                        System.out.println("You are now visiting " + selectedAnimal.getName() + ".");
                                        // For demonstration purposes, let's assume you can only read about the animal.
                                        System.out.println("About " + selectedAnimal.getName() + ": " + selectedAnimal.getDescription());

                                        System.out.println("Thank you for your visit to " + selectedAnimal.getName() + ".");
                                    } else if (animalChoice == animals.size() + 1) {
                                        // Exit
                                        System.out.println("Exiting Visit Animals.");
                                    } else {
                                        System.out.println("Invalid choice. Please try again.");
                                    }
                                    break;

                                case 7:
                                    // Visit Attractions
                                    System.out.println("Visit Attractions:");

                                    // Display a list of available attractions.
                                    List<Attraction> attractionList = getAttractions(); // Use a different variable name like 'attractionList'.
                                    for (int i = 0; i < attractionList.size(); i++) {
                                        Attraction attraction = attractionList.get(i);
                                        System.out.println((i + 1) + ". " + attraction.getName());
                                    }

                                    System.out.println(attractionList.size() + 1 + ". Exit");
                                    System.out.print("Enter the attraction number to visit or " + (attractionList.size() + 1) + " to Exit: ");
                                    int attractionChoice = scanner.nextInt();

                                    if (attractionChoice >= 1 && attractionChoice <= attractionList.size()) {
                                        // Visitor wants to visit an attraction.
                                        Attraction selectedAttraction = attractionList.get(attractionChoice - 1);

                                        System.out.println("Welcome to " + selectedAttraction.getName());

                                        // For example, you can simulate the visitor's experience by displaying some information about the attraction.
                                        System.out.println("Attraction Description: " + selectedAttraction.getDescription());
                                        System.out.println("Visitor Count: " + selectedAttraction.getVisitorCount());

                                        System.out.println("Thank you for visiting " + selectedAttraction.getName());
                                    } else if (attractionChoice == attractionList.size() + 1) {
                                        // Exit
                                        System.out.println("Exiting Visit Attractions.");
                                    } else {
                                        System.out.println("Invalid choice. Please try again.");
                                    }
                                    break;
                                case 8:
                                    // Leave Feedback
                                    System.out.println("Leave Feedback:");
                                    scanner.nextLine(); // Consume the newline character from previous input.

                                    System.out.print("Enter your feedback (max 200 characters): ");
                                    String feedback = scanner.nextLine();

                                    if (feedback.length() > 200) {
                                        System.out.println("Feedback is too long. Please keep it within 200 characters.");
                                    } else {
                                        // Store the feedback or submit it to your feedback collection.
                                        // You should have a method or data structure to handle feedback submissions.
                                        // Example: feedbackCollection.addFeedback(feedback);

                                        System.out.println("Thank you for your feedback.");
                                    }
                                    break;
                                case 9:
                                    // Log Out
                                    System.out.println("Logged out.");

                                    // Here, you can provide the option to return to the main menu or exit the program.
                                    System.out.print("Do you want to return to the main menu? (y/n): ");
                                    String returnChoice = scanner.next().toLowerCase();

                                    if (returnChoice.equals("y")) {
                                        // Return to the main menu (you might use a loop or function call to achieve this).
                                        return;
                                    } else if (returnChoice.equals("n")) {
                                        // Exit the program.
                                        System.out.println("Exiting the program. Goodbye!");
                                        System.exit(0);// Exit the program with a status code (0 for successful exit).
                                        break;
                                    } else {
                                        System.out.println("Invalid choice. Exiting the program.");
                                        System.exit(1); // Exit the program with a non-zero status code to indicate an error.
                                    }
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please try again.");

                            }
                        }


                        // Proceed with visitor functionalities using the `loggedInVisitor` object.
                        // You can display the visitor-specific menu and actions here.
                    } else {
                        System.out.println("Login Failed. Invalid email or password.");
                        System.out.println("Email: " + loginEmail);
                        System.out.println("Password: " + loginPassword);
                    }
                    System.out.println("Invalid choice. Please try again.");
                }
            } else if (choice == 3) {
                // View special deals
                List<SpecialDeal> specialDeals = getSpecialDeals(); // Get the list of special deals from your data source or application
                System.out.println("1. Buy 2 tickets and get 15% off");
                System.out.println("1. Buy 3 tickets and get 30% off");
                if (specialDeals.isEmpty()) {
                    System.out.println("No special deals available other than the above.");
                } else {
                    System.out.println("Available Special Deals:");
                    for (int i = 0; i < specialDeals.size(); i++) {
                        System.out.println((i + 1) + ". " + specialDeals.get(i).getDescription());
                    }
                }
            } else {
                System.out.println("Invalid choice. Please try again.");
            }

        }
    }
    private static void initializeSpecialDeals() {
        specialDealsList.add(new SpecialDeal("Buy 2 tickets and get 15% off", 15));
        specialDealsList.add(new SpecialDeal("Buy 3 tickets and get 30% off", 30));
        // Add more special deals as needed
    }

    private static List<SpecialDeal> getSpecialDeals() {
        return specialDealsList;
    }


    private static List<Discount> getDiscounts() {
        List<Discount> discounts = new ArrayList<>();

        // Add available discounts to the list
        discounts.add(new Discount("None", 0));
        discounts.add(new Discount("MINOR10", 10));
        discounts.add(new Discount("SENIOR20", 20));
        // Add more discounts as needed

        return discounts;
    }


    private static List<Animal> animalsList = new ArrayList<>();

    // Method to populate the animals list (you can call this when initializing your application).
    private static void initializeAnimals() {
        animalsList.add(new Animal(1, "Lion", "Mammal"));
        animalsList.add(new Animal(2, "Zebra", "Mammal"));
        animalsList.add(new Animal(3, "Snake", "Reptile"));
        // Add more animals as needed.
    }

    // Method to get a list of animals.
    private static List<Animal> getAnimals() {
        return animalsList;
    }


    private static List<Attraction> attractionsList = new ArrayList<>();
    private static void initializeAttractions() {
        attractionsList.add(new Attraction("Jungle Safari", "ZOOtopia offers an adventure ride that allows you to explore unexplored trails. Buy your ticket now!"));
        attractionsList.add(new Attraction("Botanical Garden", "ZOOtopia offers an adventure ride that allows you to explore unexplored trails. Buy your ticket now!"));
        attractionsList.add(new Attraction("Dinosaur Show", "ZOOtopia offers an adventure ride that allows you to explore unexplored trails. Buy your ticket now!"));
    }

    private static List<Attraction> getAttractions() {
        return attractionsList;
    }
    List<Attraction> attractions = getAttractions();


    private static Visitor findVisitorByEmailAndPassword(String loginEmail, String loginPassword, List<Visitor> visitorsList) {
        for (Visitor visitor : visitorsList) {
            if (visitor.getEmail().equalsIgnoreCase(loginEmail) && visitor.getPassword().equals(loginPassword)) {
                return visitor; // Return the visitor if found.
            }
        }
        return null; // Return null if no matching visitor is found.
    }
}