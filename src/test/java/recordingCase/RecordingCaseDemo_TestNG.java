/*Author : Jigar Soni
 * 
 */
//Reference Naveen AutomationLab And Anmol Bagga
//monte-screen-recorder

package recordingCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screenRecorderUtil.MyScreenRecorder;

public class RecordingCaseDemo_TestNG {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod()
	public void setUp() throws Exception {
		String projectpath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectpath+"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		MyScreenRecorder.startRecording("Main");
		driver.get("https://www.hudl.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait=new WebDriverWait(driver, 30);
		}

	@Test
	public void test() throws Exception {
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("email")).sendKeys("anmol_bagga10@yahoo.co.in");
		driver.findElement(By.id("password")).sendKeys("anmolbagga10");
		driver.findElement(By.id("logIn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='hui-globalnav__item hui-globalnav__home']")));
		driver.navigate().to("https://www.google.com");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lga")));
		
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='hui-globalnav__item hui-globalnav__home']")));
		
		driver.navigate().forward();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lga")));
		
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='hui-globalnav__item hui-globalnav__home']")));
		
		driver.navigate().forward();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lga")));
		
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='hui-globalnav__item hui-globalnav__home']")));
		
		driver.navigate().forward();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lga")));
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		MyScreenRecorder.stopRecording();
		driver.quit();
	}
}