import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
public class LoginTestCase extends TestData {
LoginPage login= new LoginPage();
@BeforeTest
public void setUp() {
	defualtConfiguration();
}
	
@Test(priority=1)
public void openLoginPage() {
	login.openaLoginPageTest();
}
@Test(priority=2)
public void checkLogo() {
	login.checkLogoTest();
}
@Test(priority=3)
public void checkLogin() {
  login.checkLoginTest();

}
@Test(priority=4)
public void checkLogoLogin() {
	checkLogo();
}
}
