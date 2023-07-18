package functionaltesting;

	import java.time.Duration;
	import java.util.Iterator;
	import java.util.Set;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;


	public class Page {
		public WebDriver driver;
		public Actions action;
		public JavascriptExecutor js;
		
		@BeforeMethod
		public void Launch_Browser() {
			driver=new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.hashtag-ca.com/careers/apply?jobCode=QAE001");

		}
		@Test(priority = 0)
		public void header_Links() throws Exception {

			// Click on Contact us
			driver.findElement(By.xpath("//a[text()='Contact Us ']")).click();
			Thread.sleep(1000);
			System.out.println("Contact Us Title:-" + driver.getTitle());
			driver.navigate().back();

			// Click on About us
			driver.findElement(By.xpath("//a[text()='About Us ']")).click();
			Thread.sleep(1000);
			System.out.println("About Us Titlt:-" + driver.getTitle());
			driver.navigate().back();

			// Click on Case Studies
			driver.findElement(By.xpath("//a[text()='Case studies ']")).click();
			Thread.sleep(1000);
			System.out.println("Case Studies Title:-" + driver.getTitle());
			driver.navigate().back();

			// Click on Careers
			driver.findElement(By.xpath("//a[text()='Careers ']")).click();
			Thread.sleep(1000);
			System.out.println("Careers Title:-" + driver.getTitle());
			driver.navigate().back();

		    // Click on Blog
			driver.findElement(By.xpath("//a[text()='Blog ']")).click();
			Thread.sleep(1000);
			System.out.println("Blog Title:-" + driver.getTitle());
			driver.navigate().back();

			// Click on Shopify
			driver.findElement(By.xpath("//a[text()='Shopify ']")).click();
			Thread.sleep(1000);
			System.out.println("Shopify Title:-" + driver.getTitle());
			driver.navigate().back();
			
			// EN Button
			driver.findElement(By.xpath("//div[@class='form-inline my-2 my-lg-0']/button[1]/a")).click();
			System.out.println("---------------");
				// Lets Speak
			driver.findElement(By.xpath("//div[@class='form-inline my-2 my-lg-0']/button[2]/a")).click();
			driver.close();
			}
		@Test(priority = 1)
		public void Verify_middle_UI_elements() {

			// Enter User Name
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");
			WebElement user_name = driver.findElement(By.xpath("//input[@placeholder='Enter your name']"));
			user_name.sendKeys("Peter");
			System.out.println("Entered User Name is:- " + user_name.getAttribute("value"));

			// Enter User Email
			WebElement user_Email = driver.findElement(By.xpath("//input[@type='email']"));
			user_Email.sendKeys("peter12@gmail.com");
			System.out.println("Entered User Email is:- " + user_Email.getAttribute("value"));

			// Enter User Mobile Number
			WebElement user_Number = driver.findElement(By.xpath("//input[@type='number']"));
			user_Number.sendKeys("9867452314");
			System.out.println("Entered User Mob.Number is:- " + user_Number.getAttribute("value"));

			// Upload User Resume
			driver.findElement(By.xpath("//input[@id='inputFile']")).sendKeys("D:\\Desktop\\Sneha Falke.docx");

			// Enter User Description
			WebElement user_description = driver
					.findElement(By.xpath("//textarea[@placeholder='Briefly Describe Yourself']"));
			user_description.sendKeys("Schedule My Interview ASAP");
			System.out.println("Entered User Description is:-" + user_description.getAttribute("value"));
			
		}
		@Test(priority = 2)
		public void verify_footer_section() throws Exception {

			action = new Actions(driver);
			action.sendKeys(Keys.END).build().perform();

			// Click On Facebook Logo
			WebElement social_Icon_1 = driver.findElement(By.id("footer-linkedin"));
			System.out.println("Click on Social media_1 is:- " + social_Icon_1.getAttribute("alt"));
			social_Icon_1.click();

			// To Switch Child Window-1
			Set<String> tab_1 = driver.getWindowHandles();
			Iterator<String> it_1 = tab_1.iterator();
			String parent_Tab_id_1 = it_1.next();
			String child_Tab_id_1 = it_1.next();

			driver.switchTo().window(child_Tab_id_1);
			System.out.println("Home Page Window id:- " + parent_Tab_id_1);
			System.out.println("Linkedin Window id:- " + child_Tab_id_1);

		    // To dismiss sign in pop-up
			driver.findElement(By.xpath("(//button[@aria-label='Dismiss'])[1]")).click();
			System.out.println("After Clicking on Linkein Webpage title is :- " + driver.getTitle());

			// Switch To Home Page window
			driver.switchTo().window(parent_Tab_id_1);
			action.sendKeys(Keys.END).build().perform();
			WebElement facebook_Icon = driver.findElement(By.id("footer-fb"));
			System.out.println("Click on Social Media _2 is :-" + facebook_Icon.getAttribute("alt"));
			facebook_Icon.click();

			// to Switch Child Window- 2
			Set<String> tab_2 = driver.getWindowHandles();
			Iterator<String> it_2 = tab_2.iterator();
			String parent_Tab_id_2 = it_2.next();
			String child_Tab_id_2 = it_2.next();
			String child_Tab_id_3 = it_2.next();
			driver.switchTo().window(child_Tab_id_3);
			System.out.println("Facebook Window id:- " + child_Tab_id_3);

			//To dismiss Sign-in Pop-up
			driver.findElement(By.xpath("//div[@class='x92rtbv x10l6tqk x1tk7jg1 x1vjfegm']/div")).click();
			System.out.println("After click on Facebook icon Page title is:-" + driver.getTitle());

			  // Switch to Home page Window
		    driver.switchTo().window(parent_Tab_id_1);
			action.sendKeys(Keys.END).build().perform();
			WebElement instagram_icon = driver.findElement(By.id("footer-instagram"));
			System.out.println("Click on Social Media _3 is :-" + instagram_icon.getAttribute("alt"));
			instagram_icon.click();
			
		}
		@AfterMethod
		public void close(){
			driver.quit();

		}
			
	}


