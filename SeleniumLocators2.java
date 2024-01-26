import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SeleniumLocators2 {

	static WebDriver chromeDriver = new ChromeDriver();

	public static void main(String[] args) throws InterruptedException {

		/*
		 * Adds a wait of 5 seconds for Selenium to avoid error NoSuchElementException
		 * when an element is not found due to browser's timeout
		 */
		chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String name = "Joshua";

		SeleniumLocators classInstance = new SeleniumLocators();

		String password = classInstance.getPassword(chromeDriver);

		/* Navigates to the URL defined */
		chromeDriver.get("https://rahulshettyacademy.com/locatorspractice/");

		/*
		 * Find an element inside the page by HTML id tag and types the information we
		 * defined
		 */
		chromeDriver.findElement(By.id("inputUsername")).sendKeys(name);

		/*
		 * Find an element inside the page by HTML name tag and types the information we
		 * defined
		 */
		chromeDriver.findElement(By.name("inputPassword")).sendKeys(password);

		/*
		 * Find an element inside the page by HTML class tag and clicks(as it is a
		 * button) on it. In this example, we had two different words inside the element
		 * when we inspected it, which means there are two different classes belonging
		 * to the object. We need to choose the most accurate class name on this cases
		 */
		chromeDriver.findElement(By.className("signInBtn")).click();

		Thread.sleep(2000);

		/*
		 * Find an element and get the text using tag name locator(this is only used
		 * when there is just one tag present in the page where we are testing, as it
		 * will look for the first tag element we define as a parameter)
		 */
		System.out.println(chromeDriver.findElement(By.tagName("p")).getText());

		/*
		 * Compares if p element text's equals the text You are successfully logged in.
		 * if not, an exception will be shown
		 */
		Assert.assertEquals(chromeDriver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");

		/*
		 * Compares if text's from element found by cssSelector equals the text
		 * "Hello"+" "+name+","
		 */
		Assert.assertEquals(chromeDriver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),
				"Hello" + " " + name + ",");

		chromeDriver.findElement(By.xpath("//button[text()='Log Out']")).click();

		chromeDriver.quit();
	}

	/*
	 * This method will extract the password from the Forgot password page and paste
	 * it on the password input in the login page
	 */
	public String getPassword(WebDriver driver) throws InterruptedException {

		chromeDriver.get("https://rahulshettyacademy.com/locatorspractice/");

		/*
		 * Clicks on an element found by the linked text of the anchor(a)element in
		 * HTML. THIS METHOD(link text is intended to be used just with
		 * anchor(a)elements)
		 */
		chromeDriver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);

		/* CSS selector */
		chromeDriver.findElement(By.cssSelector(".reset-pwd-btn")).click();

		/* Find an element using CSS selector tag method */
		String passwordText = chromeDriver.findElement(By.cssSelector("form p")).getText();

		/*
		 * In this part, text: Please use temporary password 'rahulshettyacademy' to
		 * Login. is split after the ' storing just rahulshettyacademy
		 */
		String[] arrayPass = passwordText.split("'");

		/*
		 * In this part, we are accessing the 0 index of the array we previously created
		 * saving the 'rahulshettyacademy'text into the variable password
		 */
		String password = arrayPass[1].split("'")[0];

		return password;
	}
}
