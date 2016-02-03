package com.sqa.jf.drivers;

import java.util.*;
import java.util.concurrent.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.safari.*;
import org.testng.*;
import org.testng.annotations.*;

public class BasicTest {

	private boolean acceptNextAlert = true;

	private String baseUrl;

	private WebDriver driver;

	private StringBuffer verificationErrors = new StringBuffer();

	@Test(groups = "basic-test")
	public void basicTest() throws Exception {
		// TODO Implement Core Test Here
		this.baseUrl = "http://craigslist.com";
		this.driver.get(this.baseUrl + "/");
		this.driver.findElement(By.cssSelector("a.jjj > span.txt")).click();
		this.driver.findElement(By.id("query")).clear();
		this.driver.findElement(By.id("query")).sendKeys("qa java selenium");
		this.driver.findElement(By.xpath("//button[@type='submit']")).click();
		List<WebElement> jobs = this.driver.findElements(By.cssSelector("p.row > a.i"));
		System.out.println("Keywords: " + "qa java selenium");
		for (WebElement job : jobs) {
			System.out.println(job.getAttribute("href"));
		}
	}

	@DataProvider
	public Object[][] keywordData() {
		// TODO Add A Valid DataProvider for Data Driven Testing
		return new Object[][] { new Object[] { "qa selenium" }, new Object[] { "java junior" },
				new Object[] { "programmer junior" } };
	}

	@BeforeClass(groups = "chrome")
	public void setUpChrome() throws Exception {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@BeforeClass(groups = "firefox")
	public void setUpFirefox() throws Exception {
		this.driver = new FirefoxDriver();
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@BeforeClass(groups = "ie")
	public void setUpIE() throws Exception {
		System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
		this.driver = new InternetExplorerDriver();
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@BeforeClass(groups = "safari")
	public void setUpSafari() throws Exception {
		this.driver = new SafariDriver();
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		this.driver.quit();
		String verificationErrorString = this.verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			Assert.fail(verificationErrorString);
		}
	}
	// ALERT HANDLING / ELEMENT FOUND HANDLING
	//
	// private String closeAlertAndGetItsText() {
	// try {
	// Alert alert = this.driver.switchTo().alert();
	// String alertText = alert.getText();
	// if (this.acceptNextAlert) {
	// alert.accept();
	// } else {
	// alert.dismiss();
	// }
	// return alertText;
	// } finally {
	// this.acceptNextAlert = true;
	// }
	// }
	//
	// private boolean isAlertPresent() {
	// try {
	// this.driver.switchTo().alert();
	// return true;
	// } catch (NoAlertPresentException e) {
	// return false;
	// }
	// }
	//
	// private boolean isElementPresent(By by) {
	// try {
	// this.driver.findElement(by);
	// return true;
	// } catch (NoSuchElementException e) {
	// return false;
	// }
	// }
}
