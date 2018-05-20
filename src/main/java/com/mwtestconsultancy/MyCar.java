package com.mwtestconsultancy;

import java.util.Date;

public class MyCar {

    private String make;
    private String model;
    private int price;
    private Date datePurchased;

    public MyCar(String make, String model, int price) {
        this.make = make;
        this.model = model;
        this.price = price;
        this.datePurchased = new Date("01/01/2012");
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }

    public Date getDatePurchased() {
        return datePurchased;
    }

}
