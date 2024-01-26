import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class StaticDropDown {

	public static void main(String[] args) throws InterruptedException {

		WebDriver chromeDriver = new ChromeDriver();

		chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		chromeDriver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		WebElement staticDropDown = chromeDriver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		/*
		 * There is a specific method for handling dropdowns with Select class(static
		 * dropdowns)
		 */
		/*
		 * Here we are selecting the USD currency from the Currency dropdown based on
		 * its index
		 */
		Select dropDown = new Select(staticDropDown);
		dropDown.selectByIndex(3);

		/*
		 * getFirstSelectedOption returns The first selected option in this select tag
		 * (or the currently selected option in a normal select)
		 */
		System.out.println(dropDown.getFirstSelectedOption().getText());

		/* Selects the dropdown visible text to match against the paremeter defined */
		dropDown.selectByVisibleText("AED");
		System.out.println(dropDown.getFirstSelectedOption().getText());

		/* Selects the dropdown value to match against the parameter defined */
		dropDown.selectByValue("INR");

	}

}
