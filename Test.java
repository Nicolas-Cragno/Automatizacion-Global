package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests {
	private WebDriver driver;
	@BeforeMethod
	public void setUp() {
		DesiredCapabilities caps = new  DesiredCapabilities();
		System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.consultoriaglobal.com.ar/cgweb/?page_id=370");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void pruebaUno() {
		driver.findElement(By.name("your-name")).sendKeys("user");
		driver.findElement(By.name("your-email")).sendKeys("user@user.com");
		driver.findElement(By.name("captcha-636")).sendKeys("user");
		driver.findElement(By.xpath("//*[@id=\"wpcf7-f1297-p370-o1\"]/form/p[7]/input")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"wpcf7-f1297-p370-o1\"]/form/div[2]")).getText().contains("Ocurrió un error de validación."));
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
