package week2.day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafTapsDeleteLead {

	public static void main(String[] args) throws InterruptedException {

		// To setup the driver
		WebDriverManager.chromedriver().setup();

		// Open the chrome browser
		ChromeDriver driver = new ChromeDriver();

		// Code to maximize the browser window
		driver.manage().window().maximize();

		// Code to open the URL
		driver.get("http://leaftaps.com/opentaps/control/main");

		// Identify and enter the username
		WebElement username = driver.findElementById("username");
		Thread.sleep(1000);
		username.sendKeys("demosalesmanager");

		// Enter the password
		Thread.sleep(1000);
		driver.findElementById("password").sendKeys("crmsfa");
		// password.sendKeys("crmsfa");

		// Click on the Login button
		Thread.sleep(1000);
		driver.findElementByClassName("decorativeSubmit").click();

		// Click on the CRM/SFA link
		Thread.sleep(1000);
		driver.findElementByPartialLinkText("SFA").click();

		// Click on the LEADS tab
		driver.findElementByLinkText("Leads").click();

		// Click Find leads
		driver.findElementByXPath("//a[text()='Find Leads']").click();

		// Click on Phone
		driver.findElementByXPath("(//span[@class='x-tab-strip-inner'])[2]/span").click();

		// Enter phone number 99
		driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys("99");

		// Click on Find leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();

		Thread.sleep(1000);

		// Click on first resulting lead
		WebElement Lead = driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/child::a");
		String ID = Lead.getText();
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/child::a").click();

		// Click on delete
		driver.findElementByXPath("//a[@class='subMenuButtonDangerous']").click();

		// Click on Find leads
		driver.findElementByXPath("//a[@href='/crmsfa/control/findLeads']").click();
		Thread.sleep(2000);
		
		// Enter Capture lead ID
		driver.findElementByXPath("//input[@name='id']").sendKeys(ID);
		
		//Enter Find Leads button
		driver.findElementByXPath("(//button[@class='x-btn-text'])[7]").click();
		Thread.sleep(1000);
		
		// Verify 'No records to display' is displayed
		boolean display = driver.getPageSource().contains("No records to display");
		if (display == true) {
			System.out.println("No records to display");
		} else {
			System.out.println("REcords found");
		}
		
		//Close the browser
		driver.close();

	}

}
