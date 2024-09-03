import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyTestCase extends TestData{

	SignUpPage sign=new SignUpPage();
	
@BeforeTest
public void setUp() {
	defualtConfiguration();
}

@Test(priority=1)
public void transferToSignUpPage() {	
	sign.transferToSignUpPageTest();
}

@Test(priority=2)
public void enterFirstName() {
	sign.enterFirstNameTest();
}
@Test(priority=3)
public void enterLastName() {
sign.enterLastNameTest();
}
@Test(priority=4)
public void enterEmail() {
sign.enterEmailTest();
}
@Test(priority=5)
public void enterPassword() {
	  sign.enterPasswordTest();

}
}
//@Test(priority=6)
//public void confirmTheName() {
//	WebElement name=driver.findElement(By.xpath("//div[@class='panel header']//span[@class='logged-in'][normalize-space()='Welcome, Ahmad Allan!']"));
//	boolean nameIsThere=name.isDisplayed();
//	Assert.assertEquals(nameIsThere, true);
//}
//
//}


