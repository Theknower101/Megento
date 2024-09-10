import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
public class LoginTestCase extends TestData {

@BeforeTest
public void setUp() {
	defualtConfiguration();
}
	
@Test(priority=1)
public void openLoginPage() {
	WebElement signUpButton=driver.findElement(By.cssSelector("div[class='panel header'] li[data-label='or'] a"));
	signUpButton.click();
}
@Test(priority=2)
public void checkLogo() {
	WebElement logo=driver.findElement(By.cssSelector("img[src='https://magento.softwaretestingboard.com/pub/static/version1695896754/frontend/Magento/luma/en_US/images/logo.svg']"));
	boolean isThere=logo.isDisplayed();
	Assert.assertEquals(isThere, true);
}
//@Test(priority=3)
//public void checkLoginEmail() {
//	WebElement email=driver.findElement(By.xpath("//input[@id='email']"));
//    int randomIndexEmail=rand.nextInt(emails.length);
//    email.sendKeys(emails[randomIndexEmail]);
//Assert.assertEquals(email.getText().contains("@gmail.com")||email.getText().contains("@hotmail.com")||email.getText().contains("@yahoo.com")||email.getText().contains("@yahoo.com"), true);
//	
//}
}
