package Driverfactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import okio.Options;

public class DriverFactory {

	
	public Properties prop;
	public ThreadLocal<WebDriver> tldriver= new ThreadLocal<WebDriver>();
	
	public WebDriver launch_Browser(String browserName) {
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			tldriver.set(new ChromeDriver(options));
			
		}
		else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver());
		}
		
		else {
			System.out.println("Please pass correct browser value"+browserName);
		}
		get_Driver().manage().deleteAllCookies();
		get_Driver().manage().window().maximize();
		//get_Driver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return get_Driver();
		
	}
	
	public WebDriver get_Driver() {
		return tldriver.get();
	}
	
	
	public Properties read_Properties() {
		prop= new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream("D:\\EclipseWorkspace\\FacebookLoginPost\\src\\test\\resources\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
		
		
	}
}
