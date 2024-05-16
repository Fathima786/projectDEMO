package pagepkg;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Projectpage {
	
	static WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"user-name\"]")
	WebElement email;
	
	@FindBy(xpath="//*[@id=\"password\"]")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"login-button\"]")
	WebElement button;
	
	public Projectpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setvalues(String em,String pw)
	{
		System.out.println("EMAIL = "+em);
		System.out.println("PASSWORD = "+pw);
		email.clear();
		email.sendKeys(em);
		password.clear();
		password.sendKeys(pw);
	}
	
	public void click() throws InterruptedException
	{
		button.click();
		Thread.sleep(5000);
	}
	
	public String checkvalid()
	{
		String currenturl=driver.getCurrentUrl();
		String s;
		if(currenturl.equals("https://www.saucedemo.com/inventory.html"))
		{
			s="VALID CREDENTIALS";
			
		}
		else
		{
			s="INVALID CREDENTIALS";
			
		}
		
		return s;
	}
	
	
	
	public void addtocart() throws InterruptedException
	{
		List <WebElement> items=driver.findElements(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div/div[2]/div[2]/button"));
		
		for(WebElement ele:items)
		{
			String text=ele.getText();
			
			if(text.equals("Add to cart"))
			{
				ele.click();
			}
			
		}
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0,0)", "");
		driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
		
		
		jse.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
	}
	
	public void fillinfo() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("FATHIMA");
		driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("MUHAMMAD");
		driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("690528");
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"finish\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();
		
		
	}
	
	

}


