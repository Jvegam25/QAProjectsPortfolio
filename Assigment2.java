import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.Assertion;

public class Assigment2 {

	public static void main(String[] args) {
		WebDriver chromeDriver = new ChromeDriver();

		chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String url = "https://rahulshettyacademy.com/angularpractice/";
		chromeDriver.get(url);
		chromeDriver.findElement(By.xpath("//input[@name='name']")).sendKeys("Joshua");
		chromeDriver.findElement(By.xpath("//input[@name='email']")).sendKeys("Joshua.vm");
		chromeDriver.findElement(By.id("exampleInputPassword1")).sendKeys("123");
		chromeDriver.findElement(By.id("exampleCheck1")).click();
		Assert.assertTrue(chromeDriver.findElement(By.id("exampleCheck1")).isSelected());

		WebElement staticDropDown = chromeDriver.findElement(By.id("exampleFormControlSelect1"));

		Select dropdown = new Select(staticDropDown);

		dropdown.selectByIndex(0);

		chromeDriver.findElement(By.xpath("//input[@id='inlineRadio1']")).click();

		chromeDriver.findElement(By.xpath("//input[@id='inlineRadio1']")).isSelected();
		Assert.assertTrue(chromeDriver.findElement(By.xpath("//input[@id='inlineRadio1']")).isSelected());

		chromeDriver.findElement(By.xpath("//input[@type='date']")).sendKeys("05252000");

		chromeDriver.findElement(By.cssSelector(".btn.btn-success")).click();

		System.out.println(chromeDriver.findElement(By.cssSelector(".alert-success")).getText());

	}

}
