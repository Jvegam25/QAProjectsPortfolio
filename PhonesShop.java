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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PhonesShop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver chromeDriver = new ChromeDriver();

		String url = "https://rahulshettyacademy.com/loginpagePractise/";

		WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));

		String[] phonesNeeded = { "iphone", "Samsung", "Nokia", "Blackberry" };

		chromeDriver.get(url);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));

		chromeDriver.findElement(By.id("username")).sendKeys("rahulshettyacademy");

		chromeDriver.findElement(By.cssSelector("input[id='password']")).sendKeys("learning");

		chromeDriver.findElement(By.cssSelector("input[value='user']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));

		chromeDriver.findElement(By.id("okayBtn")).click();

		chromeDriver.findElement(By.xpath("//input[@id='terms']")).click();

		chromeDriver.findElement(By.xpath("//input[@id='terms']")).isSelected();
		Assert.assertTrue(chromeDriver.findElement(By.xpath("//input[@id='terms']")).isSelected());

		WebElement staticDropdown = chromeDriver.findElement(By.xpath("//select[@class='form-control'] "));

		Select dropDown = new Select(staticDropdown);

		dropDown.selectByIndex(2);

		chromeDriver.findElement(By.cssSelector("input[class='btn btn-info btn-md']")).click();

		Thread.sleep(3000);

		addItems(chromeDriver, phonesNeeded, wait);

		chromeDriver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).click();



	}

	public static void addItems(WebDriver chromeDriver, String[] phonesNeeded, WebDriverWait wait) {

		int j = 0;

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h4.card-title")));

		List<WebElement> products = chromeDriver.findElements(By.cssSelector("h4.card-title"));

		for (int i = 0; i < products.size(); i++) {

			String[] productName = products.get(i).getText().split(" ");

			String formattedProductName = productName[0].trim();

			List itemsNeededList = Arrays.asList(phonesNeeded);

			if (itemsNeededList.contains(formattedProductName)) {

				chromeDriver.findElements(By.xpath("//div[@class='card-footer']/button")).get(i).click();

				j++;
				if (j == phonesNeeded.length) {

					break;
				}
			}

		}

	}

}
