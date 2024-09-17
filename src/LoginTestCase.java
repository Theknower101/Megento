import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
@Test(priority=3)
public void checkLogin() throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    boolean loginSuccessfully=false;
    while (!loginSuccessfully) {
             try {
            // Locate the elements inside the loop to avoid stale element exceptions
            WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
            WebElement passwordLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//fieldset[@class='fieldset login']//input[@id='pass']")));
            WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("fieldset[class='fieldset login'] div[class='primary'] span")));

            // Generate random email and password indexes
            int randomIndexEmail = rand.nextInt(emails.length);
            int randomIndexPassword = rand.nextInt(password.length);

            // Clear previous inputs
            email.clear();
            passwordLogin.clear();

            email.sendKeys(emails[randomIndexEmail]);
            passwordLogin.sendKeys(password[randomIndexPassword]);

            submitButton.click();

            try {
                WebElement loginError = driver.findElement(By.cssSelector("div[data-bind='html: $parent.prepareMessageForHtml(message.text)']"));

                // If loginError is displayed, continue the loop
                if (loginError.isDisplayed()) {
                    System.out.println("Login failed. Trying again...");
                }
            } catch (Exception e) {
                // If no loginError element is found, assume login was successful
                loginSuccessfully = true;

                // Validate that the entered email matches expected domains
                String enteredEmail = email.getAttribute("value");
                boolean isValidEmail = enteredEmail.contains("@gmail.com") || enteredEmail.contains("@hotmail.com") || enteredEmail.contains("@yahoo.com");

                // Assert the validity of the email
                Assert.assertEquals(enteredEmail, isValidEmail);
                System.out.println("Login successful with email: " + enteredEmail);
            }
             }
             catch(Exception e) {
            	 System.out.println(e);
             }
}

}
@Test(priority=4)
public void checkLogoLogin() {
	checkLogo();
}
}
