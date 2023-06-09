package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "customer_order")
public class Customer_order {
    @Id
    @Column(name = "number")
    private int number;

    @Column(name = "date")
    private String date;

    @Column(name = "item")
    private String item;

    @Column(name = "price")
    private float price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // Constructors, getters, setters
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    public int getCustomerID() {
        return customer.getId();
    }

    public void setCustomerID(Customer customer) {
        customer.setId(customer.getId());
    }

    public void setCustomerID(int customerID) {
        customer.setId(customerID);
    }
}
