import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators3 {

	 
	
	
	public static void main(String[] args) {
	
		 WebDriver chromeDriver=new ChromeDriver();
		 
		 chromeDriver.get("https://rahulshettyacademy.com/AutomationPractice/");
		 
		 /*Find the log-in button using xpath sibling/parent to child  method*/
		 System.out.println(chromeDriver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		 
		 /*Find the log-in button using xpath child to parent method*/
		 System.out.println(chromeDriver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());
		
		 
		 

	}

}
