import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

public class Miscelleanous {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize(); //to open maximized window
		driver.manage().deleteAllCookies(); // to delete all the cookies that are generated while your automation program is being run
		driver.get("https://google.com");
		//to check the scenario where you want to delete the session cookie and make sure secure login gets logout
		//delete the particular cookie namelike "sessionKey"
		driver.manage().deleteCookieNamed("sessionKey");
		
		//to take a screenshot
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("C://screenshot.png"));
		

	}

}
