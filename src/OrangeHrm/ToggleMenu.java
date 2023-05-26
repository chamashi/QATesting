package OrangeHrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ToggleMenu {
	
	//Global Declarations
	public String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	String driverPath = "C:\\Users\\Acer\\eclipse-workspace\\SQA23Assignment\\ResourceFiles\\ChromeDriver\\v112.exe";
	public WebDriver driver;
			  
	@BeforeTest
	public void launchBrowserAndLogin() throws InterruptedException
	{
	  System.out.println("launching chrome");
	  System.setProperty("webdriver.chrome.driver", driverPath);
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get(baseUrl);

	  Thread.sleep(3000);
		
	  //Identify web elements-login
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
		
	}
	
	@Test(priority=1)
	public void Toggle() throws InterruptedException
	{
		System.out.println("testing the toggle menu");
		WebElement togglebar = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/div/div/button"));
		togglebar.click();
		Thread.sleep(2000); 
		
		// Validate that the toggle menu is displayed
		
		WebElement toggleMenu = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/div/div/button"));
		Assert.assertTrue(toggleMenu.isDisplayed(), "Toggle menu is not displayed");
	}
	
	@Test(priority=2)
	public void ToggleTimeFeature() throws InterruptedException 
	{
		System.out.println("testing toggle menu's time feature");
		WebElement Time = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[4]/a"));
		Time.click();
		Thread.sleep(2000); 
		
		//Validation
	    String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/time/viewEmployeeTimesheet";
	    String actualUrl = driver.getCurrentUrl();
	    Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	@Test(priority=3)
	public void SelectEmployee() throws InterruptedException 
	{
		System.out.println("testing to select employee");
		WebElement empname = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/form/div[1]/div/div/div/div[2]/div/div/input"));
		empname.sendKeys("Lisa  Andrews");

	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='oxd-autocomplete-dropdown --positon-bottom']//span[text()='Lisa  Andrews']")));
	    option.click();

	    WebElement viewbtn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/form/div[2]/button"));
		Thread.sleep(2000); 
		viewbtn.click();
			
	}
	@Test(priority=4)
	public void CreateTimesheet() throws InterruptedException
	{
		System.out.println("testing to create a time sheet");
		WebElement addTimesheetButton = new WebDriverWait(driver, 10)
	    .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/form/div[3]/div[2]/button")));
		
		addTimesheetButton.click();

	}
	@Test(priority=5)
	public void EditTimesheetBTN() throws InterruptedException
	{
		System.out.println("testing to edit a time sheet Button");
		WebElement editTimesheetButton = new WebDriverWait(driver, 10)
	    .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/form/div[3]/div[2]/button[1]")));
		
		editTimesheetButton.click();
		Thread.sleep(2000); 
	}
	@Test(priority=6)
	public void EditTimesheetFeature() throws InterruptedException//testing the edit timesheet function
	{
		//Add row button
		System.out.println("testing the add row button");
		WebElement addrowbtn = new WebDriverWait(driver, 10)
	    .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/form/div[2]/table/tbody/tr[2]/td/button")));
		Thread.sleep(2000); 
		addrowbtn.click();
		Thread.sleep(2000); 
		
		//Delete button
		System.out.println("testing the delete row button");
		WebElement deleterowbtn = new WebDriverWait(driver, 10)
		.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/form/div[2]/table/tbody/tr[2]/td[10]/button")));
		Thread.sleep(2000); 
		deleterowbtn.click();
		Thread.sleep(2000); 
		
		//Add row button again to test reset button
		System.out.println("testing the add row button again to test reset button");
		WebElement addrowbtnagain = new WebDriverWait(driver, 10)
		.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/form/div[2]/table/tbody/tr[2]/td/button")));
		Thread.sleep(2000); 
		addrowbtnagain.click();
		Thread.sleep(2000);
		
		System.out.println("testing the reset button");
		WebElement resetbtn = new WebDriverWait(driver, 10)
	    .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/form/div[3]/div[2]/button[2]")));
		Thread.sleep(2000); 
		resetbtn.click();
		Thread.sleep(2000); 
	
		// Find the Project field and enter the value
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Type for hints...']")));
		element.sendKeys("Ap");
		
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
	    WebElement option = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='oxd-autocomplete-dropdown --positon-bottom']//span[text()='Apache Software Foundation - ASF - Phase 1']")));
	    option.click();

        // Find the Activity field and enter the value
	    WebElement dropdown = driver.findElement(By.className("oxd-select-wrapper"));

	    // Click on the dropdown to open the options
	    dropdown.click();

	   // Locate the desired option and click on it
	   WebDriverWait wait3 = new WebDriverWait(driver, 10);
	   WebElement option1 = wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='oxd-select-dropdown --positon-bottom']//span[text()='Bug Fixes']")));
	   option1.click();    
	  
	   //adding hours
	   WebElement text = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/form/div[2]/table/tbody/tr[1]/td[3]/div/div[2]/input"));
	   text.sendKeys("4");

	   //saving the details after editing
	   System.out.println("testing the save button after editing");
	   WebElement savebtn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/form/div[3]/div[2]/button[3]"));
	   Thread.sleep(2000); 
	   savebtn.click();
	   Thread.sleep(1000); 
	   
	   //submot button
	   System.out.println("submit timesheet");
		WebElement submitButton = new WebDriverWait(driver, 10)
	    .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/form/div[3]/div[2]/button[2]")));
		submitButton.click();
	}
	
	@Test (priority=7)
	public void ApproveTimesheet() throws InterruptedException 
	{
		WebElement comment = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/form/div[1]/div/div/div/div[2]/textarea"));
		comment.sendKeys("approved");
		
		//approve button
		System.out.println("testing the approve button");
		WebElement approvebtn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/form/div[2]/button[2]"));
		Thread.sleep(2000); 
		approvebtn.click();
		
	}
	
	@AfterTest
	public void terminatebrowser()
	{
		driver.quit();
	}

	
}


