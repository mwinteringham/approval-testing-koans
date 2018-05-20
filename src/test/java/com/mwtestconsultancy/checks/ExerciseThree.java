package com.mwtestconsultancy.checks;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;
import com.mwtestconsultancy.html.Browser;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExerciseThree {

    // Exercise Three
    //
    // Not only can we approve data sets, we can compare and approve images. For this
    // exercise we are going to use the tool Applitools to take screenshots of our browser
    // page and push them up to Applitools to compare. To get this to work you will need
    // to create a free account with Applitools (https://applitools.com/) and grab your
    // private API key.

    // Example:
    //
    // This example is taken from the Applitools website that demonstrates how you can
    // use Applitools to take screenshots from a browser and then upload it to Applitools
    // for verification (Which you can view here: https://eyes.applitools.com/app/test-results)
    @Test
    public void approveApplitools(){
        // Open a Chrome browser.
        WebDriver driver = new Browser().returnDriver();

        // Initialize the eyes SDK and set your private API key.
        // The eyes SDK is what is used by Applitools to integrate Selenium-WebDriver and
        // Applitools together to take a screenshot and upload it to their servers for
        // verification and approval.
        Eyes eyes = new Eyes();
        eyes.setApiKey("===YOUR-API-KEY===");

        try{
            // Start the test and set the browser's viewport size to 800x600.
            eyes.open(driver, "Hello World!", "My first Selenium Java test!",
                    new RectangleSize(800, 600));

            // Navigate the browser to the "hello world!" web-site.
            driver.get("https://applitools.com/helloworld");

            // Visual checkpoint #1.
            eyes.checkWindow("Hello!");

            // Click the "Click me!" button.
            driver.findElement(By.tagName("button")).click();

            // Visual checkpoint #2.
            eyes.checkWindow("Click!");

            // End the test.
            eyes.close();
        } finally {
            // Close the browser.
            driver.quit();

            // If the test was aborted before eyes.close was called, ends the test as aborted.
            eyes.abortIfNotClosed();
        }
    }

    // Exercise 3.1
    //
    // Fill in this final test using the Applitools SDK and get it to take a screenshot of the
    // Car web page and get Applitools to approve it.
    //
    // Remember to check https://eyes.applitools.com/app/test-results to work with the results.
    //
    // Once approved, try changing the car on the webpage to see what happens when you run the
    // test again.
    @Test
    public void approveUiVisually(){
        WebDriver driver = new Browser().returnDriver();

        Eyes eyes = new Eyes();
        eyes.setApiKey("YOUR_API_KEY");

        try{

        } finally {
            driver.quit();

            eyes.abortIfNotClosed();
        }
    }
}
