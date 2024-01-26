import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class EndToEndTesting {

	public static void main(String[] args) throws InterruptedException {

		WebDriver chromeDriver= new ChromeDriver();

		chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String url="https://rahulshettyacademy.com/dropdownsPractise/";
		
		chromeDriver.get(url);
		
		chromeDriver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

		chromeDriver.findElement(By.xpath("//a[@value='BLR']")).click();

		Thread.sleep(2000);

		/*this is an alternative for using xpath parent to child relationship instead of defining the index as in the above commented code. Basically we give the element inside the dropdown xpath: //a[@value='MAA'], but first, we create a xpath expression for the parent://div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR' */
		chromeDriver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();
		
		chromeDriver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		
		if(chromeDriver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			System.out.println("It is enabled");

			Assert.assertTrue(false);
		
		}else {
			Assert.assertTrue(true);	
		}
		
	/*This element is being recognized by using a regular expression with CSS selector, the actual ID value of the input is ctl1_mainContent_chk_friendsandfamily, but the "*" after the tag name(input), is specifying it will select the element that contains "friendsandfamily" in its ID value*/
		
		chromeDriver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		
		chromeDriver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		
		for(int i=1;i<4;i++){
			
			chromeDriver.findElement(By.id("hrefIncAdt")).click();
		}
		
		chromeDriver.findElement(By.id("btnclosepaxoption")).click();

		Assert.assertEquals(chromeDriver.findElement(By.id("divpaxinfo")).getText(), "4 Adult");
		System.out.println(chromeDriver.findElement(By.id("divpaxinfo")).getText()); 
	
		WebElement staticDropDown= chromeDriver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select dropDown= new Select(staticDropDown);		
		dropDown.selectByIndex(3);
	
		chromeDriver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		
	}	
	
	
}
