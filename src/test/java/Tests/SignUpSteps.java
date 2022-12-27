package Tests;

import com.github.javafaker.Faker;
import Pages.SignUp;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignUpSteps {
  public int getRandomNumber(int min, int max) {
    return (int) ((Math.random() * (max - min)) + min);
  }

  public static WebDriver driver;
  @BeforeTest
  public void beforeTest(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(2000 , TimeUnit.MILLISECONDS);
    driver.manage().window().maximize();
    driver.get("https://codenboxautomationlab.com/registration-form/");
  }
  @Test(priority = 1)
  public void registerProcess(){
    SignUp signUp = new SignUp(driver);

    try {

      signUp.setFirstName(Faker.instance().name().firstName());
      signUp.setLastName(Faker.instance().name().lastName());
      signUp.setEmail(Faker.instance().name().firstName() + "@gmail.com");
      signUp.setPhone("+2010" + getRandomNumber(00000000 , 99999999));
      signUp.selectLinkedIn();
      signUp.clickOnRegister();

    }catch (Exception e){
      System.out.println(e.fillInStackTrace());
      driver.quit();
    }
  }
}
