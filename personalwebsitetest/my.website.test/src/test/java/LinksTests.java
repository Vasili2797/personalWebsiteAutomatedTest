import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class LinksTests {
	protected static String baseURL = "https://reactpersonalwebsite.netlify.app/";

	@SuppressWarnings("deprecation")
	@Test
	public void makeSureGitHubLinkWorks() {
		var EdgeDriverPath = "C:\\Users\\nashv\\Downloads\\edgedriver_win64\\msedgedriver.exe";
		System.setProperty("webdriver.edge.driver", EdgeDriverPath);
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(baseURL);
		driver.findElement(By.linkText("GitHub")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		var currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);
//		assertEquals(currentURL, "https://github.com/Vasili2797/", "Wrong Github Link");
//		driver.quit();
	}
}
