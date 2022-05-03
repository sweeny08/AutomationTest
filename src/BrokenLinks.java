import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class BrokenLinks {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Broken Link/URL : when we click on link and page not found or error occurs,its bsically broken url
		//java methods will call URL's and gets you the status code like 200 for good and 404 for error

		//step1- get all urls tied up to the links using Selenium
		
/*		String url=driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");// driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href")
		HttpURLConnection conn=(HttpURLConnection) new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int respCode=conn.getResponseCode();
		System.out.println(respCode);
		
*/

		List<WebElement> links=driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert a=new SoftAssert();
		for(WebElement link : links)
		{
			String url=link.getAttribute("href");
			HttpURLConnection conn=(HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode=conn.getResponseCode();
			System.out.println(respCode);
			a.assertTrue(respCode<400, "The link with text"+link.getText()+" is broken with code "+respCode);
/*			if (respCode>400)
			{
				System.out.println("The link with text "+link.getText()+" is broken with code "+respCode);
				Assert.assertTrue(false);
			}
	*/		
			
		}
		a.assertAll();
		
		
		
		
	}

}
