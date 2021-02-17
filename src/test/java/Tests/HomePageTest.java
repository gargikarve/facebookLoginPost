package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.TestBase;

public class HomePageTest extends TestBase {
	@BeforeClass
	public void setupHomePage() {
		homePg= loginPg.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyTitle() throws InterruptedException {
	String ttl=	homePg.verifyTitle();
	Assert.assertEquals(ttl, "Facebook");
	}

	@Test(priority = 2)
	public void doPostTest()  {
		homePg.doPost("Test Post");
	}
	

	@Test(priority = 3)
	public void verifyPostText() throws InterruptedException  {
		String posttxt=homePg.getPostText();
		Assert.assertEquals(posttxt, "Test Post");
	}

}
