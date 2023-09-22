package qa.testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestMakeMyTrip extends TestBase {

	@Test
	void testAssignment() throws InterruptedException {
		// String URL = "https://www.makemytrip.com/flights/";
		Thread.sleep(3000);

		// closing extra window
		driver.findElement(
				By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/section[1]/span[1]"))
				.click();

		WebElement Flight = driver.findElement(By.xpath("//a[contains(@href,'www.makemytrip.com/flights')]"));
		Flight.click();
		Thread.sleep(5000);
		WebElement RoundTrip = driver.findElement(By.xpath("//li[contains(text(),'Round Trip')]"));
		RoundTrip.click();

		String From_loc = "HYD";
		String To_loc = "MAA";

		// userInputs From Locations
		driver.findElement(By.id("fromCity")).click();
		Thread.sleep(2000);
		WebElement FromField = driver.findElement(By.xpath("//input[@placeholder=\"From\"]"));
		FromField.sendKeys(From_loc);
		Thread.sleep(2000);
		driver.findElement(By.id("react-autowhatever-1-section-0-item-0")).click();

		// To Location
		driver.findElement(By.id("toCity")).click();
		Thread.sleep(2000);
		WebElement ToField = driver.findElement(By.xpath("//input[@placeholder=\"To\"]"));
		ToField.sendKeys(To_loc);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"react-autowhatever-1-section-0-item-0\"]")).click();

		// DepatureDate
		WebElement DepatureDate = driver.findElement(By.xpath("//div[@aria-label='Mon Oct 02 2023']"));
		Thread.sleep(2000);
		DepatureDate.click();

		driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();

		// ReturnDate
		WebElement ReturnDate = driver.findElement(By.xpath("//div[@aria-label='Mon Nov 06 2023']"));
		Thread.sleep(2000);
		ReturnDate.click();

		// SearchButton
		driver.findElement(By.xpath("//*[@class='primaryBtn font24 latoBold widgetSearchBtn ']")).click();
		Thread.sleep(15000);

		// WindowHandle
		WebElement popup = driver.findElement(By.xpath("//*[@class='bgProperties icon20 overlayCrossIcon']"));
		popup.click();

		// Validations
		String ExpectedHeading = "Flights from Hyderabad to Chennai, and back";
		WebElement ActualHeading = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div/div[2]/p/span"));
		String Actual = ActualHeading.getText();

		Assert.assertEquals(Actual, ExpectedHeading);
	}
}
