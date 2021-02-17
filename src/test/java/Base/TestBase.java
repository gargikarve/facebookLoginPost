package Base;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Driverfactory.DriverFactory;
import Pages.HomePage;
import Pages.LoginPage;

public class TestBase {
	public DriverFactory df;
	public Properties prop;
	public WebDriver driver;
	public LoginPage loginPg;
	public HomePage homePg;

	@BeforeTest
	public void setUp() {
		df = new DriverFactory();
		prop = df.read_Properties();
		String bname = prop.getProperty("browser");
		driver = df.launch_Browser(bname);
		driver.get(prop.getProperty("url"));
		loginPg = new LoginPage(driver);
	}

	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@aria-label='Account']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Log Out')]")).click();
		driver.quit();
	}
}
