import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Checkbox {

	public static void main(String[] args) {

		WebDriver chromeDriver = new ChromeDriver();

		String url = "https://rahulshettyacademy.com/dropdownsPractise/";

		chromeDriver.get(url);

		/*
		 * This element is being recognized by using a regular expression with CSS
		 * selector, the actual ID value of the input is
		 * ctl1_mainContent_chk_friendsandfamily, but the "*" after the tag name(input),
		 * is specifying it will select the element that contains "friendsandfamily" in
		 * its ID value
		 */

		chromeDriver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();

		/* Checks if the checkbox is selected */
		chromeDriver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected();

		Assert.assertTrue(chromeDriver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());

		chromeDriver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		if (chromeDriver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			System.out.println("It is enabled");

			Assert.assertTrue(true);
		} else {

			Assert.assertTrue(false);
		}

		/* Counts the number of checkboxes in the page */
		System.out.println(chromeDriver.findElements(By.cssSelector("input[type='checkbox']")).size());

	}

}
