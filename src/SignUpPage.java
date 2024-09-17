import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;

public class SignUpPage extends TestData{

	public void transferToSignUpPageTest() {
		WebElement signUpButton=driver.findElement(By.cssSelector("header[class='page-header'] li:nth-child(3) a:nth-child(1)"));
		signUpButton.click();
	}
	public void enterFirstNameTest() {
		String firstNames[]= {"Ahmad","Mohammad","Ali","Omar"};
		WebElement firstNameField=driver.findElement(By.id("firstname"));
		int randomIndexFirstName=rand.nextInt(firstNames.length);
		firstNameField.sendKeys(firstNames[randomIndexFirstName]);
	}
	public void enterLastNameTest() {
		String lastNames[]= {"Allan","Almoqdad","Alabadi","Damra","Aljammal"};
		int randomIndexLastName=rand.nextInt(lastNames.length);
		WebElement lastNameField=driver.findElement(By.id("lastname"));
		lastNameField.sendKeys(lastNames[randomIndexLastName]);
	}
	public void enterEmailTest() {
	      int randomIndexEmail=rand.nextInt(emails.length);
		WebElement emailField=driver.findElement(By.id("email_address"));
		emailField.sendKeys(emails[randomIndexEmail]);
		
	}
	public void enterPasswordTest() {
	    WebElement submitButton=driver.findElement(By.cssSelector("button[title='Create an Account']"));
		
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

