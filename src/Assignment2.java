import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		Thread.sleep(1000);
		driver.findElement(By.name("name")).sendKeys("Sweeny");
		//driver.findElement(By.cssSelector(".form-control.ng-pristine.ng-invalid.ng-touched")).sendKeys("Sweeny");
		driver.findElement(By.cssSelector(".form-control.ng-untouched.ng-pristine.ng-invalid")).sendKeys("sweeny@123");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("hPPY@123");
		driver.findElement(By.id("exampleCheck1")).click();
//		driver.findElement(By.cssSelector("id['exampleFormControlSelect1'] option[2])")).click();
		WebElement gender=driver.findElement(By.id("exampleFormControlSelect1"));
		Select Gen=new Select(gender);
		Gen.selectByIndex(1);
		driver.findElement(By.id("inlineRadio1")).click();
		Assert.assertTrue(driver.findElement(By.id("inlineRadio1")).isSelected());
		driver.findElement(By.cssSelector("input[type='date']")).sendKeys("04/08/1995");
		driver.findElement(By.cssSelector("input[value='Submit']")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.cssSelector("div.alert.alert-success.alert-dismissible")).getText());
		
		

	}

}
