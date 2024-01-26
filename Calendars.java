import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendars {

	public static void main(String[] args) throws InterruptedException {

		WebDriver chromeDriver =new ChromeDriver();
		
		String url="https://rahulshettyacademy.com/dropdownsPractise/";

		chromeDriver.get(url); 


		chromeDriver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

		chromeDriver.findElement(By.xpath("//a[@value='BLR']")).click();

		Thread.sleep(2000);

		/*this is an alternative for using xpath parent to child relationship instead of defining the index as in the above commented code. Basically we give the element inside the dropdown xpath: //a[@value='MAA'], but first, we create a xpath expression for the parent://div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR' */
		chromeDriver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();

		
		/*calendar handling*/
		
		/*ui-state-default ui-state-highlight*/
		/*This element has two classes associated with it as we can see. For building the CSS selector of this element, in the spaces between the classes name, we add "." instead*/
		
		chromeDriver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		
		
	}

}
