import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumCertification {

	public static void main(String[] args) {

		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\Joshua\\Downloads\\chromedriver-win64\\chromedriver-win64");
//
		/* Define the webDriver object */ WebDriver chromeDriver = new ChromeDriver();
		/*
		 * /*Navigate to a URL
		 */ chromeDriver.get("https://www.youtube.com/");

		/* Print the title of the URL */ System.out.println(chromeDriver.getTitle());
		/* Prints the current URL */ System.out.println(chromeDriver.getCurrentUrl());
		/* Closes the current window */ chromeDriver.close();
		/* Closes all the associated windows opened by Selenium */ chromeDriver.quit();

		/* Edge browser testing */

		/*
		 * WebDriver edgeDriver= new EdgeDriver();
		 * 
		 * edgeDriver.get("https://www.google.com");
		 * System.out.println(edgeDriver.getTitle()); edgeDriver.quit();
		 */

	}

}
