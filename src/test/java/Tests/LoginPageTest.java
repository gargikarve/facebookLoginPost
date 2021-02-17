package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.TestBase;

public class LoginPageTest extends TestBase {


	@Test(priority = 1)
	public void doLogin() {
		loginPg.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}


	@Test(priority = 2)
	public void verifyTitle() {
		String ttl=loginPg.verifyTitle();
		Assert.assertEquals(ttl, "Facebook");
	}
}
