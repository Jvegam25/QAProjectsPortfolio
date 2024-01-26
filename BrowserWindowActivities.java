import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowActivities {

	public static void main(String[] args) {

		WebDriver chromeDriver = new ChromeDriver();

		/* Maximizes webdriver's window */
		chromeDriver.manage().window().maximize();

		chromeDriver.get("https://google.com/");
		/* This is to navigate to an URL after accessing driver's URL */
		chromeDriver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");

		/* Navigates to the previous page */
		chromeDriver.navigate().back();

		/* navigates to the following page in browser's history */
		chromeDriver.navigate().forward();

	}

}
