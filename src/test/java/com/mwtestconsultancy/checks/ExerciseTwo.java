package com.mwtestconsultancy.checks;

import com.mwtestconsultancy.api.CarApi;
import com.mwtestconsultancy.html.Browser;
import org.junit.Assert;
import org.junit.Test;

public class ExerciseTwo {

    // Exercise Two
    //
    // For these set of exercises we are going to use ApprovalTest against
    // an application under test to monitor changes in API responses and HTML
    //
    // The application under test can be found here:
    // https://github.com/mwinteringham/approval-testing-app/releases
    // To run it download the Jar and run it with java -jar
    //
    // Just like Exercise 1 use Approvals.verify replace each of the assertions
    // in these tests. Each test will increase in difficulty as the application
    // under test returns less and less deterministic data (I.E. data changes
    // each time)

    // Exercise 2.1
    //
    // Let's start with taking what we've learnt from exercise 1 and apply it
    // to a basic API call. Update the assert to use Approval.verify on the
    // status code.
    @Test
    public void approveApiStatusCode(){
        int infoEndpointStatusCode = CarApi.getInfoStatusCode();

        Assert.assertEquals(infoEndpointStatusCode, 200);
    }

    // Exercise 2.2
    //
    // We can use ApprovalTests to approve complex objects such as JSON response
    // bodies from API endpoints. Update the asserts with Approval.verify and
    // approve the JSON response body.
    //
    // Once you have the test approve, toggle the API to return a different car
    // and observe the output from Approvals.verify
    @Test
    public void approveCarApiBody(){
        String carResponseBody = CarApi.getCarResponseBody();

        Assert.assertTrue(carResponseBody.contains("\"company\": \"Ford\""));
        Assert.assertTrue(carResponseBody.contains("\"make\": \"Focus\""));
        Assert.assertTrue(carResponseBody.contains("\"price\": 20000"));
        Assert.assertTrue(carResponseBody.contains("\"datePurchased\": \"2018-01-01\""));
        Assert.assertTrue(carResponseBody.contains("\"image\": \"./focus.jpg\""));
    }

    // Exercise 2.3
    //
    // We can also use ApprovalTests to approve sections of complex HTML extracted
    // from a web page. Update the asserts with Approval.verify and approve the
    // returned HTML section extracted via Selenium WebDriver
    //
    // Once you have the test approve, toggle the web page to return a different car
    // and observe the output from Approvals.verify
    @Test
    public void approveCarHTMLDetails(){
        Browser browser = new Browser();
        String carDetailsHTML = browser.returnCarDetailsHTML();

        Assert.assertTrue(carDetailsHTML.contains("Ford"));
        Assert.assertTrue(carDetailsHTML.contains("Focus"));
        Assert.assertTrue(carDetailsHTML.contains("20000"));
        Assert.assertTrue(carDetailsHTML.contains("2018-01-01"));
    }

    // Scrubbers
    //
    // Sometimes when we work with data we lack control over the values in the objects
    // due to various reasons. Whilst it's always best to work with your team to increase
    // testability and learn how to control those values, sometimes it's unavoidable.
    // Having data that we can't control poses a problem when we try and approve our
    // objects as they keep changing but what we can do is apply a scrubber.
    //
    // Scrubbers use regex to find offending areas of an object that are subject to
    // uncontrollable change and replaces them with a fixed string such as ===SCRUBBED==.
    // You can see some examples of regex patterns in the Scrubber class

    // Exercise 2.4
    //
    // Using the method replaceAll() and selected scrubbers from the Scrubber class,
    // scrub the response body string of fields that are uncontrollably changing and then
    // use Approvals.verify to approve the scrubbed object.
    @Test
    public void approveInfoBody(){
        String infoResponseBody = CarApi.getInfoResponseBody();

        Assert.assertTrue(infoResponseBody.contains("UP"));
        Assert.assertTrue(infoResponseBody.contains("1526658207331"));
        Assert.assertTrue(infoResponseBody.contains("Leonardo"));
    }

    // Exercise 2.5
    //
    // Using the method replaceAll() and selected scrubbers from the Scrubber class,
    // scrub the HTML from the web page that contains values that are uncontrollably
    // changing and then use Approvals.verify to approve the scrubbed object.
    @Test
    public void approveCarHTML(){
        Browser browser = new Browser();
        String carHTML = browser.returnCarPageHTML();

        Assert.assertTrue(carHTML.contains("id=\"timestamp\">1526660150606"));
        Assert.assertTrue(carHTML.contains("id=\"guid\" value=\"5fa4b5b5-309e-ed81-1c01-8287676a88b5\""));
    }


}
