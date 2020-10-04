package samplePackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertDemo_SpiceJet {
	static WebDriver driver;
	String appURL = "https://www.spicejet.com/";
	WebDriverWait d;

	public void lauchApp() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(appURL);

	}

	public void displayAlert() throws Exception {

		WebDriverWait d = new WebDriverWait(driver, 120);
		d.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div#divpaxinfo.paxinfo")));
		Thread.sleep(6000);
		driver.findElement(By.cssSelector("div#divpaxinfo.paxinfo")).click();
		// click on 'infants' dropdown
		Select se = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Infant")));
		Thread.sleep(3000);
		se.selectByIndex(0);
	}

	public void closeAlert() {
		driver.switchTo().alert().accept();
	}

	public void getAlertMessage() {
		String AlertMessage = driver.switchTo().alert().getText();
		System.out.println("Alert message : - " + AlertMessage);
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		AlertDemo_SpiceJet obj = new AlertDemo_SpiceJet();
		obj.lauchApp();
		obj.displayAlert();
		obj.getAlertMessage(); //
		obj.closeAlert();

	}

}
