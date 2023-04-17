package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.interactions.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class NagLandingPage {
	
	By services =  By.xpath("//a[@data-mega-menu-id='megaMenuServices']");
	By qualitytest =  By.xpath("//a[text()='accelerated quality & test-engineering' and @class='brand-link-03 small-text']");
	
	By header = By.xpath("//h4[contains(text(),'featured offerings')]");
	By findroiheader = By.xpath("//h3[contains(text(), 'Test Automation ROI Calculator')]/..");
	By findroibutton = By.xpath("//span[text()='Find out your ROI']");
	By clickfindout  = By.cssSelector("#startSurvey");
	
	//Sliders Page
	By nextButton = By.xpath("//div[@class=\"roiQues_wrapper\"][1]/div[1]/div[1]/div[2]/a");
	By automationCandidate  = By.cssSelector("#automationCandidates");
	By projectDuration  = By.cssSelector("#projectDuration");
	By platformSupported  = By.cssSelector("#platformSupported");
	By execution  = By.cssSelector("#execution");
	By setUpTime  = By.cssSelector("#setUpTime");
	By trainingTime  = By.cssSelector("#trainingTime");
	By designTime  = By.cssSelector("#designTime");
	By highComplexity  = By.cssSelector("#highComplexity");
	By mediumComplexity  = By.cssSelector("#mediumComplexity");
	By plannedAutomation  = By.cssSelector("#plannedAutomation");
	By testEngineerCost  = By.cssSelector("#testEngineerCost");
	
	By calculateRoiButton  = By.xpath("//div[@class='controlss-wrapper hide-controls hide-mobile']/a[text()='Calculate your ROI']");
	
	//signup
	By lastname = By.xpath("//input[@name='lastname']");
	By company = By.xpath("//input[@name='company']");
	By email = By.xpath("//input[@name='email']");
	By submitButton = By.xpath("//input[@type='submit']");
	
	//download
	By downloadpdf = By.xpath("//button[@onclick='Convert_HTML_To_PDF();']");
	
	
	public WebElement findElement(WebDriver driver, By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
			return null; 
		}
	} 
	public void hoverElement(WebDriver driver, By locator) {
		Actions action = new Actions(driver);
		try {
			action.moveToElement(findElement(driver, locator)).perform();
		
		} catch (Exception e) {
			System.out.println("Not able to hover on element due to following error = "+ e);		}
	}
	
	public void clickElement(WebDriver driver, By locator) {
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, 60);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			element.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
	
	public void enterText(WebDriver driver, By locator, String text) {
		try {
			WebElement element = findElement(driver, locator);
			element.click();
			element.clear();
			element.sendKeys(text);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
	
	public void scrollToElement(WebDriver driver, By locator){
		try{
			org.openqa.selenium.interactions.Coordinates coordinate = ((Locatable) findElement(driver, locator)).getCoordinates();
			coordinate.inViewPort();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
	
	public void HoverServicesTab(WebDriver driver) {
		hoverElement(driver, services);
	}
	
	public void clickTestQualityOption(WebDriver driver) {
		clickElement(driver, qualitytest);
	}
	
	public void clickFindROI(WebDriver driver) {
		driver.findElement(By.id("hs-eu-confirmation-button")).click();
		hoverElement(driver, header);
		hoverElement(driver, findroiheader);
		clickElement(driver, findroibutton);
		clickElement(driver, clickfindout);
	}
	
	public void send(WebDriver driver) {
		clickElement(driver, nextButton);
	}
	
	//calculate roi
	public void clickCalculateRoiButton(WebDriver driver) {
		clickElement(driver, calculateRoiButton);
	}
	
	public void signupDetails(WebDriver driver, String name, String com, String mail) {
		enterText(driver, lastname, name);
		enterText(driver, company, com);
		enterText(driver, email, mail);
		clickElement(driver, submitButton);
	}
	
	public void downloadPdf(WebDriver driver) {
		clickElement(driver, downloadpdf);
	}

}
