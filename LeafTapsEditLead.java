package week2.day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafTapsEditLead {

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

		// Enter First Name
		driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("Hari");

		// Click on Find Leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();

		Thread.sleep(2000);

		// Click on the first resulting lead
		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]//a[1]").click();

		// Verify the title of the page
		System.out.println(driver.getTitle());

		// Click on Edit
		driver.findElementByXPath("//a[text()='Edit']").click();

		// Change the company name
		driver.findElementById("updateLeadForm_companyName").clear();
		Thread.sleep(1000);
		driver.findElementById("updateLeadForm_companyName").sendKeys("ABC");

		// Click Update
		driver.findElementByXPath("//input[@value='Update']").click();

		// Confirm if the changed company name is displayed
		boolean compName = driver.findElementByXPath("//span[ contains (text(),'ABC')]").isDisplayed();
		if (compName = true) {
			System.out.println("The Changed Company Name is displayed correctly");
		}

		// Close the browser
		driver.close();
	}

}
