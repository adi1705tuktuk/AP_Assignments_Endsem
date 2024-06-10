package org.example;

import java.util.HashSet;
import java.util.Set;

public class Membership {
    private String membershipType;
    private double price;
    private Set<Membership> memberships = new HashSet<>();


    public Membership(String membershipType, double price) {
        this.membershipType = membershipType;
        this.price = price;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public double getPrice() {
        return price;
    }
    public boolean hasPremiumMembership() {

        for (Membership membership : memberships) {
            if(membership.getMembershipType().equals("Premium")) {
                return true;
            }
        }

        return false;
    }
}
