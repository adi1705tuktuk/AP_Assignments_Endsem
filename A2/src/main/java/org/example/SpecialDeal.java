package org.example;

// Define the SpecialDeal class
public class SpecialDeal {
    private int minAttractions;
    private String description;
    private double discountPercentage;

    public SpecialDeal(int minAttractions, double discountPercentage) {
        this.minAttractions = minAttractions;
        this.discountPercentage = discountPercentage;
    }

    public SpecialDeal(String description, int discountPercentage) {
        this.description = description;
        this.discountPercentage = discountPercentage;
    }

    public int getMinAttractions() {
        return minAttractions;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public String getDescription() {
        return description;
    }

    SpecialDeal specialDeal1 = new SpecialDeal("Buy 2 tickets and get 15% off", 15);
    SpecialDeal specialDeal2 = new SpecialDeal("Buy 3 tickets and get 30% off", 30);


    public String getDiscount() {
        // Assuming that 'discount' is an attribute that stores the discount information
        String discount = null;
        return discount;
    }

    public SpecialDeal(String s) {
    }

}
