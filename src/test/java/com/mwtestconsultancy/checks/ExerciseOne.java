package com.mwtestconsultancy.checks;

import com.mwtestconsultancy.MyCar;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ExerciseOne {

    // Exercise One
    //
    // For the first set of exercises we are focusing on using the Approval Tests API
    // to verify different data types.
    //
    // Using Approvals.verify replace each of the assertions in these tests. Some will
    // require you to update objects to make them easier to approve.

    // Exercise 1.1 - Approve a basic data type 1
    //
    // Let's start with familiarising ourselves with ApprovalTests API. Replace the assert
    // with Approvals.verify to observe what happens when we approve a String.
    @Test
    public void approveBasicDataType1(){
        String stringToApprove = "Hello World";

        Assert.assertEquals(stringToApprove, "Hello World");
    }

    // Exercise 1.2 - Approve a basic data type 2
    //
    // This exercise demonstrates how ApprovalTests can take approve different data types.
    // Replace the assert with Approvals.verify to observe what happens when we approve an
    // integer. Once you've tried that, update the integer to other data types to see what
    // ApprovalTests can work with.
    @Test
    public void approveBasicDataType2(){
        int integerToApprove = 256;

        Assert.assertEquals(integerToApprove, 256);
    }

    // Exercise 1.3 - Approve a collection of data
    //
    // This exercise demonstrates how ApprovalTests can take collections of data such as
    // Lists and Arrays to approve. Once again, replace the assert with Approvals.verify
    // and observe what happens.
    //
    // Once you have the list of fruits passing in ApprovalTests spend some time modifying
    // the order of the list or changing the values in the list and see how ApprovalTests
    // demonstrates the changes between versions of the data.
    @Test
    public void approveDataCollection(){
        List<String> listOfFruits = new ArrayList<>();
        listOfFruits.add("Apple");
        listOfFruits.add("Pear");
        listOfFruits.add("Orange");

        Assert.assertEquals(listOfFruits.toString(), "[Apple, Pear, Orange]");
    }

    // Exercise 1.4 - Approve a Java Object
    //
    // For this final exercise we are going to approve the internal state of an object
    // created from the MyCar class. Replace the assert with Approvals.verify and observe
    // what happens.
    //
    // Then refactor the MyCar class to make it easier for you to Approve the internal state.
    // HINT: ApprovalTest loves Strings!
    @Test
    public void approveJavaObject(){
        MyCar myCar = new MyCar("SEAT", "Ibiza", 4000);

        Assert.assertEquals(myCar.getClass(), MyCar.class);
    }

}
