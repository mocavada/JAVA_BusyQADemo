package com.busyqa.project.shoppingcart.pojo;

public class Customer {
    private String name;
    private long membershipID;

    public Customer(long membershipID, String name) {
        this.name = name;
        this.membershipID = membershipID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMembershipID() {
        return membershipID;
    }

    public void setMembershipID(long membershipID) {
        this.membershipID = membershipID;
    }
}
