import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaAlert {

	public static void main(String[] args) {
		WebDriver chromeDriver = new ChromeDriver();

		String URL = "https://rahulshettyacademy.com/AutomationPractice/";

		chromeDriver.get(URL);

		String text = "Joshua";

		chromeDriver.findElement(By.id("name")).sendKeys(text);

		chromeDriver.findElement(By.xpath("//input[@id='alertbtn']")).click();

		System.out.println(chromeDriver.switchTo().alert().getText());

		/* This code is for handling Java alerts which contain just an OK option */
		chromeDriver.switchTo().alert().accept();

		chromeDriver.findElement(By.id("confirmbtn")).click();

		System.out.println(chromeDriver.switchTo().alert().getText());

		chromeDriver.switchTo().alert().dismiss();

	}

}
