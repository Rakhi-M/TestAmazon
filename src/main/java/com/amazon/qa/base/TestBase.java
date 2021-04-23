package com.amazon.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.amazon.qa.util.TestUtil;


public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream("C:\\Users\\Rakhi\\eclipse-workspace\\amazontest\\src\\main\\java\\"+""
					+ "com\\amazon\\qa\\config\\config.properties");
			prop.load(ip);
			
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initialize() {
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Data\\rakhi\\softwares\\chromedriver\\chromedriver.exe");
	        driver=new ChromeDriver();
		}
		else if(browserName.equals("chrome")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Data\\rakhi\\softwares\\geckodriver-v0.29.0-win32\\geckodriver.exe");
	        driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
        
        driver.get(prop.getProperty("url"));
	}
	
	

}
