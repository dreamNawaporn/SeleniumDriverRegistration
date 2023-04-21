import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterAksorn {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\webdriver\\chromedriver2.exe"); // Replace with the path to
																							// your
		// ChromeDriver executable
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get(
				"https://oneaccount.aksorn.com/register?client_id=38b0c553-0085-4e35-8059-00676d6c02af&redirect_uri=https%3A%2F%2Fwww.aksorn.com%2Fapi%2Foauth%2Fauthorize&response_type=code&scope=");

		driver.findElement(By.xpath("//span[contains(text(), 'คำนำหน้าชื่อ')]")).click();

		WebElement titleSelect = driver.findElement(By.xpath("//input[@class='select2-search__field']"));
		titleSelect.sendKeys("นางสาว");
		titleSelect.sendKeys(Keys.ENTER);

		driver.findElement(By.name("first_name")).sendKeys("นวพร");

		driver.findElement(By.name("last_name")).sendKeys("บุญก่อน");

		new Select(driver.findElement(By.xpath("//*[@id=\"gender\"]"))).selectByValue("N");

		driver.findElement(By.xpath("//*[@id=\"select2-birth_year-container\"]")).click();

		WebElement birthYearSelect = driver.findElement(By.xpath("//input[@class='select2-search__field']"));
		birthYearSelect.sendKeys("2545");
		birthYearSelect.sendKeys(Keys.ENTER);

		driver.findElement(By.name("email")).sendKeys("644259029@webmail.npru.ac.th");

		driver.findElement(By.name("mobile_no")).sendKeys("0928811045");

		driver.findElement(By.name("password")).sendKeys("Dream4183113"); // Replace with the decrypted
																		// password

		driver.findElement(By.name("password_confirmation")).sendKeys("Dream4183113"); // Replace
																						// with
																						// the
																						// decrypted
																						// password
																						// confirmation

		new Select(driver.findElement(By.xpath("//*[@id=\"role_cd\"]"))).selectByValue("STUDENT");

		driver.findElement(By.xpath("//*[@id=\"select2-school_id-container\"]/span")).click();

		WebElement schoolSelect = driver.findElement(By.xpath("/html/body/span/span/span[1]/input"));
		schoolSelect.sendKeys("วิทยาลัยเทคโนโลยีบริหารธุรกิจกาญจนบุรี");
		Thread.sleep(1000);
		schoolSelect.sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//span[@class='checkbox-icon fuse-ripple-ready']")).click();

//		driver.findElement(By.xpath("//*[@id=\"btnRegister\"]")).click();
		try {
			WebElement registerButton = driver.findElement(By.xpath("//*[@id=\"btnRegister\"]"));
			System.out.println("พบปุ่ม btnRegister");
		} catch (NoSuchElementException e) {
			System.out.println("ไม่พบปุ่ม btnRegister");
		}

		String title = driver.getTitle();
		System.out.println(title);

		Thread.sleep(0);
		driver.quit();
	}
}

//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.Test;
//
//class RegisterAksorn {
//
//	@Test
//	void test() {
//		System.setProperty("webdriver.chrome.driver", "D:\\webdriver\\chromedriver2.exe");
//	}
//
//}
//D:\\webdriver\\chromedriver2.exe
