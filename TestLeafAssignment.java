package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;

public class TestLeafAssignment {

	public void editPage() throws InterruptedException {
		// To setup the driver
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Selenium\\chromedriver_win32\\chromedriver.exe");

		// Open the chrome browser
		ChromeDriver driver = new ChromeDriver();

		// Code to maximize the browser window
		driver.manage().window().maximize();

		// Code to open the URL
		driver.get("http://leafground.com/pages/Edit.html");

		Thread.sleep(1000);

		// Enter your Email Address
		driver.findElementByXPath("//input[@id='email']").sendKeys("shs01@yopmail.com");

		Thread.sleep(1000);
		// Append a text and press keyboard tab
		driver.findElementByXPath("(//input[@type='text'])[2]").sendKeys("This is appended text");
		driver.findElementByXPath("(//input[@type='text'])[2]").sendKeys(Keys.TAB);

		// Get default text entered
		String Text=driver.findElementByXPath("//input[@name='username']").getText();
	    System.out.println(Text);

		// Clear the text
		driver.findElementByXPath("//input[@value='Clear me!!']").clear();

		// Confirm that edit field is disabled
		WebElement verifyDisable = driver.findElementByXPath("//label[@for='disabled']/following-sibling::input");
		if (!verifyDisable.isEnabled()) {
			System.out.println("The edit field is disabled");
		}
		System.out.println("Part1 - Edit page is completed");
		Thread.sleep(2000);
		driver.close();
	}

	public void buttonPage() throws InterruptedException {
		Thread.sleep(2000);

		// To setup the driver
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Selenium\\chromedriver_win32\\chromedriver.exe");

		// Open the chrome browser
		ChromeDriver driver = new ChromeDriver();

		// Code to maximize the browser window
		driver.manage().window().maximize();

		// Code to open the URL
		driver.get("http://leafground.com/pages/Button.html");

		// Click button to travel to home page
		driver.findElementByXPath("//button[@id='home']").click();
		Thread.sleep(2000);

		// Click on the Button to navigate back to Bond with Buttons page
		driver.findElementByXPath("//img[@alt='Buttons']").click();

		// Find position of (x,y)
		Point location = driver.findElementByXPath("//button[@id='position']").getLocation();
		System.out.println("Position of (x,y): " + location);

		// Find button color
		String Color=driver.findElementByXPath("//button[@id='color']").getCssValue("color");
	    System.out.println("Color is:"+Color);

		// Find the Height and Width
		Dimension buttonSize = driver.findElementById("size").getSize();
		int width=buttonSize.getWidth();
	    int height=buttonSize.getHeight();
	    System.out.println("Width of button is : "+width);
	    System.out.println("Height of button is : "+height);

		System.out.println("Part2 - Bond with buttons is completed");
		Thread.sleep(2000);
		driver.close();
	}

	public void hyperLinks() throws InterruptedException {
		
		Thread.sleep(1000);
		// To setup the driver
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Selenium\\chromedriver_win32\\chromedriver.exe");

		// Open the chrome browser
		ChromeDriver driver = new ChromeDriver();

		// Code to maximize the browser window
		driver.manage().window().maximize();

		// Code to open the URL
		driver.get("http://leafground.com/pages/Link.html");
		
		Thread.sleep(2000);
		
		//Go to home page
		driver.findElementByXPath("(//a[@link='blue'])[1]").click();
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(1000);
		driver.findElementByLinkText("HyperLink").click();
		
		//Find where am supposed to go without clicking me?
		driver.findElementByPartialLinkText("supposed to go").click();
		driver.findElementByXPath("//img[@alt='logo Testleaf']").click();
		Thread.sleep(2000);
		driver.findElementByLinkText("HyperLink").click();
		
		//Verify am i broken?
		driver.findElementByXPath("(//div[@class='example'])[3]//a").click();
		String error =driver.getCurrentUrl();
	    String ExpectedURL = "http://leafground.com/pages/error.html";
	    	if (error .equalsIgnoreCase( ExpectedURL))
	        {
	        	System.out.println("This is an error page");
	        }
	    System.out.println(error);
		driver.navigate().back();
		
		Thread.sleep(2000);
		//Go to Home page
		driver.findElementByLinkText("Go to Home Page").click();
		Thread.sleep(2000);
		driver.findElementByLinkText("HyperLink").click();
		
		//Print the number of links in that page
		List<WebElement> link = driver.findElementsByTagName("a");
		System.out.println("Total number of links in 'Play with Hyperlinks' page is:" +" " +link.size());
		
		System.out.println("Part3 - Play with Hyperlinks is completed");
		Thread.sleep(2000);
		driver.close();
		
	}

	public void interactWithImages() throws InterruptedException
	{
		Thread.sleep(1000);
		// To setup the driver
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Selenium\\chromedriver_win32\\chromedriver.exe");

		// Open the chrome browser
		ChromeDriver driver = new ChromeDriver();

		// Code to maximize the browser window
		driver.manage().window().maximize();

		// Code to open the URL
		driver.get("http://leafground.com/pages/Image.html");
		
		Thread.sleep(2000);
		
		//Click on the image to go to home page
		driver.findElementByXPath("//label[@for='home']/following-sibling::img").click();
		System.out.println(driver.getCurrentUrl());
		
		//Am i Broken Image?
		driver.findElementByXPath("//img[@class='wp-categories-icon svg-image'][@src='images/image.png']").click();
        driver.findElementByXPath("//img[@src='../images/abcd.jpg']").click();
        String error =driver.getCurrentUrl();
        Thread.sleep(1000);
        String ExpURL = "http://leafground.com/home.html";
        	if (error != ExpURL )
        	{
        	System.out.println("Image is broken");
        	}
        	else{
        	System.out.println("Image is not broken");
        	}
       
        	
        //Click on Image using Mouse
        Actions action = new Actions(driver);
        WebElement image = driver.findElementByXPath("(//label[@for='position'])[2]/following-sibling::img");
        action.click(image).perform();
        Thread.sleep(1000);
        System.out.println(driver.getCurrentUrl());
        
        
        System.out.println("Part4 - Interact with Images is completed");
		Thread.sleep(2000);
		driver.close();
	}
	
	public void listBoxes() throws InterruptedException
	{
		Thread.sleep(1000);
		// To setup the driver
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Selenium\\chromedriver_win32\\chromedriver.exe");

		// Open the chrome browser
		ChromeDriver driver = new ChromeDriver();

		// Code to maximize the browser window
		driver.manage().window().maximize();

		// Code to open the URL
		driver.get("http://leafground.com/pages/Dropdown.html");
		
		Thread.sleep(2000);
		
		//Select by Index
		Select indexDD = new Select (driver.findElementById("dropdown1"));
		indexDD.selectByIndex(1);
		
		Thread.sleep(1000);
		//Select by Text
		Select byTextDD = new Select (driver.findElementByName("dropdown2"));
		byTextDD.selectByVisibleText("Appium");
		
		Thread.sleep(1000);
		//Select by Value
		Select byValueDD = new Select (driver.findElementById("dropdown3"));
		byValueDD.selectByValue("3");
		
		Thread.sleep(1000);
		//Get number of dropdown options
		WebElement dDOptions = driver.findElementByXPath("(//div[@class='example'])[4]/select");
		Select dropDown = new Select(dDOptions);
		List<WebElement> options = dropDown.getOptions();
		int size = options.size();
		System.out.println("Number of dropdown options : " +size);
		
		
		Thread.sleep(1000);
		//Select using Sendkeys
		driver.findElementByXPath("(//div[@class='example'])[5]/select").sendKeys("Loadrunner");
		
		Thread.sleep(1000);
		//Select your programs
		WebElement programsDD =driver.findElementByXPath("(//div[@class='example'])[6]/select");
	    Select index5=new Select(programsDD);
	    index5.selectByVisibleText("Appium");
	    index5.selectByVisibleText("UFT/QTP");
	    Thread.sleep(1000);
	    index5.deselectByVisibleText("UFT/QTP");
	    index5.selectByVisibleText("Selenium");
		
		
	    System.out.println("Part5 - Learn Listboxes is completed");
		Thread.sleep(2000);
		driver.close();
	}
	
	public void radioButtons() throws InterruptedException
	{
		Thread.sleep(1000);
		// To setup the driver
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Selenium\\chromedriver_win32\\chromedriver.exe");

		// Open the chrome browser
		ChromeDriver driver = new ChromeDriver();

		// Code to maximize the browser window
		driver.manage().window().maximize();

		// Code to open the URL
		driver.get("http://leafground.com/pages/radio.html");
		
		Thread.sleep(2000);
		
		//Are you enjoying the class
		driver.findElementById("yes").click();
		
		//Find default selected radio button
		boolean selected = driver.findElementByXPath("//label[@for='Checked']/input").isSelected();
		if (selected = true)
		{
			System.out.println("'Checked' radio button is selected");
		}
		else
		{
			System.out.println("Unchecked radio button is selected");
		}
		
		//Select your age group
		Thread.sleep(1000);
		int age = 26;
		WebElement age1to20 = driver.findElementByXPath("(//input[@value='0'])[3]");
		WebElement age21to40 = driver.findElementByXPath("(//input[@value='1'])[3]");
		WebElement ageAbove40 = driver.findElementByXPath("//input[@value='2']");
		
		if (age<=20)
		{
			if (age1to20.isSelected())
			{
				System.out.println("Age 1 to 20 radio button is already selected " +age);
			}
			else if (!age1to20.isSelected())
			{
				age1to20.click();
				System.out.println("Age 1 to 20 radio button is selected " +age);
			}
		}
		else if (age>=21 && age<=40)
		{
			if (age21to40.isSelected())
			{
				System.out.println(" Age 21 to 40 is already selected " +age);
			}
			else if (!age21to40.isSelected())
			{
				age21to40.click();
				System.out.println("Age 21 to 40 radio button is selected " + age);
			}
		}
		else
		{
			if (ageAbove40.isSelected())
			{
				System.out.println("Age above 40 is already selected " + age);
			}
			else 
			{
				ageAbove40.click();
				System.out.println("Age above 40 is selected " + age);
			}
		}
		
		System.out.println("Part6 - Play with Radio buttons is completed");
		Thread.sleep(2000);
		driver.close();
	}
	
	public void checkBoxes() throws InterruptedException
	{
		Thread.sleep(1000);
		// To setup the driver
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Selenium\\chromedriver_win32\\chromedriver.exe");

		// Open the chrome browser
		ChromeDriver driver = new ChromeDriver();

		// Code to maximize the browser window
		driver.manage().window().maximize();

		// Code to open the URL
		driver.get("http://leafground.com/pages/checkbox.html");
		
		Thread.sleep(2000);
		
		//Select the languages that you know
		driver.findElementByXPath("(//input[@type='checkbox'])").click();
		Thread.sleep(500);
		driver.findElementByXPath("(//input[@type='checkbox'])[2]").click();
		Thread.sleep(500);
		driver.findElementByXPath("(//input[@type='checkbox'])[3]").click();
		
		//Confirm Selenium is selected
		WebElement seleniumCB = driver.findElementByXPath("(//div/following::input)[6]");
		if (seleniumCB.isSelected())
		{
			System.out.println("Selenium Checkbox is selected");
		}
		else
		{
			System.out.println("Selenium Checkbox is not selected");
		}
		
		//Deselect only checked
		WebElement check1 = driver.findElementByXPath("(//div/following::input)[7]");
		WebElement check2 = driver.findElementByXPath("(//div/following::input)[8]");
		
		if(check1.isSelected())
		{
			check1.click();
		}
		Thread.sleep(1000);
		if (check2.isSelected())
		{
			check2.click();
		}
		
		//Select all checkboxes
		driver.findElementByXPath("(//div/following::input)[9]").click();
		Thread.sleep(500);
		driver.findElementByXPath("(//div/following::input)[10]").click();
		Thread.sleep(500);
		driver.findElementByXPath("(//div/following::input)[11]").click();
		Thread.sleep(500);
		driver.findElementByXPath("(//div/following::input)[12]").click();
		Thread.sleep(500);
		driver.findElementByXPath("(//div/following::input)[13]").click();
		
		System.out.println("Part7 - Interact with Checkboxes is completed");
		Thread.sleep(2000);
		driver.close();
	}
	
	public static void main(String[] args) throws InterruptedException {

		TestLeafAssignment obj = new TestLeafAssignment();
		obj.editPage();
		obj.buttonPage();
		obj.hyperLinks();
		obj.interactWithImages();
		obj.listBoxes();
		obj.radioButtons();
		obj.checkBoxes();
	}
}


