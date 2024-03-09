import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class ProjectsTest {
	protected static String baseURL="https://reactpersonalwebsite.netlify.app/";
	
	@Test
	public void userCanGoToMyProjectsPage() {
		var EdgeDriverPath="C:\\Users\\nashv\\Downloads\\edgedriver_win64\\msedgedriver.exe";
		System.setProperty("webdriver.edge.driver", EdgeDriverPath);
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(baseURL);
		driver.findElement(By.linkText("My Projects")).click();
		var actualTitle = driver.findElement(By.xpath("//div[@class='text-center mt-3 row']//h1")).getText();
		var expectedTitle = "The Following Are Few of My Personal Projects Hosted on GitHub";
		assertEquals(actualTitle, expectedTitle, "The title should be " + expectedTitle);
		driver.quit();
	}
	
	@Test
	public void countTheAmountofProjects() {
		var EdgeDriverPath="C:\\Users\\nashv\\Downloads\\edgedriver_win64\\msedgedriver.exe";
		System.setProperty("webdriver.edge.driver", EdgeDriverPath);
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(baseURL);
		driver.findElement(By.linkText("My Projects")).click();
		List<WebElement> projectsList = driver.findElements(By.xpath("//div[@class='figure-container']"));
		var sizeOfProjectList =projectsList.size();
		assertEquals(sizeOfProjectList, 7, "There should be 7 projects displayed");
		driver.quit();
	}
}
