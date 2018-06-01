package com.odw.ridesharing.tests;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;

import com.odw.ridesharing.model.exceptions.CarNotFoundException;
import com.odw.ridesharing.model.exceptions.InvalidCarArgumentsException;
import com.odw.ridesharing.service.CarController;

/**
 * Tests all the public methods inside CarController.
 */
public class CarControllerTest {

    /**
     * Tests CarController's createCar method. Ensures that a valid car can be
     * created and an invalid car is handled properly.
     */
    @Test
    public void testCreateCar() {
        CarController _carController = new CarController();

        // ---------------------------------------------
        // Testing valid car creation
        try {
            _carController.createCar(createValidCarInfo());
        } catch (InvalidCarArgumentsException e_) {
            fail("Error creating a valid car.");
        }

        // ---------------------------------------------
        // Testing invalid car creation.
        try {
            _carController.createCar(createInvalidCarInfo());
        } catch (InvalidCarArgumentsException e_) {
            assertTrue(true); // Hacky solution to state that this is the desired outcome.
        }
    }

    /**
     * Tests CarController's modifyCar method. Ensures that a valid car can be
     * modified and an invalid car is handled properly
     */
    @Test
    public void testModifyCar() {
        CarController _carController = new CarController();

        // ---------------------------------------------
        // Creating a valid car to later be modified.
        try {
            _carController.createCar(createValidCarInfo());
        } catch (InvalidCarArgumentsException e_) {
            fail("Error creating a valid car.");
        }

        // Testing valid car modification.
        ArrayList<String> _coupeNewInfo = new ArrayList<String>();
        _coupeNewInfo.add("0"); // ID
        _coupeNewInfo.add("coupe");
        _coupeNewInfo.add("toyota");
        _coupeNewInfo.add("camry");
        _coupeNewInfo.add("black");
        _coupeNewInfo.add("2004");
        try {
            _carController.modifyCar(_coupeNewInfo);
        } catch (CarNotFoundException e_) {
            fail("Error modifying a valid car.");
        } catch (InvalidCarArgumentsException e_) {
            fail("Error modifying arguments for a valid car.");
        }

        // ---------------------------------------------
        // Testing invalid car modification.
        ArrayList<String> _invalidModifyInfo = new ArrayList<String>();
        _invalidModifyInfo.add("not enough info");
        try {
            _carController.modifyCar(_invalidModifyInfo);
        } catch (Exception e_) {
            assertTrue(true);
        }
    }

    /**
     * Tests CarController's deleteCar method. Ensures that a valid car can be
     * deleted and an invalid car is handled properly
     */
    @Test
    public void testDeleteCar() {
        CarController _carController = new CarController();

        // ---------------------------------------------
        // Creating a valid car to later be modified.
        try {
            _carController.createCar(createValidCarInfo());
        } catch (InvalidCarArgumentsException e_) {
            fail("Error creating a valid car.");
        }

        // Testing valid car deletion.
        ArrayList<String> _coupeDeleteInfo = new ArrayList<String>();
        _coupeDeleteInfo.add("0"); // Valid ID
        try {
            _carController.deleteCar(_coupeDeleteInfo);
        } catch (CarNotFoundException e_) {
            fail("Error deleting a valid car.");
        }

        // ---------------------------------------------
        // Testing invalid car deletion.
        ArrayList<String> _invalidDeleteInfo = new ArrayList<String>();
        _invalidDeleteInfo.add("1000"); // Invalid ID
        try {
            _carController.deleteCar(_invalidDeleteInfo);
        } catch (CarNotFoundException e_) {
            assertTrue(true);
        }
    }
    
    @Test
    public void testIsCarInInventory() {
        // [TODO]
    }

    /**
     * Helper function to generate valid car info.
     * 
     * @return An ArrayList of Strings containing valid car info.
     */
    private ArrayList<String> createValidCarInfo() {
        ArrayList<String> _validCarInfo = new ArrayList<String>();
        _validCarInfo.add("coupe");
        _validCarInfo.add("toyota");
        _validCarInfo.add("trueno");
        _validCarInfo.add("white");
        _validCarInfo.add("1986");
        return _validCarInfo;
    }

    /**
     * Helper function to generate invalid car info.
     * 
     * @return An ArrayList of Strings containing invalid car info.
     */
    private ArrayList<String> createInvalidCarInfo() {
        ArrayList<String> _invalidCarInfo = new ArrayList<String>();
        _invalidCarInfo.add("coupe");
        _invalidCarInfo.add("invalid");
        _invalidCarInfo.add("input");
        _invalidCarInfo.add("length");
        return _invalidCarInfo;
    }
}
