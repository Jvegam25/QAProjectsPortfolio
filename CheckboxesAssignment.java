import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxesAssignment {

	public static void main(String[] args) {

		WebDriver chromeDriver = new ChromeDriver();

		String url = "https://rahulshettyacademy.com/AutomationPractice/";

		chromeDriver.get(url);

		chromeDriver.findElement(By.cssSelector("input[value='option1']")).click();

		chromeDriver.findElement(By.cssSelector("input[value='option1']")).isSelected();

		chromeDriver.findElement(By.cssSelector("input[value='option1']")).click();

		chromeDriver.findElement(By.cssSelector("input[value='option1']")).isSelected();

		System.out.println(chromeDriver.findElements(By.cssSelector("input[type='checkbox']")).size());

	}

}
