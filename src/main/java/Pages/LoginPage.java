package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utils.ElementUtil;

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtil util;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//locators
	
	private By emailId= By.xpath("//input[@id='email']");
	private By passwd =By.xpath("//input[@id='pass']");
	private By loginbtn=By.xpath("//button[@name='login']");
	//actions
	
	
	public String verifyTitle() {
		return driver.getTitle();
	}
	
	public HomePage doLogin(String uNm, String pwd) {
		driver.findElement(emailId).sendKeys(uNm);
		driver.findElement(passwd).sendKeys(pwd);
		driver.findElement(loginbtn).click();
		return new HomePage(driver);
	}

}
