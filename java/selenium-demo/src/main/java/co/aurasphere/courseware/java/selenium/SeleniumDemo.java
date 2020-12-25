package co.aurasphere.courseware.java.selenium;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class SeleniumDemo {

	public static WebDriver configureDriver() {
		URL url = SeleniumDemo.class.getClassLoader().getResource("chromedriver.exe");
		File file = new File(url.getFile());
		ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(file)
				.usingAnyFreePort().build();
		return new ChromeDriver(service);
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = configureDriver();

		// Opens Chrome
		driver.get("https://www.google.com");

		// Waits for the "Before you continue window" to display and dismisses it.
		Thread.sleep(4000);
		driver.switchTo().frame(0);
		driver.findElement(By.id("introAgreeButton")).click();

		// Searches something
		WebElement searchInput = driver.findElement(By.cssSelector("input[type=text]"));
		searchInput.sendKeys("Youtube");
		searchInput.sendKeys(Keys.ENTER);

		// Closes the browser
		Thread.sleep(3000);
		driver.close();
	}

}