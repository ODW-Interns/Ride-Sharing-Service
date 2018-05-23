package com.odw.ridesharing.model;

import javax.money.Monetary;
import javax.money.MonetaryAmount;

import org.javamoney.moneta.Money;

public class Pickup {

    private int pickupID;
    private int customerID;
    private int driverID;
    private Location origin;
    private Location destination;
    private MonetaryAmount pickupCost;

    public Pickup() {
        this(-1, -1, -1, new Location(), new Location());
    }

    /**
     * Initialize a Pickup with IDs from car, driver, and customer
     * 
     * Includes the ride to and from
     * 
     * @param carID_
     *            This car's unique id
     * 
     * @param driverID_
     *            This driver's unique id
     * 
     * @param customerID_
     *            This customer's unique id
     * 
     * @param origin_
     *            the starting location of the driver in longitude and latitude
     * 
     * @param destination_
     *            the destination location in longitude and latitude
     */
    public Pickup(int idx_, int customerID_, int driverID_, Location origin_, Location destination_) {
        setPickupID(idx_);
        setCustomerID(customerID_);
        setDriverID(driverID_);
        setOrigin(origin_);
        setDestination(destination_);
        
        pickupCost = Money.of(0.d, RuntimeConstants.CURRENCY_CODE);
    }

    /**
     * Returns the pickup's information in String format.
     * 
     * @return The pickup information as a String.
     */
    @Override
    public String toString() {

        return "PickupID: " + getPickupID() +
               " | CustomerID: " + getCustomerID() +
               " | DriverID: " + getDriverID() +
               " | Origin (latitude, longitude): " + origin.toString() +
               " | Destination (latitude, longitude): " + destination.toString() +
               " | Total Cost: " + pickupCost.with(Monetary.getDefaultRounding()).toString();
    }

    /* Getters and Setters */

    /**
     * TODO
     * 
     * @return TODO
     */
    public MonetaryAmount getPickupCost() {
        return pickupCost;
    }

    /**
     * TODO
     * 
     * @param totalCost_
     *            TODO
     */
    public void setPickupCost(double totalCost_) {
        pickupCost = Money.of(totalCost_, RuntimeConstants.CURRENCY_CODE);
    }

    /**
     * Get the unique ID of the pickup.
     * 
     * @return Returns the pickup's ID.
     */
    public int getPickupID() {
        return pickupID;
    }

    /**
     * Get the unique ID of the pickup.
     * 
     * @param pickupID_
     *            The new ID for the pickup to be set to.
     */
    public void setPickupID(int pickupID_) {
        pickupID = pickupID_;
    }

    /**
     * Get the unique ID of the driver
     * 
     * @return The ID of the driver to be executed
     */
    public int getDriverID() {
        return driverID;
    }

    /**
     * Set the ID of the driver
     * 
     * @param The
     *            new ID of the driver to be set
     */
    public void setDriverID(int driverID_) {
        driverID = driverID_;
    }

    /**
     * Get the unique ID of the customer
     * 
     * @return The ID of the driver to be executed
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * Set the ID of the customer
     * 
     * @param The
     *            new ID of the customer to be set
     */
    public void setCustomerID(int customerID_) {
        customerID = customerID_;
    }

    /**
     * Get the x and y coordinates of the starting location for the Pickup
     * 
     * @return The origin of the Pickup to be executed
     */
    public Location getOrigin() {
        return origin;
    }

    /**
     * Set the x and y coordinates of the starting location for the Pickup
     * 
     * @param The
     *            new origin of the Pickup to be set
     */
    public void setOrigin(Location origin_) {
        origin = origin_;
    }

    /**
     * Get the x and y coordinates of the ending location for the Pickup
     * 
     * @return The end location of the Pickup to be executed
     */
    public Location getDestination() {
        return destination;
    }

    /**
     * Set the x and y coordinates of the ending location for the Pickup
     * 
     * @param The
     *            new end location of the Pickup to be set
     */
    public void setDestination(Location destination_) {
        destination = destination_;
    }
}
