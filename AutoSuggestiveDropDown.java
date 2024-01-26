import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver chromeDriver = new ChromeDriver();

		String url = "https://rahulshettyacademy.com/dropdownsPractise/";
		chromeDriver.get(url);

		/*
		 * This is to get all the elements that match with the word we would like to
		 * select from the auto suggestive input
		 */
		chromeDriver.findElement(By.id("autosuggest")).sendKeys("Costa");

		Thread.sleep(3000);

		/*
		 * Storing all the values from the auto suggestive input in a list to then
		 * iterate through it
		 */
		List<WebElement> options = chromeDriver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("Costa Rica")) {

				option.click();

				break;
			}

		}

	}

}
