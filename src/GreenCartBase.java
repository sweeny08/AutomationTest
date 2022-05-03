import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GreenCartBase {
// Lecture 70,71- go through this
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// expected array
		String[] itemsNeeded = { "Cucumber", "Brocolli", "Pumpkin" };
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(2000);
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		System.out.println(products);
		for (int i = 0; i < products.size(); i++) { // check whether name you extracted is present in array or not
													// convert array into array list for easy search
			// String name=products.get(i).getText(); //it returns Brocolli - 1 kg so you
			// need to split & trim. SPlit returns array so make it array
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();
			System.out.println(formattedName);
			List itemsNeededList = Arrays.asList(itemsNeeded);
			System.out.println(itemsNeededList);
			int j=0;
			if (itemsNeededList.contains(formattedName)) {
				// click add to cart
				//driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==itemsNeeded.length)
				{
					break;
				}
			}

		}
	}

}
