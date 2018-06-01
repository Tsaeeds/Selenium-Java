//package co.presciencerx.selenium;
//
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class Test {
//	
//	WebDriver driver;
//	JavascriptExecutor jse;
//	
//public void invokeBrowser() {
//		
//		try {
//			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tayyib\\Downloads\\chromedriver_win32\\chromedriver.exe");
//			driver = new ChromeDriver();
//			driver.manage().deleteAllCookies();
//			driver.manage().window().maximize();
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//			
//			driver.get("http://qa-presciencerx.azurewebsites.net/Account/Login");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//public void login() {
//	
//	driver.findElement(By.id("UserName")).sendKeys("umais20@hotmail.com");
//	driver.findElement(By.id("Password")).sendKeys("Welcome@1");
//	driver.findElement(By.xpath("//*[@id=\"frmLogin\"]/div[5]/input")).click();
//	
//}
//
//public void goToCustomersThroughAdmin() {
//	
//	
//	 driver.findElement(By.cssSelector("a[href='javascript:void(0)']")).click();
//	
//	 
//	
//	 
//	
//}
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//Test pre = new Test();
//		
//		pre.invokeBrowser();
//		pre.login();
//		pre.goToCustomersThroughAdmin();
//	}
//
//}
