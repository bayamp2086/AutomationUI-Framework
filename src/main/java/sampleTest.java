import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class sampleTest {

	//public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		@Test
		public void login() throws InterruptedException
		{
			System.setProperty("webdriver.chrome.driver", "C:\\eclipsews\\FreeCRMProject\\src\\main\\resources\\Resource\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.get("https://www.freecrm.com");
			System.out.println("Application launched successfully");
			
			String title=driver.getTitle();
			System.out.println(title);
			
			driver.findElement(By.xpath("//span[contains(text(),'Log In')]")).click();
			//driver.navigate().to("https://ui.cogmento.com/");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys("divyakalai2010@gmail.com");
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("ragav@2020");
			driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();
			
			String homeTitle=driver.getTitle();
			System.out.println(homeTitle);
			
			
			driver.quit();

		}

}
