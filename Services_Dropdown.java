package functionaltesting;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Services_Dropdown {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.hashtag-ca.com/careers/apply?jobCode=QAE001");
		
		WebElement services=driver.findElement(By.xpath("//li[@class='nav-item services']/a"));
		Actions action=new Actions(driver);
	
		action.moveToElement(services).build().perform();
		List<WebElement> listdrp = driver.findElements(By.xpath("//div[@class='col-md-6 p-0']/li"));

		for (int x = 0; x < listdrp.size(); x++) {
			String text = listdrp.get(x).getText();

			System.out.println(text);
			
			listdrp.get(x).click();

			
		}
		
		
	}

}
