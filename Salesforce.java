package StepDefintions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver.Timeouts;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Salesforce {

	
	public void Goto_ServiceApp()
	{
		System.setProperty("webdriver.chrome.driver", "<Chromedriverpath>");
		WebDriver driver=new ChromeDriver();
		driver.get("https://login.salesforce.com/");//URL
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("username")).sendKeys("harsh.chaturvedi@wise-raccoon-vgnfqt.com");
		driver.findElement(By.id("password")).sendKeys("Seer@123");
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		if(driver.findElement(By.xpath("//*[@class='slds-icon-waffle']")).isDisplayed())
		{
			driver.findElement(By.xpath("//*[@class='slds-icon-waffle']")).click();
			if(driver.findElement(By.id("input-81")).isDisplayed())
			{
				driver.findElement(By.id("input-81")).sendKeys("Service");
				driver.findElement(By.xpath("//*[@src='https://wise-raccoon-vgnfqt-dev-ed.my.salesforce.com/logos/Salesforce/ServiceCloud/logo.png']")).click();
				//App search is Visible
				if (driver.findElement(By.xpath("//*[@title='service']")).isDisplayed())
				{			
					logger.log(LogStatus.PASS, " Logged in and navigated to Service App"); 
				}
			}
			else
			{
				logger.log(LogStatus.FAIL, "unable to navgate to Service App"); 
				//App search is not visible
			}
		}
		else
		{			
			test.log(LogStatus.FAIL, "App Launcher is not present"); 
		}		
		
	}
	
		
	public void ClickonDropdown(String PageName)////*[@title='Accounts']
	
	{
		System.setProperty("webdriver.chrome.driver", "<Chromedriverpath>");
		WebDriver driver=new ChromeDriver();
		driver.findElement(By.xpath("//*[@title='"+PageName+"']")).click();
		
		if(driver.findElement(By.xpath("//*[@class='slds-var-p-right_x-small']")).isDisplayed())
		
		{
			logger.log(LogStatus.PASS, " navigated to "+PageName); 
		}
		
		else
			
		{
			logger.log(LogStatus.FAIL, " unable to navigate to "+PageName); 
		}
			
	}
	
	
	public void NewAccount()
	{
		System.setProperty("webdriver.chrome.driver", "<Chromedriverpath>");
		WebDriver driver=new ChromeDriver();
		driver.findElement(By.xpath("//*[@title='New' and @role='button']")).click();
		if(driver.findElement(By.xpath("//*[@name='CancelEdit']")).isDisplayed())
		{
			//Navigated to Create Account Page
			driver.findElement(By.xpath("//*[@name='firstName']")).sendKeys("Test_123");
			driver.findElement(By.xpath("//*[@name='SaveEdit']")).click();
			//Implicitly wait			
			
			if(driver.findElement(By.xpath("//*[@class='custom-truncate']")).isDisplayed())
			{
				logger.log(LogStatus.PASS, "Account is created"); 
			}
			
			else
				
			{
				logger.log(LogStatus.FAIL, "Account is not created"); 
			}
		}
		else
		{
			
		}
	}
	
	public void NewContact()
	
	{
		System.setProperty("webdriver.chrome.driver", "<Chromedriverpath>");
		WebDriver driver=new ChromeDriver();
		driver.findElement(By.xpath("//*[@title='New' and @role='button']")).click();
		
		if (driver.findElement(By.xpath("//*[@name='CancelEdit']")).isDisplayed())
		{
			//Navigated to new contact Page and create New contact
			Select obj=new Select(driver.findElement(By.name("salutation")));
			obj.selectByValue("Mr.");
			driver.findElement(By.name("firstName")).sendKeys("TestFirst");
			driver.findElement(By.name("lastName")).sendKeys("TestLast");
			driver.findElement(By.xpath("//*[@name='SaveEdit']")).click();
			
			//Implicitly wait			
			if (driver.findElement(By.xpath("//*[@class='custom-truncate uiOutputText']")).isDisplayed())
			{
				logger.log(LogStatus.PASS, "Contact is created"); 
			}
			
			else
				
			{
				logger.log(LogStatus.FAIL, "Contact is not created"); 
			}
		}
		else
		{
			
		}
	}	
	public void NewCase()
		
		{
		System.setProperty("webdriver.chrome.driver", "<Chromedriverpath>");
		WebDriver driver=new ChromeDriver();
			driver.findElement(By.xpath("//*[@title='New' and @role='button']")).click();
			
			if (driver.findElement(By.xpath("//*[@name='CancelEdit']")).isDisplayed())
			{
				//Navigated to new contact Page and create New contact
				Select obj=new Select(driver.findElement(By.xpath("//*[@id='221:6460;a']/div/a")));
				obj.selectByValue("Email");
				driver.findElement(By.xpath("//*[@title='Search Contacts']")).click();
				Select obj2=new Select(driver.findElement(By.xpath("//*[@role='option']")));
				obj2.selectByIndex(0);
				driver.findElement(By.xpath("//*[@title='Search Accounts']")).click();
				Select obj3=new Select(driver.findElement(By.xpath("//*[@role='option']")));
				obj3.selectByIndex(0);
				driver.findElement(By.xpath("//*[@title='Save']")).click();				
				//Implicitly wait			
				
				if (driver.findElement(By.xpath("//*[@class='custom-truncate uiOutputText']")).isDisplayed())
				{
					logger.log(LogStatus.PASS, "Case is created"); 
				}
				
				else
					
				{
					logger.log(LogStatus.FAIL, "Case is not created"); 
				}
			}
			else
			{
				
			}
		
		
		
		
		
	}
	public void changeowner()
	{
		System.setProperty("webdriver.chrome.driver", "<Chromedriverpath>");
		WebDriver driver=new ChromeDriver();
		driver.findElement(By.xpath("//div[@title='Change Owner']")).click();
		////*[@class='entityMenu slds-p-left--xxx-small uiMenu']
		driver.findElement(By.xpath("//*[@class='entityMenu slds-p-left--xxx-small uiMenu']")).click();
		////*[@title='Queues']'
		driver.findElement(By.xpath("//*[@title='Queues']")).click();
		////*[@class='default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input uiInput uiAutocomplete uiInput--default uiInput--lookup']
		driver.findElement(By.xpath("//*[@class='default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input uiInput uiAutocomplete uiInput--default uiInput--lookup']")).click();
		/////*[@title='Dummy Queue' and @class='primaryLabel slds-truncate slds-lookup__result-text']
		driver.findElement(By.xpath("//*[@title='Dummy Queue' and @class='primaryLabel slds-truncate slds-lookup__result-text']")).click();
		//Submit
		driver.findElement(By.xpath("//*[@title='Submit']")).click();
		String str=driver.findElement(By.xpath("//*[@id=\"sectionContent-232\"]/div/slot/records-record-layout-row[1]/slot/records-record-layout-item[1]/div/div/div[2]/span/slot[1]/force-owner-lookup/div/span/force-lookup/div/span/slot/text()")).getText()
				if (str.contains("Dummy Queue"))
				{
					logger.log(LogStatus.PASS, "Owner Changed"); 
				}
				
				else
					
				{
					logger.log(LogStatus.FAIL, "Owner Not Changed"); 
				}
					
					
	}
	
			
	public static void main(String[] args) {
		
		Salesforce objsf=new Salesforce();
		objsf.Goto_ServiceApp();
		objsf.ClickonDropdown("Accounts");
		objsf.NewAccount();
		objsf.ClickonDropdown("Contacts");
		objsf.NewContact();
		objsf.ClickonDropdown("Cases");
		objsf.NewCase();
		objsf.ClickonDropdown("Cases");
		objsf.changeowner();
	}

}
