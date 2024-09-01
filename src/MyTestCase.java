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

public class MyTestCase {
WebDriver driver=new ChromeDriver();
String url="https://magento.softwaretestingboard.com/";
Random rand=new Random();
@BeforeTest
public void setUp() {
	driver.get(url);
}

@Test(priority=1)
public void transferToSignUpPage() {	
	WebElement signUpButton=driver.findElement(By.cssSelector("header[class='page-header'] li:nth-child(3) a:nth-child(1)"));
	signUpButton.click();
}

@Test(priority=2)
public void enterFirstName() {
	String firstNames[]= {"Ahmad","Mohammad","Ali","Omar"};
	WebElement firstNameField=driver.findElement(By.id("firstname"));
	int randomIndexFirstName=rand.nextInt(firstNames.length);
	firstNameField.sendKeys(firstNames[randomIndexFirstName]);
}
@Test(priority=3)
public void enterLastName() {
	String lastNames[]= {"Allan","Almoqdad","Alabadi","Damra","Aljammal"};
	int randomIndexLastName=rand.nextInt(lastNames.length);
	WebElement lastNameField=driver.findElement(By.id("lastname"));
	lastNameField.sendKeys(lastNames[randomIndexLastName]);
}
@Test(priority=4)
public void enterEmail() {
	String emails[]= {"AhmadAllan123@gmal.com","Mohammad123@gmail.com","Ali123@gmail.com","Omar123@gmail.com","Dina123@gmail.com"};
      int randomIndexEmail=rand.nextInt(emails.length);
	WebElement emailField=driver.findElement(By.id("email_address"));
	emailField.sendKeys(emails[randomIndexEmail]);
}
@Test(priority=5)
public void enterPassword() {
	    WebElement submitButton=driver.findElement(By.cssSelector("button[title='Create an Account']"));
		String password[]= {"Aa@123456789","1234567890","Ahmad@12345678900","Beto@000000000","Mohammad1999@0987654321","123"};
		WebElement confirmPasswordField=driver.findElement(By.id("password-confirmation"));
		String passwordStringConfirm=confirmPasswordField.getText();
		String passwordString=driver.findElement(By.id("password")).getText();
		 boolean isStrongOrMedium = false;  // Flag to control the loop

		    while (!isStrongOrMedium) {  // Continue looping until a strong or medium password is found
		        int randomIndex = rand.nextInt(password.length);
		        WebElement passwordField = driver.findElement(By.id("password"));
		        String passwordIndex = password[randomIndex];
		        passwordField.clear();
		        passwordField.sendKeys(passwordIndex);
		        
		         // Clear the confirmation field before entering a new password
		        confirmPasswordField.clear(); 
		        confirmPasswordField.sendKeys(passwordIndex);
		        // Re-fetch the password strength text after entering the password
		        String passwordStrength = driver.findElement(By.id("password-strength-meter-label")).getText();

		        // Check if the password strength is "Strong", "Very Strong", or "Medium"
		        if (passwordStrength.contains("Strong") || passwordStrength.contains("Very Strong") || passwordStrength.contains("Medium")) {
		            isStrongOrMedium = true;  
					System.out.println(passwordString);
					System.out.println(passwordStringConfirm);// Exit the loop if a strong, very strong, or medium password is found
		AssertJUnit.assertEquals(passwordStringConfirm.equals(passwordString), true);
		submitButton.click();
		if(passwordStringConfirm!=passwordString) {
			WebElement passwordConfirmation=driver.findElement(By.id("password-confirmation-error"));
			Assert.assertEquals(passwordConfirmation, true);

		}
		 }
		}
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


