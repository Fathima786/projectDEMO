package basepkg;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class Setup {
	
	public static WebDriver driver;
	
	@BeforeTest
	public void beforetest()
	{
		driver=new FirefoxDriver();
		String baseurl="https://www.saucedemo.com";
		driver.get(baseurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

}
