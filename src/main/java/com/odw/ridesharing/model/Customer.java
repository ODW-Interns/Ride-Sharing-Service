package com.odw.ridesharing.model;

public class Customer extends User {
   
    private User customer;
    
    /**
     * default constructor: Creates a new customer which is an empty Person
     */
    public Customer() {
        this("", "", "", -1, -1);
    }
    
    /**
     * Creates a customer and give it an ID
     */
    /*public Customer(User customer_) {
        setCustomer(customer_);
    }*/
    public Customer(String firstName_, String lastName_, String sex_, int age_, int idx_) {
        super(firstName_, lastName_, sex_, age_, idx_);
    }
    
    /**
     * (non-Javadoc)
     * @see com.odw.ridesharing.model.InputType#getType()
     */
    
    /* Setters and Getters */
    /**
     * Get the customer
     * 
     * @return The customer to be executed
     */
    public User getCustomer() {
        return customer;
    }
    
    /**
     * Set the customer
     * 
     * @param The new customer to be set
     */
    public void setCustomer(User customer_) {
        this.customer = customer_;
    }

    
}
