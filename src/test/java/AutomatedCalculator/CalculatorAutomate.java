package AutomatedCalculator;

import java.util.concurrent.TimeUnit;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;

public class CalculatorAutomate { 

	private static WindowsDriver CalculatorSession = null;
	private static WebElement CalculatorResult = null;

	@BeforeClass
	public static void setup() {
		try {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
			CalculatorSession = new WindowsDriver(new URL("http://127.0.0.1:4723/"), capabilities);
			CalculatorSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

//			CalculatorResult = CalculatorSession.findElement(By.id("CalculatorResults"));
//			Assert.assertNotNull(CalculatorResult);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

	@BeforeMethod
	public void Clear() {
		CalculatorSession.findElement(By.name("Clear")).click();
		//Assert.assertEquals("0", _GetCalculatorResultText());
	}

//    @AfterClass
//    public static void TearDown() {
//        if (CalculatorSession != null) {
//            CalculatorSession.quit();
//        }
//    }   

	@AfterClass
	public static void TearDown() {
		CalculatorResult = null;
		if (CalculatorSession != null) {
			CalculatorSession.quit();
		}
		CalculatorSession = null;
	}

	@Test
	public void Addition() throws InterruptedException {
		CalculatorSession.findElement(By.name("One")).click();
		Thread.sleep(2000);
		CalculatorSession.findElement(By.name("Plus")).click();
		Thread.sleep(2000);
		CalculatorSession.findElement(By.name("Seven")).click();
		Thread.sleep(2000);
		CalculatorSession.findElement(By.name("Equals")).click();
		Thread.sleep(2000);
		//Assert.assertEquals("8", _GetCalculatorResultText());
	}

	@Test
	public void Combination() throws InterruptedException {
		CalculatorSession.findElement(By.name("Seven")).click();
		Thread.sleep(2000);
		CalculatorSession.findElement(By.name("Nine")).click();
		Thread.sleep(2000);
		CalculatorSession.findElement(By.name("Plus")).click();
		Thread.sleep(2000);
		CalculatorSession.findElement(By.name("One")).click();
		Thread.sleep(2000);
		CalculatorSession.findElement(By.name("Equals")).click();
		Thread.sleep(2000);
		CalculatorSession.findElement(By.name("Divide by")).click();
		Thread.sleep(2000);
		CalculatorSession.findElement(By.name("Eight")).click();
		Thread.sleep(2000);
		CalculatorSession.findElement(By.name("Equals")).click();
		Thread.sleep(2000);
		//Assert.assertEquals("8", _GetCalculatorResultText());
	}

	@Test
	public void Division() throws InterruptedException {
		CalculatorSession.findElement(By.name("Eight")).click();
		Thread.sleep(2000);
		CalculatorSession.findElement(By.name("Eight")).click();
		Thread.sleep(2000);
		CalculatorSession.findElement(By.name("Divide by")).click();
		Thread.sleep(2000);
		CalculatorSession.findElement(By.name("One")).click();
		Thread.sleep(2000);
		CalculatorSession.findElement(By.name("One")).click();
		Thread.sleep(2000);
		CalculatorSession.findElement(By.name("Equals")).click();
		Thread.sleep(2000);
		//Assert.assertEquals("8", _GetCalculatorResultText());
	}

	@Test
	public void Multiplication() throws InterruptedException {
		CalculatorSession.findElement(By.name("Nine")).click();
		Thread.sleep(2000);
		CalculatorSession.findElement(By.name("Multiply by")).click();
		Thread.sleep(2000);
		CalculatorSession.findElement(By.name("Nine")).click();
		Thread.sleep(2000);
		CalculatorSession.findElement(By.name("Equals")).click();
		Thread.sleep(2000);
		//Assert.assertEquals("81", _GetCalculatorResultText());
	}

	@Test
	public void Subtraction() throws InterruptedException {
		CalculatorSession.findElement(By.name("Nine")).click();
		Thread.sleep(2000);
		CalculatorSession.findElement(By.name("Minus")).click();
		Thread.sleep(2000);
		CalculatorSession.findElement(By.name("One")).click();
		Thread.sleep(2000);
		CalculatorSession.findElement(By.name("Equals")).click();
		Thread.sleep(2000);
		//Assert.assertEquals("8", _GetCalculatorResultText());
	}

//	protected String _GetCalculatorResultText() {
//		// trim extra text and whitespace off of the display value
//		return CalculatorResult.getText().replace("Display is", "").trim();
//	}
}
