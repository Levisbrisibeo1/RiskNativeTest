package stepdefinitions;

import io.cucumber.java.en.*;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.WebFormPage;

public class WebFormSteps {

    WebDriver driver;
    WebFormPage form;

    @Given("User launches the web form")
    public void launchWebForm() {
        driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        form = new WebFormPage(driver);
    }

    @When("User fills out the form")
    public void fillOutForm() {
        form.textInput.sendKeys("John Doe");
        form.passwordInput.sendKeys("Secret123");
        form.textarea.sendKeys("This is a message.");

        // Dropdown (select)
        new Select(form.dropdownSelect).selectByVisibleText("One");

        // Type an option in the Data list field
        form.dropdownDatalist.sendKeys("New York");

        //Use to upload an image 
        String filePath = System.getProperty("user.dir") + "/src/test/resources/Images/car.png";
        form.fileInput.sendKeys(filePath);


        // Checkbox
        if (!form.checkedCheckbox.isSelected()) {
            form.checkedCheckbox.click();
        }

        // Radio button
        if (!form.checkedRadio.isSelected()) {
            form.checkedRadio.click();
        }

        // Color picker
        form.colorPicker.sendKeys("#00ff00");

        // Date picker
        form.datePicker.sendKeys("2025-04-03");

        // Range slider
        form.rangeSlider.sendKeys("6");
    }

    @And("User submits the form")
    public void submitForm() {
        form.submitForm();
    }

    @Then("Form should be submitted successfully")
    public void verifySubmission() {
        // Wait for the confirmation text
        new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));

        // Grab the confirmation
        String heading = driver.findElement(By.tagName("h1")).getText();
        String message = driver.findElement(By.tagName("p")).getText();

        // Assertions
        Assert.assertEquals("Form submitted", heading);
        Assert.assertEquals("Received!", message);

        driver.quit(); // Close only after assertion
    }

}
