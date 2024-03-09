import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class ContactsPageTests {
	protected static String baseURL = "https://reactpersonalwebsite.netlify.app/";

	@Test
	public void makeSureUserCanGetToContactsPage() {
		var EdgeDriverPath = "C:\\Users\\nashv\\Downloads\\edgedriver_win64\\msedgedriver.exe";
		System.setProperty("webdriver.edge.driver", EdgeDriverPath);
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(baseURL);
		driver.findElement(By.linkText("Contact")).click();
		var PageTitle = driver.findElement(By.xpath("//h2[contains(text(), 'Contact')]")).getText();

		assertEquals(PageTitle, "Contact", "Not on Contacts Page");
		driver.quit();
	}

	@Test
	public void insertAllInformationAndSubmit() throws InterruptedException {
		var EdgeDriverPath = "C:\\Users\\nashv\\Downloads\\edgedriver_win64\\msedgedriver.exe";
		System.setProperty("webdriver.edge.driver", EdgeDriverPath);
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(baseURL);
		driver.findElement(By.linkText("Contact")).click();

		driver.findElement(By.xpath("//*[@id='name'][2]")).click();
		driver.findElement(By.xpath("//*[@id='name'][2]")).sendKeys("Name testing Purposes");
		
		driver.findElement(By.xpath("//*[@id='email'][2]")).click();
		driver.findElement(By.xpath("//*[@id='email'][2]")).sendKeys("emailAddress@email.net");

		driver.findElement(By.xpath("//*[@name='Service']")).click();
		driver.findElement(By.xpath("//*[@name='Service']"))
				.sendKeys("Sending services required information in textarea");	
		
		var inputNameText=driver.findElement(By.xpath("//*[@id='name'][2]")).getAttribute("value");
		System.out.println("The inputted text: "+inputNameText);
		var inputEmailText=driver.findElement(By.xpath("//*[@id='email'][2]")).getAttribute("value");
		System.out.println("The email inputted "+inputEmailText);
		var inputMessageText= driver.findElement(By.xpath("//*[@name='Service']")).getAttribute("value");
		System.out.printf("The message inputted was %s",inputEmailText);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='submit']")).click();
//		Thread.sleep(3000);
		var confirmationLink=driver.getCurrentUrl();
		
		assertEquals(inputNameText, "Name testing Purposes", "Expected a different name input");
		assertEquals(inputEmailText, "emailAddress@email.net", "Expected a different email input");
		assertEquals(inputMessageText, "Sending services required information in textarea", "Exepected a different message");
		assertEquals(confirmationLink, "https://reactpersonalwebsite.netlify.app/ConfirmationLink", "Expected a different confirmation link");
		driver.quit();
	}
}
