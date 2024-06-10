package org.example;

import java.util.ArrayList;
import java.util.List;

// Define the Discount class
public class Discount {
    private String category;

    private double percentage;

    public Discount(String category, double percentage) {
        this.category = category;
        this.percentage = percentage;
    }

    public String getCategory() {
        return category;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(int newDiscountPercentage) {
        this.percentage = newDiscountPercentage;
    }

    public String getCode() {
        // Return the discount code for this discount.
        String code = null;
        return code;
    }

    private static List<Discount> discountList = new ArrayList<>();

    // In your initialization method
    private static void initializeDiscounts() {
        discountList.add(new Discount("None", 0.0));
        discountList.add(new Discount("MINOR10", 10.0));
        discountList.add(new Discount("SENIOR20", 20.0));
        // Add more discounts as needed
    }

}
