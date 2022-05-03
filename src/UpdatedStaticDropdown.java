import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//testNG is a testing framework

public class UpdatedStaticDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");		
		System.out.println(driver.findElement(By.cssSelector("div[id*='SeniorCitizenDiv']")).isSelected());
//		driver.findElement(By.cssSelector("div[id*='SeniorCitizenDiv']")).click(); // checkbox selection
//		if (driver.findElement(By.cssSelector("div[id*='SeniorCitizenDiv']")).isSelected());
//		{
//			System.out.println("Checked");
	//	}
		
		Assert.assertFalse(driver.findElement(By.cssSelector("div[id*='SeniorCitizenDiv']")).isSelected()); //expects false inside condition else it fails
		driver.findElement(By.cssSelector("div[id*='SeniorCitizenDiv']")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected()); // expects true inside condition else it fails
		
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		//RoundTrip
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
		{
			System.out.println("it is enabled");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		//date
		System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
		
		
		//find count of check boxes
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
/*		int i=1;
		while(i<5)   //4 times
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}*/
		for(int i=1;i<5;i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		
		driver.findElement(By.id("divpaxOptions")).click();
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"5 Adult"); // test pass if both the values are same
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		
		
		
		
		
	}

}
