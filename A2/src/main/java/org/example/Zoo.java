package org.example;

import java.util.*;

// Define the Zoo class
public class Zoo {
    private List<Animal> animals;
    private List<Attraction> attractions;
    private Map<String, Discount> discounts;
    private List<SpecialDeal> specialDeals;
    private List<Visitor> visitors;
    private int eventId;
    private String eventName;
    private Object eventDescription;

    private String eventDate;


    public Zoo() {
        animals = new ArrayList<>();
        attractions = new ArrayList<>();
        discounts = new HashMap<>();
        specialDeals = new ArrayList<>();
        visitors = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void addAttraction(Attraction attraction) {
        attractions.add(attraction);
    }

    public void addDiscount(String category, double percentage) {
        discounts.put(category, new Discount(category, percentage));
    }


    public void addSpecialDeal(String dealName, int minAttractions, double discountPercentage) {
        specialDeals.add(new SpecialDeal(minAttractions, discountPercentage));
    }

    public boolean registerVisitor(Visitor visitor) {
        for (Visitor v : visitors) {
            if (v.getEmail().equals(visitor.getEmail())) {
                return false; // Visitor with the same email already exists
            }
        }
        visitors.add(visitor);
        return true;
    }

    public Visitor loginVisitor(String email, String password) {
        for (Visitor visitor : visitors) {
            if (visitor.getEmail().equals(email) && visitor.getPassword().equals(password)) {
                return visitor;
            }
        }
        return null; // Visitor not found
    }

    public void printAdminMenu() {
        System.out.println("Admin Menu:");
        System.out.println("1. Manage Attractions");
        System.out.println("2. Manage Animals");
        System.out.println("3. Schedule Events");
        System.out.println("4. Set Discounts");
        System.out.println("5. Set Special Deal");
        System.out.println("6. View Visitor Stats");
        System.out.println("7. View Feedback");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }

    public void viewAttractions() {
        System.out.println("Attractions in the Zoo:");
        List<Attraction> attractions = getAttractions(); // Replace with your actual method to retrieve attractions.

        if (attractions.isEmpty()) {
            System.out.println("No attractions available.");
        } else {
            for (Attraction attraction : attractions) {
                System.out.println(attraction.getName() + " - " + attraction.getDescription());
            }
        }
    }

    private List<Attraction> getAttractions() {
        // Replace this with your actual data structure to retrieve attractions.
        // For example, if you have a list of attractions in your Zoo class:
        List<Attraction> attractionsList = null;
        return attractionsList; // Assuming 'attractionsList' is a field in your Zoo class.
    }

    public void modifyAttraction(int attractionId, String newName, String newDescription) {
        // Find the attraction with the given ID and update its details.
        Attraction[] attractionsList = new Attraction[0];
        for (Attraction attraction : attractionsList) {
            if (attraction.getId() == attractionId) {
                attraction.setName(newName);
                attraction.setDescription(newDescription);
                System.out.println("Attraction details updated successfully.");
                return; // Exit the loop once the attraction is found and updated.
            }
        }

        // If the attraction with the specified ID is not found.
        System.out.println("Attraction with ID " + attractionId + " not found.");
    }

    public void updateAnimalDetails(int animalId, String newAnimalName, String newAnimalType) {
        // Find the animal with the given ID and update its details.
        Animal[] animalsList = new Animal[0];
        for (Animal animal : animalsList) {
            if (animal.getId() == animalId) {
                animal.setName(newAnimalName);
                animal.setType(newAnimalType);
                System.out.println("Animal details updated successfully.");
                return; // Exit the loop once the animal is found and updated.
            }
        }

        // If the animal with the specified ID is not found.
        System.out.println("Animal with ID " + animalId + " not found.");
    }

    public void addEvent(Event newEvent) {
        // Assuming you have a List<Event> to store events in your class
        Set<CharSequence> eventsList = new HashSet<>(); // Assuming you want a Set of CharSequence objects
        eventsList.add((CharSequence) newEvent);
    }

    public void updateEventDetails(int eventId, String newEventName, String newEventDescription, String newEventDate) {
        if (this.eventId == eventId) {
            this.eventName = newEventName;
            this.eventDescription = newEventDescription;
            this.eventDate = newEventDate;
        }
    }

    public void removeEvent(int removeEventId) {
        if (this.eventId == removeEventId) {
            // Set the event attributes to null or empty values to "remove" the event.
            this.eventName = null;
            this.eventDescription = null;
            this.eventDate = null;
        }
    }

    public void modifyDiscount(String modifyDiscountCategory, int newDiscountPercentage) {
        // Iterate through the list of discounts and find the one with the specified category.
        Discount[] discountList = new Discount[0];
        for (Discount discount : discountList) {
            if (discount.getCategory().equalsIgnoreCase(modifyDiscountCategory)) {
                // Update the discount percentage.
                discount.setPercentage(newDiscountPercentage);
                System.out.println("Discount for category " + modifyDiscountCategory + " modified to " + newDiscountPercentage + "%");
                return; // Exit the loop once the discount is modified.
            }
        }

        // If the discount with the specified category is not found.
        System.out.println("Discount for category " + modifyDiscountCategory + " not found.");
    }

    public int getTotalVisitors() {
        // Calculate the total number of visitors based on the information available.
        int totalVisitors = 0;

        // Iterate through the list of attractions and sum up visitor counts from each attraction.
        Attraction[] attractionsList = new Attraction[0];
        for (Attraction attraction : attractionsList) {
            totalVisitors += attraction.getVisitorCount();
        }
        return totalVisitors;
    }

    public double getTotalRevenue() {
        // Calculate the total revenue based on the information available.
        double totalRevenue = 0.0;

        // Iterate through the list of attractions and sum up their revenue.
        Attraction[] attractionsList = new Attraction[0];
        for (Attraction attraction : attractionsList) {
            totalRevenue += attraction.getRevenue();
        }
        return totalRevenue;
    }

    public String getMostPopularAttraction() {
        // Determine the most popular attraction based on the information available.
        String mostPopularAttraction = "N/A"; // Default value if there is no popular attraction.

        int maxVisitorCount = 0; // Initialize the maximum visitor count to zero.

        // Iterate through the list of attractions and find the one with the highest visitor count.
        Attraction[] attractionsList = new Attraction[0];
        for (Attraction attraction : attractionsList) {
            int visitorCount = attraction.getVisitorCount();
            if (visitorCount > maxVisitorCount) {
                maxVisitorCount = visitorCount;
                mostPopularAttraction = attraction.getName();
            }
        }

        return mostPopularAttraction;
    }

    public List<String> getFeedbackList() {
        List<String> feedbackList = new ArrayList<>();

        // For example, you might fetch feedback from a database or another data source.
        // Here, we'll add some example feedback for demonstration purposes.
        feedbackList.add("Great zoo! Loved the lions.");
        feedbackList.add("The zoo is well-maintained.");
        feedbackList.add("Need more food options.");
        feedbackList.add("Awesome experience!");

        return feedbackList;
    }

    public List<SpecialDeal> getSpecialDeals() {
        // Create an empty list to store special deals.
        List<SpecialDeal> specialDeals = new ArrayList<>();

        specialDeals.add(new SpecialDeal("Buy 2 tickets and get 15% off"));
        specialDeals.add(new SpecialDeal("Buy 3 tickets and get 30% off"));
        // Add more special deals as needed.

        return specialDeals;
    }


    public void removeSpecialDeal(String removeDealName) {
        // For example, if you have a list of special deals, you can search and remove by name.
        // Note: This code assumes you have a List<SpecialDeal> to manage special deals.
        List<SpecialDeal> specialDeals = getSpecialDeals(); // Replace with your actual method to get special deals.

        SpecialDeal removedDeal = null;

        for (SpecialDeal deal : specialDeals) {
            if (deal.getDescription().equals(removeDealName)) {
                // Found the deal by name; remove it.
                removedDeal = deal;
                specialDeals.remove(deal);
                break; // Assuming you want to remove only one deal with the matching name.
            }
        }

        if (removedDeal != null) {
            System.out.println("Removed the special deal: " + removedDeal.getDescription());
        } else {
            System.out.println("No special deal with the name '" + removeDealName + "' found.");
        }
    }

    public List<Discount> getDiscounts() {
        // Replace this with your logic to fetch the list of discounts.
        // You can create a list and add discounts to it.
        List<Discount> discounts = new ArrayList<>();
        discounts.add(new Discount("None", 0));
        discounts.add(new Discount("MINOR", 10));
        discounts.add(new Discount("SENIOR", 20));
        // Add more discounts as needed.
        return discounts;
    }

    public void removeDiscount(String removeDiscountCategory) {
        // Iterate through the list of discounts and remove the one with a matching category.
        List<Discount> discounts = getDiscounts(); // Replace with your method to get the list of discounts.
        Discount discountToRemove = null;

        for (Discount discount : discounts) {
            if (discount.getCategory().equalsIgnoreCase(removeDiscountCategory)) {
                discountToRemove = discount;
                break;
            }
        }

        if (discountToRemove != null) {
            discounts.remove(discountToRemove);
            System.out.println("Discount with category '" + removeDiscountCategory + "' removed.");
        } else {
            System.out.println("No discount with category '" + removeDiscountCategory + "' found.");
        }
    }

    public void removeAnimal(int removeAnimalId) {
        // Find and remove the animal with the specified ID.
        Animal animalToRemove = null;
        for (Animal animal : animals) {
            if (animal.getId() == removeAnimalId) {
                animalToRemove = animal;
                break;
            }
        }

        if (animalToRemove != null) {
            animals.remove(animalToRemove);
            System.out.println("Animal with ID " + removeAnimalId + " removed successfully.");
        } else {
            System.out.println("Animal with ID " + removeAnimalId + " not found.");
        }
    }


    public void removeAttraction(int removeAttractionId) {
        // Find and remove the attraction with the specified ID.
        Attraction attractionToRemove = null;
        for (Attraction attraction : attractions) {
            if (attraction.getId() == removeAttractionId) {
                attractionToRemove = attraction;
                break;
            }
        }

        if (attractionToRemove != null) {
            attractions.remove(attractionToRemove);
            System.out.println("Attraction with ID " + removeAttractionId + " removed successfully.");
        } else {
            System.out.println("Attraction with ID " + removeAttractionId + " not found.");
        }
    }


    // Add other methods to manage attractions, events, discounts, special deals, etc.
}
