package com.mwtestconsultancy.html;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

    private WebDriver driver;

    public Browser() {
        OS OS = new OS();
        String pathToChromeDriver = "";

        if (OS.isWindows()) {
            pathToChromeDriver = System.getProperties().get("user.dir") + "/lib/drivers/chromedriver.exe";
        } else if (OS.isMac()) {
            pathToChromeDriver = System.getProperties().get("user.dir") + "/lib/drivers/chromedriver_mac";
        } else if (OS.isUnix()) {
            pathToChromeDriver = System.getProperties().get("user.dir") + "/lib/drivers/chromedriver_linux";
        }

        System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
        driver = new ChromeDriver();
    }

    public String returnCarDetailsHTML(){
        driver.navigate().to("http://localhost:8080/");
        String html = driver.findElement(By.cssSelector(".details")).getAttribute("innerHTML");

        driver.quit();
        return html;
    }

    public String returnCarPageHTML(){
        driver.navigate().to("http://localhost:8080/");
        String html = driver.findElement(By.cssSelector(".container")).getAttribute("innerHTML");

        driver.quit();
        return html;
    }

    public WebDriver returnDriver(){
        return driver;
    }
}
