import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestData {
	protected static WebDriver driver;
	String url="https://magento.softwaretestingboard.com/";
	Random rand=new Random();
	String emails[]= {"AhmadAllan1234@gmail.com","Mohammad1234@gmail.com"};
	String password[]= {"Ahmad@12345678900","Mohammad1999@0987654321"};
	  @BeforeSuite
	  public void configuration() {
		  if(driver==null) {
			  driver=new ChromeDriver();
			  driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		  }
	  }
	  @AfterSuite
	  public void tear() {
		  if(driver!=null) {
			  driver.quit();
			  driver=null;
		  }	
		  
	  }
	  public void defualtConfiguration() {
			driver.get(url);

	  }
	  public void checkLogo() {
		  WebElement logo=driver.findElement(By.cssSelector("img[src='https://magento.softwaretestingboard.com/pub/static/version1695896754/frontend/Magento/luma/en_US/images/logo.svg']"));
		   Assert.assertEquals(logo.isDisplayed(), true);
	  }
}
