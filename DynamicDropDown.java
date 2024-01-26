import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DynamicDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver chromeDriver = new ChromeDriver();

		chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		chromeDriver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		chromeDriver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);

		for (int i = 1; i < 4; i++) {

			chromeDriver.findElement(By.id("hrefIncAdt")).click();
		}
		chromeDriver.findElement(By.id("btnclosepaxoption")).click();

		Assert.assertEquals(chromeDriver.findElement(By.id("divpaxinfo")).getText(), "4 Adult");

		System.out.println("You have selected" + " " + chromeDriver.findElement(By.id("divpaxinfo")).getText() + " "
				+ "people for the trip");

	}

}
