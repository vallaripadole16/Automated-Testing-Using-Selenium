package vallari;

import java.util.concurrent.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class testBySelenium {

	WebDriver driver;
	
	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vallari\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			//calling all functions
			testHomePage();
                        testLinksPage();
			testJoinUsPage();
			testPrograms();
			testContactUsPage();
                        testAboutUsPage();
			
		} 
                catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testHomePage() {
		try {
			driver.get("https://www.thesparksfoundationsingapore.org");
			//Test case 1: Checking for title
			if(driver.getTitle().contains("The Sparks Foundation")) {
				System.out.println("Title exists, title: " + driver.getTitle());
			}
			else {
				System.out.println("Title is not the same as expected.");
			}
			Thread.sleep(2000);
			//Test case 2: Checking for logo
			if(driver.findElement(By.xpath("//img[@src='/images/logo_small.png']")) != null) {
				System.out.println("Logo exists.");
			}
			else {
				System.out.println("Logo does not exist.");
			}
			Thread.sleep(2000);
			//Test case 3: Checking for navbar
			boolean navDisplayed = driver.findElement(By.tagName("nav")).isDisplayed();
			System.out.println("Navigation bar appears: " + navDisplayed);
			Thread.sleep(2000);
			
		} 
                catch (Exception e) {
			e.printStackTrace();
		}
	}
        
        public void testLinksPage() {
		try {
                        //Test case 4:Testing software and app page
			driver.get("https://www.thesparksfoundationsingapore.org/links/software-and-app/");
			Thread.sleep(2000);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testJoinUsPage() {
		try {
			driver.get("https://www.thesparksfoundationsingapore.org/join-us/why-join-us/");
			Thread.sleep(2000);
			// Test case 5:Checking name field, name - //input[@placeholder='Full Name']
			driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys("Vallari Padole");
			Thread.sleep(2000);
			// Test case 6:Checking email field, email/number - //input[@placeholder='Email or Phone Number']
			driver.findElement(By.xpath("//input[@placeholder='Email or Phone Number']")).sendKeys("vallaripadole16@gmail.com");
			Thread.sleep(2000);
			// Test case 7:Checking dropdown
			Select dropdown = new Select(driver.findElement(By.className("form-control")));
			dropdown.selectByVisibleText("Student");
			Thread.sleep(2000);
			dropdown.selectByVisibleText("Intern");
		} 
                catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void testContactUsPage() {
		try {
			driver.get("https://www.thesparksfoundationsingapore.org/contact-us/");
			Thread.sleep(2000);
			// Test case 8:Checking TSF NETWORK linkedin link
			driver.findElement(By.xpath("//a[contains(text(),'JOIN TSF NETWORK HERE (https://www.linkedin.com/gr')]")).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void testPrograms() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			driver.get("https://www.thesparksfoundationsingapore.org/programs/student-scholarship-program/");
			//Test case 9:Checking student mentorship
			driver.findElement(By.xpath("//div[@class='w3l_inner_section about-w3layouts']//li[1]")).click();
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,600)", "");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
        
        public void testAboutUsPage() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			driver.get("https://www.thesparksfoundationsingapore.org");
			Actions actions = new Actions(driver);
			//Test case 10:Checking element in about us page
			actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"link-effect-3\"]/ul/li[1]/a"))).click().moveToElement(driver.findElement(By.xpath("//*[@id=\"link-effect-3\"]/ul/li[1]/ul/li[1]/a"))).click().perform();
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		testBySelenium t = new testBySelenium();
		t.invokeBrowser();
		System.out.println("The test script has checked 6 pages and 10 elements in total.");
	}
}

