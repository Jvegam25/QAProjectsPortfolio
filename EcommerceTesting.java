import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EcommerceTesting {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver chromeDriver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));

		/*
		 * Implicit wait is added to the entire code, so it will take the amount of
		 * minutes defined in the parameter to jump between the different steps
		 */

		// chromeDriver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

		String URL = "https://rahulshettyacademy.com/seleniumPractise/#/";

		chromeDriver.get(URL);

		String[] itemsNeeded = { "Cucumber", "Beetroot" };

		Thread.sleep(3000);

		addItems(chromeDriver, itemsNeeded);
		chromeDriver.findElement(By.cssSelector("img[alt='Cart']")).click();

		/* Here we are handling the object by its text as it is not dynamic */

		chromeDriver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		/*
		 * Explicit wait defines a wait just for the specific step where we need to wait
		 * for the element to be visible
		 */
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));

		chromeDriver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		chromeDriver.findElement(By.cssSelector("button.promoBtn")).click();

		chromeDriver.findElement(By.cssSelector("span.promoInfo")).getText();

		// Assert.assertEquals(chromeDriver.findElement(By.cssSelector("span.promoInfo")).getText(),
		// "Code applied ..!");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));

		System.out.println(chromeDriver.findElement(By.cssSelector("span.promoInfo")).getText());

	}

	public static void addItems(WebDriver chromeDriver, String[] itemsNeeded) {

		int j = 0;

		/*
		 * Get all the elements from the page(as there is not any unique attribute to
		 * recognize the objects) and stores it in a variable of WebElement type
		 */
		List<WebElement> products = chromeDriver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {

			/*
			 * Get the products name while iterating the loop and add them to the array
			 * "productName", splitting the content when it gets a hyphen "-" in the array,
			 * as the values would be: "Cucumber - 1 Kg".
			 */

			String[] productName = products.get(i).getText().split("-");

			/*
			 * trims the content to be just "Cucumber", instead of "Cucumber - 1 Kg"
			 */

			String formattedProductName = productName[0].trim();
			/*
			 * Cast the array of strings which contains "Cucumber and Beetroot", to an
			 * Arraylist to have a most accurate way of looking for the required values and
			 * then clicking the button to add the products to the cart
			 */
			List itemsNeededList = Arrays.asList(itemsNeeded);

			/*
			 * In this case instead of using equalsIgnoreCase, we use "contains" as it works
			 * as a regular expression so will compare the value of any product with the
			 * word cucumber
			 */
			if (itemsNeededList.contains(formattedProductName)) {

				j++;
				/* Click on the element whose name contains cucumber */
				chromeDriver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == itemsNeeded.length) {

					break;

				}
			}

		}

	}

}
