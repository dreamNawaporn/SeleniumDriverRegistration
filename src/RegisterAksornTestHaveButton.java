import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegisterAksornTestHaveButton {
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
		titleSelect.sendKeys("นาย");
		titleSelect.sendKeys(Keys.ENTER);

		driver.findElement(By.name("first_name")).sendKeys("วรปกร");

		driver.findElement(By.name("last_name")).sendKeys("จารุศิริพจน์");

		new Select(driver.findElement(By.xpath("//*[@id=\"gender\"]"))).selectByValue("M");

		driver.findElement(By.xpath("//*[@id=\"select2-birth_year-container\"]")).click();

		WebElement birthYearSelect = driver.findElement(By.xpath("//input[@class='select2-search__field']"));
		birthYearSelect.sendKeys("2546");
		birthYearSelect.sendKeys(Keys.ENTER);

		driver.findElement(By.name("email")).sendKeys("644259018@webmail.npru.ac.th");

		driver.findElement(By.name("mobile_no")).sendKeys("0623844415");

		driver.findElement(By.name("password")).sendKeys("a123456789"); // Replace with the decrypted
																		// password

		driver.findElement(By.name("password_confirmation")).sendKeys("a123456789"); // Replace
																						// with
																						// the
																						// decrypted
																						// password
																						// confirmation

		new Select(driver.findElement(By.xpath("//*[@id=\"role_cd\"]"))).selectByValue("STUDENT");

		driver.findElement(By.xpath("//*[@id=\"select2-school_id-container\"]/span")).click();

		WebElement schoolSelect = driver.findElement(By.xpath("/html/body/span/span/span[1]/input"));
		schoolSelect.sendKeys("สิรินธรราชวิทยาลัย");
		Thread.sleep(1000);
		schoolSelect.sendKeys(Keys.ENTER);

//		driver.findElement(By.xpath("//span[@class='checkbox-icon fuse-ripple-ready']")).click();

//		driver.findElement(By.xpath("//*[@id=\"btnRegister\"]")).click();
//        List<WebElement> registerButtons = driver.findElements(By.xpath("//*[@id=\"btnRegister\"]"));
//        Assert.assertEquals("พบปุ่ม btnRegister", 0, registerButtons.size());

		try {
			WebElement registerButton = driver.findElement(By.xpath("//*[@id=\"btnRegister\"]"));
			System.out.println("พบปุ่ม btnRegister");
			if (registerButton.isEnabled()) {
			    System.out.println("ปุ่ม \"ลงทะเบียน\" เปิดใช้งาน");
			} else {
			    System.out.println("ปุ่ม \"ลงทะเบียน\" ปิดใช้งาน");
			}
			
			String disabledAttr = registerButton.getAttribute("disabled");
			if (disabledAttr == null) {
			    System.out.println("ปุ่ม \"ลงทะเบียน\" เปิดใช้งาน");
			} else {
			    System.out.println("ปุ่ม \"ลงทะเบียน\" ปิดใช้งาน");
			}

		} catch (NoSuchElementException e) {
			System.out.println("ไม่พบปุ่ม btnRegister");
		}

		String title = driver.getTitle();
		System.out.println(title);

		Thread.sleep(1000);
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