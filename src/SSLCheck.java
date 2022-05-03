import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options=new ChromeOptions();
		Proxy proxy=new Proxy();
		proxy.setHttpProxy("ipaddress:4444");
		options.setAcceptInsecureCerts(true);
//		options.addEncodedExtensions("C:\\Users\\Administrator\\Downloads\\chphlpgkkbolifaimnlloiipkdnihall-1.57-Crx4Chrome.com.crx"); //to set extensions in chrome
		options.setCapability("proxy", proxy);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());		
		
		
		
		//to block popups use
		ChromeOptions options1=new ChromeOptions();
		options1.setExperimentalOption("excludeSeitches", Arrays.asList("disable-popup-blocking"));
		driver.get("https://expired.badssl.com/");
		
		//to change download directory
		Map<String,Object> prefs= new HashMap<String,Object>();
		prefs.put("download.default_directory","/directory/path");
		options.setExperimentalOption("prefs", prefs);
		
		
		
		

	}

}
