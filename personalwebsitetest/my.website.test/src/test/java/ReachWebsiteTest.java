import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class ReachWebsiteTest {

	@Test
	public void makeTestRun() {
		var EdgeDriverPath="C:\\Users\\nashv\\Downloads\\edgedriver_win64\\msedgedriver.exe";
		System.setProperty("webdriver.edge.driver", EdgeDriverPath);
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/webhp?hl=en&ictx=2&sa=X&ved=0ahUKEwiJytePluSEAxWghIkEHTERD-MQPQgK");
		var title = driver.getTitle();
		System.out.println(title);
		var realTitle = "Google";
		driver.quit();
		assertEquals(title, realTitle, "This websiste is not Google");
	}

	@Test
	public void gettoPersonalWebSite() {
		var EdgeDriverPath="C:\\Users\\nashv\\Downloads\\edgedriver_win64\\msedgedriver.exe";
		System.setProperty("webdriver.edge.driver", EdgeDriverPath);
		WebDriver driver = new EdgeDriver();
		driver.navigate().to("https://reactpersonalwebsite.netlify.app/");
		driver.manage().window().maximize();
		String webTitle = driver.findElement(By.xpath("//a[contains(text(),'Personal Webpage of Vasili Nashvilli')]"))
				.getText();
		
		String actualTitle = "Personal Webpage of Vasili Nashvilli";
		assertEquals(webTitle, actualTitle, "Wrong website title");
		driver.quit();
	}
}
