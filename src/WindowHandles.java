import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandles {
	public static void main(String[] args) throws InterruptedException 
	{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/loginpagePractise/");
	driver.findElement(By.cssSelector(".blinkingText")).click();
	//to get the id's of the window tabs opened by selenium
	Set <String> windows=driver.getWindowHandles();  //[parentid,childid,subchildId]
	Iterator<String> it = windows.iterator(); // it sets a iterator at the values
	String parentId=it.next(); //with next you can set the value of iterator to the 1st element
	String childId= it.next(); // gets the child id for opened wimdows
	driver.switchTo().window(childId); 
	//learn more on video87


	
	
	}	
}
