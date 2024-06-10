package org.example;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


// Define the Visitor class
public class Visitor {
    private String name;
    private Set<Membership> membershipsList;
    private int age;
    private String phoneNumber;
    private double balance;
    private String email;
    private String password;
    private String membership;
    private List<Membership> memberships = new ArrayList<>();
    private List<Discount> discountList = new ArrayList<>();
    private Set<Attraction> purchasedAttractions;



    public Visitor(String name, int age, String phoneNumber, double balance, String email, String password) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.email = email;
        this.password = password;
        this.membership = "None";
        membershipsList = new HashSet<>();
        purchasedAttractions = new HashSet<>();

    }


    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public String getMembership() {
        return membership;
    }

    public void deductBalance(double amount) {
        balance -= amount;
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void buyMembership(String membershipType, double membershipPrice, String discountCode) {
        // Check for and apply the discount based on the code.
        double discountedPrice = applyDiscount(membershipPrice, discountCode);

        if (balance >= discountedPrice) {
            // Deduct the discounted price from the visitor's balance.
            balance -= discountedPrice;

            // Add the purchased membership to the visitor's list of memberships.
            memberships.add(new Membership(membershipType, discountedPrice));

            System.out.println(membershipType + " membership purchased successfully. Your balance is now ₹" + balance);
        } else {
            System.out.println("Insufficient balance to purchase " + membershipType + " membership.");
        }


        if (balance >= discountedPrice) {
            // Deduct the membership price from the visitor's balance.
            balance -= discountedPrice;

            // Add the purchased membership to the visitor's list of memberships.
            Membership newMembership = new Membership(membershipType, discountedPrice);
            membershipsList.add(newMembership);
            System.out.println("Apply Discount Code: " + discountCode);
            System.out.println(membershipType + " purchased successfully. Your balance is now ₹" + balance);
        } else {
            System.out.println("Insufficient balance to purchase " + membershipType + ".");
        }
    }

    private double applyDiscount(double originalPrice, String discountCode) {
        // Check the discount code and calculate the discounted price.
        // If no discount is applicable or if the code is 'None', return the original price.
        if ("MINOR10".equals(discountCode)) {
            // Apply a 10% discount for a specific code.
            return originalPrice * 0.9; // 10% off
        } else if ("SENIOR20".equals(discountCode)) {
            // Apply a 20% discount for another code.
            return originalPrice * 0.8; // 20% off
        } else {
            // No applicable discount.
            return originalPrice;
        }
    }


    private Discount findDiscountByCode(String discountCode) {
        for (Discount discount : discountList) {
            if (discount.getCode().equalsIgnoreCase(discountCode)) {
                return discount; // Found a discount with the matching code.
            }
        }
        return null; // No discount found with the given code.
    }


    private double getMembershipPrice(String membershipType) {
        // Define the membership prices based on the membership type.
        double basicMembershipPrice = 20.0;
        double premiumMembershipPrice = 50.0;

        // Use a switch statement or if-else to determine the price based on the membership type.
        switch (membershipType) {
            case "Basic":
                return basicMembershipPrice;
            case "Premium":
                return premiumMembershipPrice;
            default:
                // Handle the case where an invalid membership type is provided.
                // You can return a default price or throw an exception, depending on your application's logic.
                throw new IllegalArgumentException("Invalid membership type: " + membershipType);
        }
    }


    public boolean hasPremiumMembership() {
        for (Membership membership : memberships) {
            if (membership.getMembershipType().equals("Premium")) {
                return true; // Found a premium membership.
            }
        }
        return false; // No premium membership found.
    }


    public boolean isMinor() {
        // Assuming the legal age for adults is 18, you can adjust this threshold as needed.
        int legalAdultAge = 18;

        // Check if the visitor's age is less than the legal adult age.
        return age < legalAdultAge;
    }

    public boolean isSenior() {
        // Assuming the age for senior citizens is 60, you can adjust this threshold as needed.
        int seniorAgeThreshold = 60;

        // Check if the visitor's age is greater than or equal to the senior age threshold.
        return age >= seniorAgeThreshold;
    }

    public String getMembershipType() {
        // Check if the visitor has a membership.
        if (membership != null) {
            // If the visitor has a membership, return the membership type.
            return membership;
        } else {
            // If the visitor does not have a membership, return a default value or handle accordingly.
            return "No Membership";
        }
    }


    public void buyTicket(Attraction selectedAttraction) {
        // Check if the visitor has a balance greater than or equal to the ticket price.
        double ticketPrice = selectedAttraction.getTicketPrice();
        if (balance >= ticketPrice) {
            // Deduct the ticket price from the visitor's balance.
            balance -= ticketPrice;

            // Add the selected attraction to the visitor's list of purchased attractions.
//            Attraction selectedAttraction = //get selected attraction
//                    purchasedAttractions.add(selectedAttraction);
            System.out.println("Ticket for " + selectedAttraction.getName() + " purchased successfully.");
            System.out.println("Your balance is now $" + balance);
        } else {
            System.out.println("Insufficient balance to purchase the ticket for " + selectedAttraction.getName());
        }
    }

}
