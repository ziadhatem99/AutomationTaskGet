package Tests;

import com.github.javafaker.Faker;
import Pages.SignUp;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignUpSteps {
  public int getRandomNumber(int min, int max) {
    return (int) ((Math.random() * (max - min)) + min);
  }
  public String getFirstName(){
    String s = Faker.instance().name().firstName();
    String s1 = s.substring(0, 1).toUpperCase();
    String s2 = s.substring(1);
    String firstName = s.substring(0, 1).toUpperCase() + s.substring(1);
    return firstName;
  }
  public String getLastName(){
    String s = Faker.instance().name().firstName();
    String s1 = s.substring(0, 1).toUpperCase();
    String s2 = s.substring(1);
    String lastName = s.substring(0, 1).toUpperCase() + s.substring(1);
    return lastName;
  }
  public static WebDriver driver;
  SignUp signUp;
  @BeforeTest
  public void driverSetup(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(2000 , TimeUnit.MILLISECONDS);
    driver.manage().window().maximize();
    driver.get("https://codenboxautomationlab.com/registration-form/");
  }
  @Test(priority = 1)
  public void registerProcess(){
    try {
      signUp = new SignUp(driver);
      signUp.setFirstName(getFirstName());
    }catch (Exception e){
      System.out.println(e.fillInStackTrace());
      driver.quit();
    }
  }
  @Test(priority = 2)
  public void enterSecondName(){
    try {
      signUp = new SignUp(driver);
      signUp.setLastName(getLastName());
    }catch (Exception e){
      System.out.println(e.fillInStackTrace());
      driver.quit();
    }
  }
  @Test(priority = 3)
  public void enterMail(){
    try {
      signUp = new SignUp(driver);
      signUp.setEmail(Faker.instance().name().firstName() + "@gmail.com");
    }catch (Exception e){
      System.out.println(e.fillInStackTrace());
      driver.quit();
    }
  }
  @Test(priority = 4)
  public void enterPhone(){
    try {
      signUp = new SignUp(driver);
      signUp.setPhone("+2010" + getRandomNumber(00000000 , 99999999));
    }catch (Exception e){
      System.out.println(e.fillInStackTrace());
      driver.quit();
    }
  }
  @Test(priority = 5)
  public void selectCourse()  {
    try {
      Select course = new Select(driver.findElement(By.id("nf-field-22")));
      course.selectByValue("mobile-automation");
    }catch (Exception e){
      System.out.println(e.fillInStackTrace());
      driver.quit();
    }
  }
  @Test(priority = 6)
  public void selectMonth()  {
    try {
      Select month = new Select(driver.findElement(By.id("nf-field-24")));
      month.selectByValue("march");
    }catch (Exception e){
      System.out.println(e.fillInStackTrace());
      driver.quit();
    }
  }
  @Test(priority = 7)
  public void enterLinkedIn(){
    try {
      signUp = new SignUp(driver);
      signUp.selectLinkedIn();
    }catch (Exception e){
      System.out.println(e.fillInStackTrace());
      driver.quit();
    }
  }
  @Test(priority = 8)
  public void clickRegister(){
    try {
      signUp = new SignUp(driver);
      signUp.clickOnRegister();
    }catch (Exception e){
      System.out.println(e.fillInStackTrace());
      driver.quit();
    }
  }

}
