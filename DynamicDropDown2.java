import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicDropDown2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver chromeDriver= new ChromeDriver();		
		
		String webURL="https://rahulshettyacademy.com/dropdownsPractise/";
		
		chromeDriver.get(webURL);
		
		chromeDriver.manage().window().maximize();
		
		WebElement fromDropDown=chromeDriver.findElement(By.id("select2-qvd7-container"));
		
		WebDriverWait wait= new WebDriverWait(chromeDriver, Duration.ofSeconds(5));
		
		((JavascriptExecutor) chromeDriver).executeScript("arguments[0].scrollIntoView(true);", fromDropDown);
			
		fromDropDown.click();
		
		int attempts =0;
		
	while(attempts<3) {
			
			try{
				wait.until(ExpectedConditions.visibilityOf(fromDropDown));

				fromDropDown.click();
				
			}catch(ElementNotInteractableException e) {
				
				Thread.sleep(2000);
				
			} 
			attempts++;
		}
		
		
		/*if(chromeDriver.findElement(By.id("ctl00_mainContent_ddl_originStation1")).isEnabled()) {
			chromeDriver.findElement(By.id("ctl00_mainContent_ddl_originStation1")).click();	
		}else {
			
			System.out.println("Object is not visible");
		}*/
		
		/*With this code we will first get the value from the Departure City dropdown*/
		chromeDriver.findElement(By.xpath("//a[@value='BLR']")).click();
		
		Thread.sleep(2000);
		
		/*With this code we will get the value from the Arrival City dropdown, 2 index(//a[@value='MAA'][2]) specifies that we will be getting the value from the second dropdown*/
		chromeDriver.findElement(By.xpath("//a[@value='MAA'][2]")).click();
	}

}
