package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.ElementUtil;

public class HomePage {

	private static WebDriver driver;
	private ElementUtil util;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// locators
	private By homeIcon = By.xpath("//a[@aria-label='Home']");
	private By addPostTab = By.xpath("//div[@class='m9osqain a5q79mjw jm1wdb64 k4urcfbm']");
	private By postTxt = By.xpath("//form[@method='POST']//div[@class='_1mf _1mj']");
	private By postBtn = By.xpath("//div[@aria-label='Post']");
	private By actualPostText = By.xpath("//div[@class='kvgmc6g5 cxmmr5t8 oygrvhab hcukyx3x c1et5uql']");

	// actions

	public String verifyTitle() throws InterruptedException {
		Thread.sleep(4000);
		return driver.getTitle();
	}

	public void doPost(String PostText) {

		waitForElementPresent(homeIcon, 5).click();
		waitForElementPresent(addPostTab, 5).click();
		waitForElementPresent(postTxt, 6).sendKeys(PostText);
		waitForElementPresent(postBtn, 4).click();

	}

	public String getPostText() throws InterruptedException {
		// Thread.sleep(6000);
		// driver.navigate().refresh();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String actualText = driver.findElement(actualPostText).getText();
		return actualText;
	}

	public static WebElement waitForElementPresent(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

}
