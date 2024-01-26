import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DynamicDropDown3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver =new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/"); //URL in the browser

		//  //a[@value='MAA']  - Xpath for chennai

		//  //a[@value='BLR']

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

		driver.findElement(By.xpath("//a[@value='BLR']")).click();

		Thread.sleep(2000);

		//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

		/*this is an alternative for using xpath parent to child relationship instead of defining the index as in the above commented code. Basically we give the element inside the dropdown xpath: //a[@value='MAA'], but first, we create a xpath expression for the parent://div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR' */
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();

	}

}
