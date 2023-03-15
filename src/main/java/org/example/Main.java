package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        // Set system property for ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to a web page
        driver.get("https://amazon.com");

        // Maximize the browser window
        driver.manage().window().maximize();

        // Wait for 3 seconds
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        // Click on a link that opens a new window
        driver.findElement(By.linkText("Open New Window")).click();

        // Get the window handles of all open windows
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());

        // Switch to the new window
        driver.switchTo().window(windowHandles.get(1));

        // Do some actions on the new window
        driver.get("https://www.google.com");

        // Wait for 3 seconds
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        // Switch back to the original window
        driver.switchTo().window(windowHandles.get(0));

        // Do some actions on the original window
        driver.findElement(By.id("search-box")).sendKeys("Selenium WebDriver");

        // Close the browser window
        driver.quit();
    }
}
