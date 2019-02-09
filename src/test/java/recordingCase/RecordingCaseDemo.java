/*Author : Jigar Soni
 * 
 */
//Reference Naveen AutomationLab
//Anmol Bagga

package recordingCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import screenRecorderUtil.MyScreenRecorder;

public class RecordingCaseDemo {

	public static void main(String[] args) throws Exception {

		String projectpath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectpath+"/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		MyScreenRecorder.startRecording("Main");
		driver.get("https://www.hudl.com/");

		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("email")).sendKeys("anmol_bagga10@yahoo.co.in");
		driver.findElement(By.id("password")).sendKeys("anmolbagga10");
		driver.findElement(By.id("logIn")).click();

		Thread.sleep(5000);

		driver.navigate().to("https://www.google.com");

		driver.navigate().back();
		driver.navigate().forward();

		driver.navigate().back();
		driver.navigate().forward();

		driver.navigate().back();
		driver.navigate().forward();

		MyScreenRecorder.stopRecording();
		driver.quit();

	}

}
