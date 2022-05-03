import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OptimizedGreenCartBase {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS); //implicit wait :Pros : 1. Code looks readable,just need to be placed once at the top
		//Cons : Performance issues in your web applications will not be noticed
		int j = 0;
		String[] itemsNeeded = { "Cucumber", "Brocolli", "Pumpkin" };
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(2000);
		addItems(driver,itemsNeeded);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
	}

	public static  void addItems(WebDriver driver, String[] itemsNeeded) {
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		System.out.println(products);
		for (int i = 0; i < products.size(); i++) { 
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();
			System.out.println(formattedName);
			List itemsNeededList = Arrays.asList(itemsNeeded);
			System.out.println(itemsNeededList);
			int j = 0;
			if (itemsNeededList.contains(formattedName)) {
				// click add to cart
				// driver.findElements(By.xpath("//button[text()='ADD TO
				// CART']")).get(i).click();
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == itemsNeeded.length) {
					break;
				}
			}

		}
	}
}
