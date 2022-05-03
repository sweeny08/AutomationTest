import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com");
		driver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]")).click(); // or driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click(); //or driver.findElement(By.cssSelector("a[href*='windows']")).click();
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		String parentId=it.next();
		String childId=it.next();
		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText()); //or System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
		driver.switchTo().window(parentId);
		System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'Opening a new window')]")).getText()); //or System.out.println(driver.findElement(By.xpath("//div[@id='content']/div/h3")).getText())
		
		

	}

}
