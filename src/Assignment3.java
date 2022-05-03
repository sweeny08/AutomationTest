import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		WebDriverWait w=new WebDriverWait(driver,5);
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
		driver.findElement(By.id("okayBtn")).click();
//		Thread.sleep(1000);
//		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
		WebElement staticdropdown=driver.findElement(By.cssSelector("select.form-control"));
		Select dropdown=new Select(staticdropdown);
		dropdown.selectByVisibleText("Consultant");
		driver.findElement(By.xpath("//input[@id='terms']")).click();
		driver.findElement(By.id("signInBtn")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Checkout")));
		List <WebElement> products=driver.findElements(By.cssSelector("button[class='btn btn-info']"));
		for(int i=0;i<products.size();i++)
		{
			products.get(i).click();
		}
	    driver.findElement(By.partialLinkText("Checkout")).click();
		
		
	}

}
