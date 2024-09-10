import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestData {
	protected static WebDriver driver;
	String url="https://magento.softwaretestingboard.com/";
	Random rand=new Random();
	String emails[]= {"AhmadAllan123@gmal.com","Mohammad123@gmail.com","Ali123@gmail.com","Omar123@gmail.com","Dina123@gmail.com"};
	  
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
}
