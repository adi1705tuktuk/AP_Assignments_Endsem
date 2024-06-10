package org.example;

import java.util.ArrayList;
import java.util.List;

// Define the Attraction class
public class Attraction {
    private int id;
    private String name;
    private String description;
    private List<Attraction> zooAttractions;
    private int visitorCount;

    public void Zoo() {
        zooAttractions = new ArrayList<>();
    }

    public Attraction(String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

    public int getVisitorCount() {
        // Implement logic to retrieve the visitor count for this attraction.
        // You should have an attribute in your Attraction class to store the visitor count.
        int visitorCount = 0;
        return visitorCount;
    }

    public double getRevenue() {
        double revenue = 0;
        return revenue;
    }

    // You can define this list at the beginning of your program or in an appropriate location.
    public double getTicketPrice(Attraction attraction, Visitor visitor) {
        // Define default ticket prices for attractions.
        double defaultTicketPrice = 10.0; // Default price for attractions.

        // Check if the visitor has a premium membership (premium members have free access to attractions).
        if (visitor.hasPremiumMembership()) {
            return 0.0; // Premium members get free access.
        }

        // Check if the attraction exists in the zoo's list of attractions.
        if (zooAttractions.contains(attraction)) {
            // Check if the visitor is eligible for any discounts (e.g., minors or seniors).
            if (visitor.isMinor()) {
                return defaultTicketPrice - (0.10 * defaultTicketPrice); // 10% discount for minors.
            } else if (visitor.isSenior()) {
                return defaultTicketPrice - (0.20 * defaultTicketPrice); // 20% discount for seniors.
            } else {
                return defaultTicketPrice; // No discounts apply.
            }
        } else {
            // Handle the case where the attraction does not exist in the zoo's list.
            // You can throw an exception or return a default price, depending on your application's logic.
            throw new IllegalArgumentException("Invalid attraction: " + attraction.getName());
        }
    }

    public double getTicketPrice() {
        // Return the price of the ticket for this attraction.
        double ticketPrice = 0;
        return ticketPrice;
    }

}
