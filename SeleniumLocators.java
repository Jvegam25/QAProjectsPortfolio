import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumLocators {
	
	static WebDriver chromeDriver=new ChromeDriver(); 
	
	public static void main(String[] args) throws InterruptedException {
		
		
		
		/*Adds a wait of 5 seconds for Selenium to avoid error NoSuchElementException when an element is not found due to browser's timeout*/
		chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
		SeleniumLocators classInstance= new SeleniumLocators();
		
		String password= classInstance.getPassword(chromeDriver);
		
		
		/*Navigates to the URL defined*/
		chromeDriver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		/*Find an element inside the page by HTML id tag and types the information we defined*/
		chromeDriver.findElement(By.id("inputUsername")).sendKeys("Joshua");
		
		/*Find an element inside the page by HTML name tag and types the information we defined*/
		chromeDriver.findElement(By.name("inputPassword")).sendKeys("holamundo");
		
		/*Find an element inside the page by HTML class tag and clicks(as it is a button) on it. In this example, we had two different words inside the element when we inspected it, which means there are two different classes belonging to the object. We need to choose the most accurate class name on this cases*/
		chromeDriver.findElement(By.className("signInBtn")).click(); 
		
		/*Find an element by CSS selector method and prints it(typing the tag name and the class)*/
		System.out.println(chromeDriver.findElement(By.cssSelector("p.error")).getText());
		
		/*Clicks on an element found by the linked text of the anchor(a)element in HTML. THIS METHOD(link text is intended to be used just with anchor(a)elements)*/
		chromeDriver.findElement(By.linkText("Forgot your password?")).click();
		
		/*Types the information we define finding the element by using xpath method*/
		chromeDriver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Joshua");
		
		/*Finds an element by using CSS selector and types some information there*/
		chromeDriver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("joshua.vm1025@gmail.com");
		
		/*Finds an element using  xpath attribute index method*/
		chromeDriver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		
		/*Finds an element using CSS selector attribute index method*/
		chromeDriver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("joshua.vm1025@gmail.com");
		
		/*Find an element using xpath tag method*/
		chromeDriver.findElement(By.xpath("//form/input[3]")).sendKeys("123");
		
		/*CSS selector*/
		chromeDriver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		
		/*Find an element using CSS selector tag method*/
		System.out.println(chromeDriver.findElement(By.cssSelector("form p")).getText());
		
		/*Find an element by ID using xpath regular expressions with index by accessing the parent object */

		chromeDriver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		
		chromeDriver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");

		
		/*Find an element using CSS selector regular expressions css tag name[type*='four first type characters']= input[type*='pass'] With regular expressions, we look for a matching element for the parameter given after the"*", so it will look for an input with the type pass*/
		chromeDriver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(password);
		
		/*add a thread to synchronize the execution and avoid the error: "element click intercepted: Element <input type="checkbox" id="chkboxOne" name="chkboxOne" value="rmbrUsername"> is not clickable at point (372, 285). Other element would receive the click:"*/
		Thread.sleep(1000);
		
		/*ID*/
		chromeDriver.findElement(By.id("chkboxOne")).click();
		
		/*button[contains(@class,'submit ')] Looks for the element using xpath regular expressions*/
		chromeDriver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		
		
		 //div[contains(@class,'pwd')]
	}
	
	
	/*This method will extract the password from the Forgot password page and paste it on the password input in the login page*/
	public String getPassword(WebDriver driver) throws InterruptedException {
		
		chromeDriver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		/*Clicks on an element found by the linked text of the anchor(a)element in HTML. THIS METHOD(link text is intended to be used just with anchor(a)elements)*/
		chromeDriver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		
		/*CSS selector*/
		chromeDriver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		
		/*Find an element using CSS selector tag method*/
		String passwordText= chromeDriver.findElement(By.cssSelector("form p")).getText();
		
		/*In this part, text: Please use temporary password 'rahulshettyacademy' to Login. is split after the ' storing just rahulshettyacademy*/
		String[]arrayPass=passwordText.split("'");
		
		/*In this part, we are accessing the 0 index of the array we previously created saving the 'rahulshettyacademy'text into the variable password */
		String password=arrayPass[1].split("'")[0];
		
		return password;
	}
}
