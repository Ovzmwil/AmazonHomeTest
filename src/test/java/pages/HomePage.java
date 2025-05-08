package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConfigReader;

public class HomePage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private final static String HOME_URL = "https://www.amazon.com.br";
	
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchBox;
	
	@FindBy(id = "sac-autocomplete-results-container")
	WebElement suggestions;
	
	@FindBy(css = "#nav-xshop a")
	List<WebElement> menuItems;
	
	@FindBy(id = "nav-hamburger-menu")
	WebElement burgerMenu;
	
	@FindBy(id = "hmenu-content")
	WebElement openedBurgerMenu;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(ConfigReader.getProperty("wait.timeout"))));
	}
	
	public void goToHomePage() {
		driver.get(HOME_URL);
	}
	
	public void typeInSearchBox(String word) {
		wait.until(ExpectedConditions.visibilityOf(searchBox));
		searchBox.sendKeys(word);
	}
	
	public boolean suggestionsIsVisible() {
		WebElement element = wait.until(ExpectedConditions.visibilityOf(suggestions));
		return element != null;
	}
	
	public boolean suggestionsIsNotVisible() {
		return wait.until(ExpectedConditions.invisibilityOf(suggestions));
	}
	
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}
	
	public void setBrowserDimension() {
		int height = Integer.parseInt(ConfigReader.getProperty("mobile.height"));
		int lenght = Integer.parseInt(ConfigReader.getProperty("mobile.lenght"));
		driver.manage().window().setSize(new Dimension(lenght, height));
	}
	
	public int menuItemsSize() {
		return menuItems.size();
	}
	
	public boolean burgerMenuIsWorking() {
		wait.until(ExpectedConditions.visibilityOf(burgerMenu));
		burgerMenu.click();
		WebElement element = wait.until(ExpectedConditions.visibilityOf(openedBurgerMenu));
		
		return element != null;
	}
	
	
}
