import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.com/");
		Actions a=new Actions(driver);
		//to maximize the screen
		driver.manage().window().maximize();
		//moves to specific element
//		a.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform(); //build means it is ready to execute. And by writing perform it will execute.
		//or can write
		WebElement move=driver.findElement(By.id("nav-link-accountList"));
		a.moveToElement(move).build().perform();
		//right click on specific methods
		a.moveToElement(move).contextClick().build().perform();
		//write in caps using shift button
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		//to select the entire text by double click
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
	}

}
