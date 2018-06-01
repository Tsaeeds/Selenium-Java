package co.presciencerx.selenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrescienceRX {

	WebDriver driver;
	JavascriptExecutor jse;
	
	
	
	
	public void invokeBrowser() {
		
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tahir\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			driver.get("http://qa-presciencerx.azurewebsites.net/Account/Login");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void login() {
		
		driver.findElement(By.id("UserName")).sendKeys("umais20@hotmail.com");
		driver.findElement(By.id("Password")).sendKeys("Password");
		driver.findElement(By.xpath("//*[@id=\"frmLogin\"]/div[5]/input")).click();
		
	}
	
	public void goToCustomersThroughAdmin() {
		
		String url = "http://qa-presciencerx.azurewebsites.net/Admin/Customer";
		
		
		
		if(!url.equals(driver.getCurrentUrl())) {
			
		 driver.findElement(By.cssSelector("a[href='javascript:void(0)']")).click();
		 driver.findElement(By.xpath("/html/body/header/div[1]/ul/li/ul/li[2]/ul/li/div[4]/a/div")).click();
		 
		}
		
	}
	
	public void getCustomers() {
		
		try {
			
			
			
			String url = driver.getCurrentUrl();
			long startTime, stopTime, timeTaken;
			int len = getCustomersLength();
			
			
			for(int i = 1; i<=len; i++) {
			
				driver.findElement(By.xpath("//*[@id=\"tblCustomers\"]/tbody/tr[" + i + "]/td[5]/a")).click();
				
				if (!driver.getCurrentUrl().equals(url)) {
					
					startTime = System.currentTimeMillis();
				
						waitUntilPageAppears();	
					  
						driver.navigate().back();
				
				
				    stopTime = System.currentTimeMillis();
				  
			      timeTaken = stopTime - startTime;
			      System.out.println("Time taken for Customer " + i +": "+ timeTaken + " milliseconds");
			      
			}else {
				
				System.out.println("Customer " + i + " has not been set up yet");
			  }
				
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void close() {
		
		driver.close();
	}
	
	
	
	
	// other methods
	
	private int getCustomersLength() {
		
		jse = (JavascriptExecutor) driver;
		
		return Integer.parseInt(
				jse.executeScript(
						"return document.getElementById(\"tblCustomers\").querySelectorAll(\"tbody\")[0].children.length")
							.toString());
	}
	
	private void waitUntilPageAppears() {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.or(
				ExpectedConditions.visibilityOfElementLocated(By.id("MainReport")),
				ExpectedConditions.visibilityOfElementLocated(By.id("divRPTErrorMessage"))
				));
	}
	
	
	
	
}
