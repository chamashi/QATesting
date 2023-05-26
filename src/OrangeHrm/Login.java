package OrangeHrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login {
	//Global Declarations
	public String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	String driverPath = "C:\\Users\\Acer\\eclipse-workspace\\SQA23Assignment\\ResourceFiles\\ChromeDriver\\v112.exe";
	public WebDriver driver;
		  
	@BeforeTest
	public void launchBrowser()
	{
	  System.out.println("launching chrome");
	  System.setProperty("webdriver.chrome.driver", driverPath);
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get(baseUrl);
	}
		
	@Test(priority=1)
	public void InvalidLoginOne() throws InterruptedException
	{
		Thread.sleep(3000);
				
		//Identify web elements-user login without entering credintials
		System.out.println("testing if user can login without entering credintials");
		WebElement loginbtn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
		loginbtn.click();
		Thread.sleep(2000);
		WebElement error = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span"));
		Assert.assertEquals(error.getText(), "Required");
		driver.navigate().refresh();		
	}
	
	@Test(priority=2) // testing with valid username and invalid password
	public void InvalidLoginTwo() throws InterruptedException
	{
		Thread.sleep(3000);
		
		//Identify web elements
		System.out.println("testing if user can login with correct username and invalid password");
		WebElement usernametxt = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
		usernametxt.sendKeys("Admin");
		
		Thread.sleep(3000);
		
		WebElement passwordtxt = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
		passwordtxt.sendKeys("admin5");
		Thread.sleep(3000);
		
		WebElement loginbtn1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
		loginbtn1.click();
		Thread.sleep(2000);
		
		//Validate the error message displayed
		WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p"));
	    Assert.assertEquals(errorMsg.getText(), "Invalid credentials");
		driver.navigate().refresh();		
	}
	
	@Test(priority=3) // testing with invalid username and valid password
	public void InvalidLoginThree() throws InterruptedException
	{
		Thread.sleep(3000);
		
		//Identify web elements
		System.out.println("testing if user can login with incorrect username and valid password");
		WebElement usernametxt = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
		usernametxt.sendKeys("Adminstrator");
		
		Thread.sleep(3000);
		
		WebElement passwordtxt = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
		passwordtxt.sendKeys("admin123");
		Thread.sleep(3000);
		
		WebElement loginbtn1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
		loginbtn1.click();
		Thread.sleep(2000);
		
		WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p"));
	    Assert.assertEquals(errorMsg.getText(), "Invalid credentials");
		driver.navigate().refresh();		
	}
	
	@Test(priority=4) // testing with invalid username and password
	public void InvalidLoginFour() throws InterruptedException
	{
		Thread.sleep(3000);
		
		//Identify web elements
		System.out.println("testing if user can login with incorrect username and incorrect password");
		WebElement usernametxt = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
		usernametxt.sendKeys("Adminstrator");
		
		Thread.sleep(3000);
		
		WebElement passwordtxt = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
		passwordtxt.sendKeys("adminstrator1");
		Thread.sleep(3000);
		
		WebElement loginbtn1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
		loginbtn1.click();
		Thread.sleep(2000);
		
		WebElement error = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p"));
	    Assert.assertEquals(error.getText(), "Invalid credentials");
		driver.navigate().refresh();		
	}
	
	@Test(priority=5) // testing with valid username and password
	public void ValidLogin() throws InterruptedException
	{
		Thread.sleep(3000);
		
		//Identify web elements
		System.out.println("testing if user can login with correct username and correct password");
		WebElement usernametxt = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
		usernametxt.sendKeys("Admin");
		
		Thread.sleep(3000);
		
		WebElement passwordtxt = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
		passwordtxt.sendKeys("admin123");
		Thread.sleep(3000);
		
		WebElement loginbtn1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
		loginbtn1.click();
		Thread.sleep(2000);
		
		//Validation
	    String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	    String actualUrl = driver.getCurrentUrl();
	    Assert.assertEquals(actualUrl, expectedUrl);

	}
		
	@AfterTest
	public void terminatebrowser()
	{
		driver.quit();
	}
}
