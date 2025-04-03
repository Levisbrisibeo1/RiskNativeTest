package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebFormPage {
    WebDriver driver;

    public WebFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "my-text-id")
    public WebElement textInput;

    @FindBy(name = "my-password")
    public WebElement passwordInput;

    @FindBy(name = "my-textarea")
    public WebElement textarea;


    @FindBy(name = "my-select")
    public WebElement dropdownSelect;

    @FindBy(name = "my-datalist")
    public WebElement dropdownDatalist;


    @FindBy(name = "my-file")
    public WebElement fileInput;


    @FindBy(id = "my-check-1")
    public WebElement checkedCheckbox;


    @FindBy(id = "my-radio-1")
    public WebElement checkedRadio;


    @FindBy(name = "my-colors")
    public WebElement colorPicker;


    @FindBy(name = "my-date")
    public WebElement datePicker;


    @FindBy(name = "my-range")
    public WebElement rangeSlider;


    @FindBy(css = "button[type='submit']")
    public WebElement submitButton;

    public void fillForm(String text, String password, String message) {
        textInput.sendKeys(text);
        passwordInput.sendKeys(password);
        textarea.sendKeys(message);
    }

    public void submitForm() {
        submitButton.click();
    }
}
