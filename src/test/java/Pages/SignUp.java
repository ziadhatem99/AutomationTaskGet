package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;


public class SignUp {
    SoftAssert softAssert = new SoftAssert();

    static WebDriver driver;
    public SignUp(WebDriver driver){
        this.driver=driver;
    }
    By firstName = By.id("nf-field-17");
    By secondName = By.id("nf-field-18");
    By email = By.id("nf-field-19");
    By phoneNumber = By.id("nf-field-20");
    By faceBookRadioButton = By.id("nf-label-class-field-23-0");
    By linkedInRadioButton = By.id("nf-label-class-field-23-1");
    By registerButton = By.id("nf-field-15");
    By courseDropDown = By.id("nf-field-22");
    By monthDropDown = By.id("nf-field-24");
    By boxToAssert = By.id("main");

    public void setFirstName(String FirstName) {
       driver.findElement(firstName).sendKeys(FirstName);
    }
    public void setLastName(String lastName) {
        driver.findElement(secondName).sendKeys(lastName);
    }
     public void setEmail(String Email) {
        driver.findElement(email).sendKeys(Email);
    }
    public void setPhone(String Phone) {
        driver.findElement(phoneNumber).sendKeys(Phone);
    }
    public void setCourseDropDown() {
        driver.findElement(courseDropDown).click();
    }
    public void setMonthDropDown() {
        driver.findElement(monthDropDown).click();
    }
    public void clickOnRegister(){
        driver.findElement(registerButton).click();
        String title = driver.getTitle();
       assertEquals(title , "Registration Form - CodenBox AutomationLab");
    }

    public void selectLinkedIn(){
        driver.findElement(linkedInRadioButton).click();
    }

}
